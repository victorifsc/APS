package com.ifsc.tds.main;

public class Fatura {
    private Integer faturaId;
    private Integer mesAno;
    private UC unidadeConsumidora;
    private Integer consumo;
    private Boolean pago;


    public Integer getFaturaId() {
        return faturaId;
    }

    public void setFaturaId(Integer faturaId) {
        this.faturaId = faturaId;
    }

    public Integer getMesAno() {
        return mesAno;
    }

    public void setMesAno(Integer mesAno) {
        this.mesAno = mesAno;
    }

    public UC getUnidadeConsumidora() {
        return unidadeConsumidora;
    }

    public void setUnidadeConsumidora(UC unidadeConsumidora) {
        this.unidadeConsumidora = unidadeConsumidora;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    double caucularValorFatura() {
        double valorFatura = 0d;

        if (this.unidadeConsumidora.getCliente() instanceof PessoaFisica) {
            if (this.consumo <= 200) {
                valorFatura = this.consumo * Tarifas.getTarResidencial1();
            } else {
                valorFatura = this.consumo * Tarifas.getTarResidencial2();
            }
        } else if (this.unidadeConsumidora.getCliente() instanceof PessoaJuridica) {
            if (this.consumo <= 500) {
                valorFatura = this.consumo * Tarifas.getTarComercial1();
            } else {
                valorFatura = this.consumo * Tarifas.getTarComercial2();
            }
        }

        valorFatura += valorFatura * Tarifas.getIcms() / 100;

        return valorFatura;
    }

    @Override
    public String toString() {
        return "ID: " + faturaId + ", MesAno: " + mesAno + ", Unidade Consumidora: " + unidadeConsumidora
                + ", Consumo:" + consumo + ", Pago: " + pago;
    }

    static void imprimirFatura(Fatura[] vetor) {
        for (Fatura fatura : vetor) {
            System.out.println(fatura.toString());
        }
    }

}
