package com.montaigne.montaigneapp.model.granulometria;

import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.List;

public class ProjetoGranulometria extends Projeto {
    private List<Peneira> listaDePeneiras;

    public ProjetoGranulometria(List<Peneira> listaDePeneiras) {
        this.listaDePeneiras = listaDePeneiras;
    }

    public ProjetoGranulometria(String id, String nome, String cliente, String empresa, String tecnico, String contato, String dataInicio, Coordenada coordenadas, List<Peneira> listaDePeneiras) {
        super(id, nome, cliente, empresa, tecnico, contato, dataInicio, coordenadas);
        this.listaDePeneiras = listaDePeneiras;
    }

    public List<Peneira> getListaDePeneiras() {
        return listaDePeneiras;
    }

    public void setListaDePeneiras(List<Peneira> listaDePeneiras) {
        this.listaDePeneiras = listaDePeneiras;
    }
}
