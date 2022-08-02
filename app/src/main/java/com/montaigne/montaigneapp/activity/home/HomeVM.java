package com.montaigne.montaigneapp.activity.home;

import android.content.Intent;
import android.view.View;

import com.montaigne.montaigneapp.activity.carimboDefinitivo.CarimboDefinitivoActivity;

public class HomeVM {
    // inicializar o adapter de projetos salvos
    // inicializar o adapter de projetos categorias
    // acessar lista de projetos
    // intent menu lateral
    private final HomeActivity activity;

    public HomeVM (HomeActivity activity){
        this.activity = activity;

        activity.newProjectFab.setOnClickListener(this::newProjectFabListener);
    }

    private void newProjectFabListener(View view) {
        activity.startActivity(new Intent(activity, CarimboDefinitivoActivity.class));
    }



}
