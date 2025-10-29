package com.cpfChecker.main.models;

import com.cpfChecker.main.services.CpfValidador;

public class CpfConsult {

    public String cpfNumberInput(String cpfnumber) {
        boolean isValid = CpfValidador.validaCpf(cpfnumber);
        if (isValid) {
            String cpfFormatado = CpfValidador.formatarCpf(cpfnumber);
            System.out.println("CPF: " + cpfFormatado + " -> Válido");
        } else {
            System.out.println("CPF: " + cpfnumber + " -> Inválido");
        }
        return cpfnumber;
    }
}
