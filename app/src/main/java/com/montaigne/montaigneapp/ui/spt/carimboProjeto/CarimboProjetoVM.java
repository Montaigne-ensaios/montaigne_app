package com.montaigne.montaigneapp.ui.spt.carimboProjeto;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.Map;


public class CarimboProjetoVM extends ViewModel {
    private ProjetoSpt projeto;
    private CarimboProjetoAdapter adapter;

    public void setProjeto(ProjetoSpt projeto) { this.projeto = projeto; }

    protected ProjetoSpt getProjeto() {
        Map<String, String> values = adapter.getValues();
        projeto.setNome(values.get("nome"));
        projeto.setCliente(values.get("cliente"));
        projeto.setEmpresa(values.get("empresa"));
        projeto.setTecnico(values.get("tecnico"));
        projeto.setContato(values.get("numeroDeTelefone"));
        projeto.setDataInicio(values.get("dataInicio"));
        return projeto;
    }

    public void initializeRecycler(RecyclerView recycler) {
        this.adapter = new CarimboProjetoAdapter(projeto);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(recycler.getContext()));
    }
}
