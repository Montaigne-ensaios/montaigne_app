package com.montaigne.montaigneapp.model.spt;

import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.List;

public class ProjetoSpt extends Projeto {

    private String referenciaNivel;  // opcional
    private String localDaObra;
    // descrição de algo que serve como referência para a altura dos furos. Ex: calçada
    private float alturaReferenciaNivelMar;  // não opcional
    // altura da referência de nível em relação ao nível do mar.
    //  Ex: a calçada está a 196,42m do nível do mar.
    private List<FuroSpt> listaDeFuros;

    public ProjetoSpt() {}

    public ProjetoSpt(String id, String nome, String cliente, String empresa, String tecnico,
                      String contato, String dataInicio, Coordenada coordenadas,
                      String referenciaNivel, String localDaObra, float alturaReferenciaNivelMar,
                      List<FuroSpt> listaDeFuros) {
        super(id, nome, cliente, empresa, tecnico, contato, dataInicio, coordenadas);
        this.referenciaNivel = referenciaNivel;
        this.localDaObra = localDaObra;
        this.alturaReferenciaNivelMar = alturaReferenciaNivelMar;
        this.listaDeFuros = listaDeFuros;
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
