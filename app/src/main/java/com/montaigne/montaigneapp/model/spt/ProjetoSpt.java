package com.montaigne.montaigneapp.model.spt;

import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.List;

public class ProjetoSpt extends Projeto {

    private int numeroDoFuro;  // todo: remover, número de furos são usados apenas para gerar a lista de furos
    private String referenciaNivel;  // opcional
    // descrição de algo que serve como referência para a altura dos furos. Ex: calçada
    private float alturaReferenciaNivelMar;  // não opcional
    // altura da referência de nível em relação ao nível do mar.
    //  Ex: a calçada está a 196,42m do nível do mar.
    private List<FuroSpt> listaDeFuros;

    public ProjetoSpt() {}

    public ProjetoSpt(String id, String nome, String cliente,
                      String empresa, String tecnico, String contato,
                      String dataInicio, Coordenada coordenadas, int numeroDoFuro,
                      String referenciaNivel, List<FuroSpt> listaDeFuros) {
        super(id, nome, cliente, empresa, tecnico, contato, dataInicio, coordenadas);
        this.numeroDoFuro = numeroDoFuro;
        this.referenciaNivel = referenciaNivel;
        this.listaDeFuros = listaDeFuros;
    }

    public int getNumeroDoFuro() {
        return numeroDoFuro;
    }

    public void setNumeroDoFuro(int numeroDoFuro) {
        this.numeroDoFuro = numeroDoFuro;
    }

    public String getReferenciaNivel() {
        return referenciaNivel;
    }

    public void setReferenciaNivel(String referenciaNivel) {
        this.referenciaNivel = referenciaNivel;
    }

    public List<FuroSpt> getListaDeFuros() {
        return listaDeFuros;
    }

    public void setListaDeFuros(List<FuroSpt> listaDeFuros) {
        this.listaDeFuros = listaDeFuros;
    }
}
