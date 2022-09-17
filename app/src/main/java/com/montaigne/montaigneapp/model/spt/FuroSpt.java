package com.montaigne.montaigneapp.model.spt;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FuroSpt implements Serializable {
    private String id;
    private String idProjeto;
    private String codigo;
    private float nivelDAgua, nivelDoFuro;
    private Date dataInicio, dataFim;
    private List<AmostraSpt> listaDeAmostras;

    public FuroSpt() {
    }

    public FuroSpt(String id, String idProjeto, String codigo, float nivelDAgua, float nivelDoFuro, Date dataInicio, Date dataFim, List<AmostraSpt> listaDeAmostras) {
        this.id = id;
        this.idProjeto = idProjeto;
        this.codigo = codigo;
        this.nivelDAgua = nivelDAgua;
        this.nivelDoFuro = nivelDoFuro;
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

    public float getNivelDoFuro() {
        return nivelDoFuro;
    }

    public void setNivelDoFuro(float nivelDoFuro) {
        this.nivelDoFuro = nivelDoFuro;
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

    public List<AmostraSpt> getListaDeAmostras() {
        return listaDeAmostras;
    }

    public void setListaDeAmostras(List<AmostraSpt> listaDeAmostras) {
        this.listaDeAmostras = listaDeAmostras;
    }
}
