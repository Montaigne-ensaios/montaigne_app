package com.montaigne.montaigneapp.model.granulometria;

import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.List;

public class ProjetoGranulometria extends Projeto {
    private float massaTotal;
    private List<Peneira> listaDePeneiras;

    public ProjetoGranulometria() {}

    public ProjetoGranulometria(float massaTotal, List<Peneira> listaDePeneiras) {
        this.massaTotal = massaTotal;
        this.listaDePeneiras = listaDePeneiras;
    }

    public ProjetoGranulometria(String id, String nome, String cliente,
                                String empresa, String tecnico, String contato,
                                String dataInicio, Coordenada coordenadas, float massaTotal,
                                List<Peneira> listaDePeneiras) {
        super(id, nome, cliente, empresa, tecnico, contato, dataInicio, coordenadas);
        this.massaTotal = massaTotal;
        this.listaDePeneiras = listaDePeneiras;
    }

    public float getMassa() {
        return massaTotal;
    }

    public void setMassa(float massaInicial) {
        this.massaTotal = massaInicial;
    }

    public List<Peneira> getListaDePeneiras() {
        return listaDePeneiras;
    }

    public void setListaDePeneiras(List<Peneira> listaDePeneiras) {
        this.listaDePeneiras = listaDePeneiras;
    }
}
