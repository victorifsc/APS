package com.ifsc.tds.main;

public class Cliente {

    private Integer clienteId;
    private String nome;
    private Endereco endereco;

    public Integer getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(int id) {
        this.clienteId = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "ID: " + clienteId + ", Nome: " + nome + ", Endereço: " + endereco;
    }

}
