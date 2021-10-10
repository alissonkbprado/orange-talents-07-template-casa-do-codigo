package br.com.zupacademy.alissonprado.casadocodigo.controller;

public class Debito implements Transacao{

    @Override
    public void executa(TipoConta tipoConta, String conta) {
        System.out.println("Executa débito!");
    }
}
