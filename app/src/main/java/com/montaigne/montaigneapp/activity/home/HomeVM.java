package com.montaigne.montaigneapp.activity.home;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.carimboDefinitivo.CarimboDefinitivoActivity;
import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeVM extends ViewModel {
//    private final HomeActivity activity;
    private ArrayList<String> projetosSalvos;

    /*
    public HomeVM (HomeActivity activity) {
        this.activity = activity;

        initializeProjetosSalvosAdapter();
        initializeProjetoCategoriaAdapter(activity.recyclerProjetoCategorias);

        activity.newProjectFab.setOnClickListener(this::newProjectFabListener);
    }
     */

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
        ProjetosSalvosAdapter adapter = new ProjetosSalvosAdapter(recyclerProjetosSalvos);

        recyclerProjetosSalvos.setAdapter(adapter);
        recyclerProjetosSalvos.setLayoutManager(new LinearLayoutManager(recyclerProjetosSalvos.getContext()));
    }

    private ArrayList<String> getProjetos() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Exemplo de projeto");
        list.add("Outro exemplo");
        list.add("Só mais um");
        list.add("Tá bom parei");
        return list;
    }

    private void categoriaFilterListener(View view) {
        // seleciona apenas os projetos da categoria especifica
    }

    protected void newProjectFabListener(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), CarimboDefinitivoActivity.class));
    }
}
