package com.cpfChecker.main.models;

import java.util.Scanner;

import com.cpfChecker.main.services.ConsumoApi;
import com.cpfChecker.main.services.CpfEstado;
import com.cpfChecker.main.services.JsonCapture;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import io.github.cdimascio.dotenv.Dotenv;

public class CpfConsult {

    public String cpfNumberInput() {
        var gson = new Gson();
        Scanner cpf = new Scanner(System.in);
        Dotenv dotenv = Dotenv.configure().directory("src/main/java/com/cpfChecker/main").filename(".env").load();
        System.out.print("Digite o CPF (somente números): ");
        String cpfnumber = cpf.nextLine();

        if (cpfnumber == null || cpfnumber.trim().isEmpty()) {
            cpf.close();
            return "CPF Inválido";
        }

        if (cpfnumber.length() != 11) {
            cpf.close();
            return "CPF Inválido";
        }

        try {
            String apiKey = dotenv.get("API_KEY");
            if (apiKey == null || apiKey.trim().isEmpty()) {
                cpf.close();
                return "Chave API não encontrada";
            }

            String json = new ConsumoApi().obterDados("https://api.invertexto.com/v1/validator?token=" + apiKey + "&value="
                    + cpfnumber + "&type=cpf");

            if (json == null) {
                cpf.close();
                return "Erro ao consultar API";
            }

            var jsonCap = gson.fromJson(json, JsonCapture.class);

            if (jsonCap == null) {
                cpf.close();
                return "Erro ao parsear JSON";
            }

            String estadoCpf = CpfEstado.estadoCpf(cpfnumber);
            cpf.close();
            return "CPF formatado: " + jsonCap.getFormatted() + "\n" + "CPF válido: " + jsonCap.getValid() + "\n" + "Estado: " + estadoCpf;
        } catch (JsonSyntaxException e) {
            cpf.close();
            return "Erro ao consultar API: " + e.getMessage();
        }
    }
}
