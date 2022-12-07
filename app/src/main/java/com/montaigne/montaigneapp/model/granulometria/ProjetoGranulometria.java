package com.montaigne.montaigneapp.model.granulometria;

import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.List;

public class ProjetoGranulometria extends Projeto {
    private float massaTotal;
    private List<Peneira> listaDePeneiras;

    public ProjetoGranulometria() {}

    public ProjetoGranulometria(String id, String nome, String dataInicio, float massaTotal, List<Peneira> listaDePeneiras) {
        super(id, nome, dataInicio);
        this.massaTotal = massaTotal;
        this.listaDePeneiras = listaDePeneiras;
    }

    public float getMassaTotal() {
        return massaTotal;
    }

    public void setMassaTotal(float massaTotal) {
        this.massaTotal = massaTotal;
    }

    public List<Peneira> getListaDePeneiras() {
        return listaDePeneiras;
    }

    public void setListaDePeneiras(List<Peneira> listaDePeneiras) {
        this.listaDePeneiras = listaDePeneiras;
    }
}
