package com.montaigne.montaigneapp.activity.home;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.montaigne.montaigneapp.activity.carimboDefinitivo.CarimboDefinitivoActivity;

import java.util.ArrayList;

public class HomeVM {
    // inicializar o adapter de projetos salvos
    // inicializar o adapter de projetos categorias
    // acessar lista de projetos
    // intent menu lateral
    private final HomeActivity activity;

    public HomeVM (HomeActivity activity){
        this.activity = activity;

        initializeProjectCategoriaAdapter();

        activity.newProjectFab.setOnClickListener(this::newProjectFabListener);
    }

    private void initializeProjectCategoriaAdapter (){
        ArrayList<Object[]> categorias = new ArrayList<>();
        categorias.add(new Object[]{"SPT", 0});
        categorias.add(new Object[]{"Granulometria", 0});

        ProjetoCategoriaAdapter adapter = new ProjetoCategoriaAdapter(activity);
        adapter.setCategoriasProjeto(categorias);
        activity.projetoCategorias.setAdapter(adapter);
        activity.projetoCategorias.setLayoutManager(new LinearLayoutManager(activity));
    }

    private void newProjectFabListener(View view) {
        activity.startActivity(new Intent(activity, CarimboDefinitivoActivity.class));
    }
}
