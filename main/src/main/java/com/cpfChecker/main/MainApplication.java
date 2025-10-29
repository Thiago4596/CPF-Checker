package com.cpfChecker.main;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cpfChecker.main.models.CpfConsult;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

        var cpf1 = new CpfConsult();
        Scanner cpf = new Scanner(System.in);

        boolean sair = false;
        while (!sair) {
            System.out.print("Digite o CPF (somente números): ");
            String cpfnumber = cpf.nextLine();
            if (cpfnumber.equals("sair")) {
                sair = true;
            }
            cpf1.cpfNumberInput(cpfnumber);
        }
        cpf.close();
    }
}