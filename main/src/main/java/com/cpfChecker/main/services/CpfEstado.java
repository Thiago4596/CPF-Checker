package com.cpfChecker.main.services;

public class CpfEstado {
    public static String estadoCpf(String cpf) {
        char estado = cpf.charAt(8);
        return switch (estado) {
            case '0' -> "Rio Grande do Sul";
            case '1' -> "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins";
            case '2' -> "Amazonas, Pará, Roraima, Amapá, Acre e Rondônia";
            case '3' -> "Ceará, Maranhão e Piauí";
            case '4' -> "Paraíba, Pernambuco, Alagoas e Rio Grande do Norte";
            case '5' -> "Bahia e Sergipe";
            case '6' -> "Minas Gerais";
            case '7' -> "Rio de Janeiro e Espírito Santo";
            case '8' -> "São Paulo";
            case '9' -> "Paraná e Santa Catarina";
            default -> "Estado inválido";
        };
    }
}
