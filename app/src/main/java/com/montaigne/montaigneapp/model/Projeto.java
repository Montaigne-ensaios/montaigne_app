package com.montaigne.montaigneapp.model;

import java.io.Serializable;

public abstract class Projeto implements Serializable {

    private String id;
    private String nome;
    private String dataInicio;

    public Projeto() {}

    public Projeto(String id, String nome, String dataInicio) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
}
