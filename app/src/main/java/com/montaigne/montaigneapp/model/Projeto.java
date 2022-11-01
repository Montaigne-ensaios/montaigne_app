package com.montaigne.montaigneapp.model;

import java.io.Serializable;

public abstract class Projeto implements Serializable {

    private String id;
    private String nome;
    private String cliente;  // opcional
    private String empresa;  // opcional
    private String tecnico;  // opcional
    private String contato;  // opcional. pode ser qualquer forma de contato
    private String dataInicio, dataFim;
    private Coordenada coordenadas;  // todo: subsitutir por texto do endereço?

    public Projeto() {}

    public Projeto(String id, String nome, String cliente,
                   String empresa, String tecnico, String contato,
                   String dataInicio, Coordenada coordenadas) {
        this.id = id;
        this.nome = nome;
        this.cliente = cliente;
        this.empresa = empresa;
        this.tecnico = tecnico;
        this.contato = contato;
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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
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
