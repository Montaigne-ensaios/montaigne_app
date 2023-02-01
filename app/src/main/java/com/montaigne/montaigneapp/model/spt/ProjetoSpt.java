package com.montaigne.montaigneapp.model.spt;

import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.List;

public class ProjetoSpt extends Projeto {

    private String cliente;  // opcional
    private String empresa;  // opcional
    private String tecnico;  // opcional
    private String contato;  // opcional. pode ser qualquer forma de contato
    private String dataInicio, dataFim;  // todo: definir automaticamente
    private String endereco;  // todo: remove

    private String referenciaNivel;  // obrigatório
    private String localDaObra;
    // descrição de algo que serve como referência para a altura dos furos. Ex: calçada
    private float alturaReferenciaNivelMar;  // não opcional
    // altura da referência de nível em relação ao nível do mar.
    //  Ex: a calçada está a 196,42m do nível do mar.
    private List<FuroSpt> listaDeFuros;

    public ProjetoSpt() {}

    public ProjetoSpt(String id, String nome, String dataInicio,
                      String cliente, String empresa, String tecnico,
                      String contato, String dataInicio1, String dataFim,
                      String endereco, String referenciaNivel, String localDaObra,
                      float alturaReferenciaNivelMar, List<FuroSpt> listaDeFuros) {
        super(id, nome, dataInicio);
        this.cliente = cliente;
        this.empresa = empresa;
        this.tecnico = tecnico;
        this.contato = contato;
        this.dataInicio = dataInicio1;
        this.dataFim = dataFim;
        this.endereco = endereco;
        this.referenciaNivel = referenciaNivel;
        this.localDaObra = localDaObra;
        this.alturaReferenciaNivelMar = alturaReferenciaNivelMar;
        this.listaDeFuros = listaDeFuros;
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

    @Override
    public String getDataInicio() {
        return dataInicio;
    }

    @Override
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getReferenciaNivel() {
        return referenciaNivel;
    }

    public void setReferenciaNivel(String referenciaNivel) {
        this.referenciaNivel = referenciaNivel;
    }

    public String getLocalDaObra() {
        return localDaObra;
    }

    public void setLocalDaObra(String localDaObra) {
        this.localDaObra = localDaObra;
    }

    public float getAlturaReferenciaNivelMar() {
        return alturaReferenciaNivelMar;
    }

    public void setAlturaReferenciaNivelMar(float alturaReferenciaNivelMar) {
        this.alturaReferenciaNivelMar = alturaReferenciaNivelMar;
    }

    public List<FuroSpt> getListaDeFuros() {
        return listaDeFuros;
    }

    public void setListaDeFuros(List<FuroSpt> listaDeFuros) {
        this.listaDeFuros = listaDeFuros;
    }
}
