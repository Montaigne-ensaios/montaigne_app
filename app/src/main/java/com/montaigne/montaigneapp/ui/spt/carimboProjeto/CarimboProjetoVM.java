package com.montaigne.montaigneapp.ui.spt.carimboProjeto;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.Map;


public class CarimboProjetoVM extends ViewModel {
    private ProjetoSpt projetoSpt;
    private CarimboProjetoAdapter adapter;

    public void setProjeto(ProjetoSpt projetoSpt) { this.projetoSpt = projetoSpt; }

    protected Projeto getProjeto() {
        Map<String, String> values = adapter.getValues();
        projetoSpt.setNome(values.get("nome"));
        projetoSpt.setCliente(values.get("cliente"));
        projetoSpt.setEmpresa(values.get("empresa"));
        projetoSpt.setTecnico(values.get("tecnico"));
        projetoSpt.setContato(values.get("numeroDeTelefone"));
        projetoSpt.setDataInicio(values.get("dataInicio"));
        return projetoSpt;
    }

    public void initializeRecycler(RecyclerView recycler) {
        this.adapter = new CarimboProjetoAdapter(projetoSpt);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(recycler.getContext()));
    }
}
