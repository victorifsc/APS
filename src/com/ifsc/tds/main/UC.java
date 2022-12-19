package com.ifsc.tds.main;

public class UC {

    private Integer ucId;
    private Cliente cliente;
    private Integer leituraAnterior;
    private Integer leituraAtual;
    private Endereco endereco;

    public Integer getUcId() {
        return ucId;
    }

    public void setUcId(Integer ucId) {
        this.ucId = ucId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getLeituraAnterior() {
        return leituraAnterior;
    }

    public void setLeituraAnterior(Integer leituraAnterior) {
        this.leituraAnterior = leituraAnterior;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getLeituraAtual() {
        return leituraAtual;
    }

    public void setLeituraAtual(Integer leituraAtual) {
        this.leituraAtual = leituraAtual;
    }

    @Override
    public String toString() {
        return "" + ucId + " - " + cliente;
    }

    public Integer faturar(Integer leitura) {
        this.leituraAnterior = this.leituraAtual;
        this.leituraAtual = leitura;
        return pegarConsumo();
    }

    public Integer pegarConsumo() {
        Integer consumo = leituraAtual - leituraAnterior;
        return consumo;
    }

}
