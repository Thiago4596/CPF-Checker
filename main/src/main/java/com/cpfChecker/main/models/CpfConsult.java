package com.cpfChecker.main.models;

import java.util.Scanner;

import com.cpfChecker.main.services.ConsumoApi;
import com.cpfChecker.main.services.CpfEstado;
import com.cpfChecker.main.services.JsonCapture;
import com.google.gson.Gson;

import io.github.cdimascio.dotenv.Dotenv;

public class CpfConsult {

    public String cpfNumberInput() {
        Gson gson = new Gson();
        Scanner cpf = new Scanner(System.in);
        Dotenv dotenv = Dotenv.configure().directory("src/main/java/com/cpfChecker/main").filename(".env").load();
        System.out.print("Digite o CPF (somente números): ");
        String cpfnumber = cpf.nextLine();
        if (cpfnumber.length() == 11) {
            String apiKey = dotenv.get("API_KEY");
            var json = new ConsumoApi().obterDados("https://api.invertexto.com/v1/validator?token=" + apiKey + "&value="
                    + cpfnumber + "&type=cpf");

            var jsonCap = gson.fromJson(json, JsonCapture.class);

            String estadoCpf = CpfEstado.estadoCpf(cpfnumber);
            cpf.close();
            return "CPF formatado: " + jsonCap.getFormatted() + "\n" + "CPF válido: " + jsonCap.getValid() + "\n" + "Estado: " + estadoCpf;
        } else {
            cpf.close();
            return "CPF Inválido";
        }
    }
}
