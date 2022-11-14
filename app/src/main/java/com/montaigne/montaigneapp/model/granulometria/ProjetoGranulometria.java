package com.montaigne.montaigneapp.model.granulometria;

import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.List;

public class ProjetoGranulometria extends Projeto {
    private float massa;
    private List<Peneira> listaDePeneiras;

    public ProjetoGranulometria() {}

    public ProjetoGranulometria(float massa, List<Peneira> listaDePeneiras) {
        this.massa = massa;
        this.listaDePeneiras = listaDePeneiras;
    }

    public ProjetoGranulometria(String id, String nome, String cliente, String empresa, String tecnico, String contato, String dataInicio, Coordenada coordenadas, float massa, List<Peneira> listaDePeneiras) {
        super(id, nome, cliente, empresa, tecnico, contato, dataInicio, coordenadas);
        this.massa = massa;
        this.listaDePeneiras = listaDePeneiras;
    }

    public float getMassa() {
        return massa;
    }

    public void setMassa(float massa) {
        this.massa = massa;
    }

    public List<Peneira> getListaDePeneiras() {
        return listaDePeneiras;
    }

    public void setListaDePeneiras(List<Peneira> listaDePeneiras) {
        this.listaDePeneiras = listaDePeneiras;
    }
}
