package br.com.zupacademy.alissonprado.casadocodigo.controller;

public enum TipoConta {

    DEBITO {
        @Override
        public Transacao getTransacao() {
            return new Debito();
        }
    },
    CREDITO {
        @Override
        public Transacao getTransacao() {
            return new Credito();
        }
    };

    public abstract Transacao getTransacao();
}
