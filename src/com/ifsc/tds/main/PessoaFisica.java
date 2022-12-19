package com.ifsc.tds.main;

public class PessoaFisica extends Cliente {

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return super.toString() + ", CPF: " + cpf;
    }


}
