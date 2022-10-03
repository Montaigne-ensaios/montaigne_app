package com.montaigne.montaigneapp.activity.home;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.carimboDefinitivo.CarimboDefinitivoActivity;
import com.montaigne.montaigneapp.data.ModelHolder;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.ArrayList;

public class HomeVM extends ViewModel implements ModelHolder<Projeto> {
    private ArrayList<Projeto> projetosSalvos = new ArrayList<>();
    private final ProjetosSalvosAdapter adapter = new ProjetosSalvosAdapter();

    protected void initializeProjetoCategoriaAdapter(RecyclerView recyclerProjetoCategorias) {
        ArrayList<Object[]> categorias = new ArrayList<>();  // lista de filtros de projeto
        categorias.add(new Object[]{"SPT", R.drawable.ic_logospt_azul});
        categorias.add(new Object[]{"Granulometria", R.drawable.ic_logospt_azul});

        ProjetoCategoriaAdapter adapter = new ProjetoCategoriaAdapter();
        adapter.setCategoriasProjeto(categorias);
        recyclerProjetoCategorias.setAdapter(adapter);
        recyclerProjetoCategorias.setLayoutManager(new LinearLayoutManager(
                        recyclerProjetoCategorias.getContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false));
    }

    protected void initializeProjetosSalvosAdapter(RecyclerView recyclerProjetosSalvos) {
        recyclerProjetosSalvos.setAdapter(adapter);
        recyclerProjetosSalvos.setLayoutManager(new LinearLayoutManager(recyclerProjetosSalvos.getContext()));
    }

    protected void refreshProjetosSalvos(){
        ProjetoSptUseCase.read(this);
    }

    @Override
    public void addModel(Projeto projeto) {
        projetosSalvos.add(projeto);
        adapter.setProjetoList(projetosSalvos);
    }

    @Override
    public void clearModels() {
        projetosSalvos = new ArrayList<>();
        adapter.setProjetoList(projetosSalvos);
    }

    private void categoriaFilterListener(View view) {
        // seleciona apenas os projetos da categoria especifica
    }

    protected void newProjectFabListener(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), CarimboDefinitivoActivity.class));
    }
}
