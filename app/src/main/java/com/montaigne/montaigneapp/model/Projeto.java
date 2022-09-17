package com.montaigne.montaigneapp.model;

public abstract class Projeto {

    private String id;
    private String nome;
    private String cliente;
    private String empresa;
    private String tecnico;
    private String numeroDeTelefone;
    private String dataInicio;
    private Coordenada coordenadas;

    public Projeto() {}

    public Projeto(String id, String nome, String cliente, String empresa, String tecnico, String numeroDeTelefone, String dataInicio, Coordenada coordenadas) {
        this.id = id;
        this.nome = nome;
        this.cliente = cliente;
        this.empresa = empresa;
        this.tecnico = tecnico;
        this.numeroDeTelefone = numeroDeTelefone;
        this.dataInicio = dataInicio;
        this.coordenadas = coordenadas;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    public void setNumeroDeTelefone(String numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }
}
