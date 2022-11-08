package com.montaigne.montaigneapp.model.spt;

import com.montaigne.montaigneapp.model.Coordenada;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FuroSpt implements Serializable {
    private String id;
    private String idProjeto;
    private String codigo;
    // identificador do furo, ex: SPT-01. Gerado automaticamente
    private float nivelDAgua;
    // altura da água dentrod do furo quando o ensaio terminou, em metros
    private float cotaInicial;
    // altura em que o furo é iniciado, em relação a `referencia de nível` do projeto
    //  seguindo ex do projeto: furo começou a 2,69m abaixo do nível da calçada
    private Date dataInicio, dataFim;
    private List<AmostraSpt> listaDeAmostras;
    private Coordenada coordenada;
    // coordenada especificamente do furo

    public FuroSpt() {
    }

    public FuroSpt(String id, String idProjeto, String codigo, float nivelDAgua,
                   float cotaInicial, Date dataInicio, Date dataFim,
                   List<AmostraSpt> listaDeAmostras) {
        this.id = id;
        this.idProjeto = idProjeto;
        this.codigo = codigo;
        this.nivelDAgua = nivelDAgua;
        this.cotaInicial = cotaInicial;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.listaDeAmostras = listaDeAmostras;
    }

    public String getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(String idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getNivelDAgua() {
        return nivelDAgua;
    }

    public void setNivelDAgua(float nivelDAgua) {
        this.nivelDAgua = nivelDAgua;
    }

    public float getCotaInicial() {
        return cotaInicial;
    }

    public void setCotaInicial(float cotaInicial) {
        this.cotaInicial = cotaInicial;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public List<AmostraSpt> getListaDeAmostras() {
        return listaDeAmostras;
    }

    public void setListaDeAmostras(List<AmostraSpt> listaDeAmostras) {
        this.listaDeAmostras = listaDeAmostras;
    }
}
