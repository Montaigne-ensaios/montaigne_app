package com.montaigne.montaigneapp.model.spt;

import com.montaigne.montaigneapp.model.Projeto;

import java.util.List;

public class ProjetoSpt extends Projeto {

    private String cliente;  // opcional
    private String empresa;  // opcional
    private String tecnico;  // opcional
    private String contato;  // opcional. pode ser qualquer forma de contato
    private String dataFim;
    private String endereco;  // gerar com geocode
    private String referenciaNivel;  // obrigatório
    // descrição de algo que serve como referência para a altura dos furos. Ex: calçada
    private float alturaReferencia;  // não opcional
    // altura da referência de nível em relação ao nível do mar.
    //  Ex: a calçada está a 196,42m do nível do mar.
    private List<FuroSpt> listaDeFuros;

    public ProjetoSpt() {}

    public ProjetoSpt(String id, String nome, String dataInicio,
                      String cliente, String empresa, String tecnico,
                      String contato, String dataFim,
                      String endereco, String referenciaNivel, String localDaObra,
                      float alturaReferencia, List<FuroSpt> listaDeFuros) {
        super(id, nome, dataInicio);
        this.cliente = cliente;
        this.empresa = empresa;
        this.tecnico = tecnico;
        this.contato = contato;
        this.dataFim = dataFim;
        this.endereco = endereco;
        this.referenciaNivel = referenciaNivel;
        this.alturaReferencia = alturaReferencia;
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

    public float getAlturaReferencia() {
        return alturaReferencia;
    }

    public void setAlturaReferencia(float alturaReferencia) {
        this.alturaReferencia = alturaReferencia;
    }

    public List<FuroSpt> getListaDeFuros() {
        return listaDeFuros;
    }

    public void setListaDeFuros(List<FuroSpt> listaDeFuros) {
        this.listaDeFuros = listaDeFuros;
    }
}
