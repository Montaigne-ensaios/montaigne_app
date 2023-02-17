package com.montaigne.montaigneapp.model.granulometria;

import com.montaigne.montaigneapp.model.Projeto;

import java.util.List;

public class ProjetoGranulometria extends Projeto {
    private float massaTotal;
    private List<Peneira> listaDePeneiras1, listaDePeneiras2;

    public ProjetoGranulometria() {}

    public ProjetoGranulometria(String id, String nome, String dataInicio, float massaTotal, List<Peneira> listaDePeneiras1, List<Peneira> listaDePeneiras2) {
        super(id, nome, dataInicio);
        this.massaTotal = massaTotal;
        this.listaDePeneiras1 = listaDePeneiras1;
        this.listaDePeneiras2 = listaDePeneiras2;
    }

    public float getMassaTotal() {
        return massaTotal;
    }

    public void setMassaTotal(float massaTotal) {
        this.massaTotal = massaTotal;
    }

    public List<Peneira> getListaDePeneiras1() {
        return listaDePeneiras1;
    }

    public List<Peneira> getListaDePeneiras2() {
        return listaDePeneiras2;
    }

    public void setListaDePeneiras1(List<Peneira> listaDePeneiras1) {
        this.listaDePeneiras1 = listaDePeneiras1;
    }

    public void setListaDePeneiras2(List<Peneira> listaDePeneiras2) {
        this.listaDePeneiras2 = listaDePeneiras2;
    }
}
