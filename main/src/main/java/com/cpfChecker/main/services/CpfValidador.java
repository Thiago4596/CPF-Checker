package com.cpfChecker.main.services;

public class CpfValidador {
    public static boolean validaCpf(String cpf) {
        if (cpf == null) {
            return false;
        }

        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Calcula primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Character.getNumericValue(cpf.charAt(i));
                soma += digito * (10 - i);
            }

            int resto = soma % 11;
            int digito1 = (resto < 2) ? 0 : 11 - resto;

            // Verifica primeiro dígito
            if (digito1 != Character.getNumericValue(cpf.charAt(9))) {
                return false;
            }

            // Calcula segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                int digito = Character.getNumericValue(cpf.charAt(i));
                soma += digito * (11 - i);
            }

            resto = soma % 11;
            int digito2 = (resto < 2) ? 0 : 11 - resto;

            // Verifica segundo dígito
            return digito2 == Character.getNumericValue(cpf.charAt(10));

        } catch (Exception e) {
            return false;
        }
    }

    public static String formatarCpf(String cpf) {
        if (cpf == null) {
            return null;
        }

        // Remove caracteres não numéricos
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        // Verifica se tem 11 dígitos
        if (cpfLimpo.length() != 11) {
            return cpf; // Retorna o original se não puder formatar
        }

        // Formata usando substring - método mais confiável
        return cpfLimpo.substring(0, 3) + "." +
                cpfLimpo.substring(3, 6) + "." +
                cpfLimpo.substring(6, 9) + "-" +
                cpfLimpo.substring(9);
    }
}