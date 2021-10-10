package br.com.zupacademy.alissonprado.casadocodigo.controller;


public class TransacaoRequest {
    private TipoConta tipoConta;
    private String conta;

    public TipoConta getTipo() {
        return tipoConta;
    }

    public void setTipo(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
}
