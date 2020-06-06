package com.isagiongo.models;

public class PessoaDTO {

    private String nome;

    private Pessoa.Tipo tipo;

    public String getNome() {
        return nome;
    }

    public Pessoa.Tipo getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(Pessoa.Tipo tipo) {
        this.tipo = tipo;
    }
}
