package br.com.zupacademy.alissonprado.casadocodigo.controller;

public interface Transacao {

    void executa(TipoConta tipoConta, String conta);
}
