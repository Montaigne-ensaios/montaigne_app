package com.montaigne.montaigneapp.activity.home;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.carimboDefinitivo.CarimboDefinitivoActivity;

import java.util.ArrayList;

public class HomeVM {
    private final HomeActivity activity;
    private ArrayList<String> projetosSalvos;

    public HomeVM (HomeActivity activity) {
        this.activity = activity;

        projetosSalvos = getProjetos();

        initializeProjetoCategoriaAdapter();
        initializeProjetosSalvosAdapter(projetosSalvos);

        activity.newProjectFab.setOnClickListener(this::newProjectFabListener);
    }

    private void initializeProjetoCategoriaAdapter() {
        ArrayList<Object[]> categorias = new ArrayList<>();
        categorias.add(new Object[]{"SPT", R.drawable.ic_logospt_azul});
        categorias.add(new Object[]{"Granulometria", R.drawable.ic_logospt_azul});
        // todo: substituir strings por referência ao `values.xml`

        ProjetoCategoriaAdapter adapter = new ProjetoCategoriaAdapter();
        adapter.setCategoriasProjeto(categorias);
        activity.recyclerProjetoCategorias.setAdapter(adapter);
        activity.recyclerProjetoCategorias.setLayoutManager(new LinearLayoutManager(
                        activity,
                        LinearLayoutManager.HORIZONTAL,
                        false));
    }

    private void initializeProjetosSalvosAdapter(ArrayList<String> projetos) {
        ProjetosSalvosAdapter adapter = new ProjetosSalvosAdapter(projetos);
        activity.recyclerProjetosSalvos.setAdapter(adapter);
        activity.recyclerProjetosSalvos.setLayoutManager(new LinearLayoutManager(activity));
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

    private void newProjectFabListener(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), CarimboDefinitivoActivity.class));
    }
}
