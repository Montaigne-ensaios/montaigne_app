package com.montaigne.montaigneapp.model.spt;

import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.List;

public class ProjetoSpt extends Projeto {

    private int numeroDoFuro;
    private List<FuroSpt> listaDeFuros;

    public ProjetoSpt() {}

    public ProjetoSpt(String id, String nome, String cliente, String empresa, String tecnico, String numeroDeTelefone, String dataInicio, Coordenada coordenadas, int numeroDoFuro, List<FuroSpt> listaDeFuros) {
        super(id, nome, cliente, empresa, tecnico, numeroDeTelefone, dataInicio, coordenadas);
        this.numeroDoFuro = numeroDoFuro;
        this.listaDeFuros = listaDeFuros;
    }

    public int getNumeroDoFuro() {
        return numeroDoFuro;
    }

    public void setNumeroDoFuro(int numeroDoFuro) {
        this.numeroDoFuro = numeroDoFuro;
    }

    public List<FuroSpt> getListaDeFuros() {
        return listaDeFuros;
    }

    public void setListaDeFuros(List<FuroSpt> listaDeFuros) {
        this.listaDeFuros = listaDeFuros;
    }
}
