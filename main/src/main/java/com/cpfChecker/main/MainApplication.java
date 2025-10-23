package com.cpfChecker.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cpfChecker.main.models.CpfConsult;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

        var cpf1 = new CpfConsult();
        System.out.println(cpf1.cpfNumberInput());
    }

}
