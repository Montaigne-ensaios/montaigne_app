package com.montaigne.montaigneapp.activity.spt.carimboUnico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.ensaio.EnsaioActivity;

public class CarimboUnicoVM {
    private final CarimboUnicoActivity activity;
    private Bundle extras;

    public CarimboUnicoVM(CarimboUnicoActivity activity) {

        this.activity = activity;
        activity.buttonIniciarEnsaio.setOnClickListener(this::ensaioButtonListener);
        activity.imageButtonHome.setOnClickListener(this:: homeButtonListener);

        this.extras = activity.getIntent().getExtras();
    }

    private void ensaioButtonListener(View view) {
        Intent intent = new Intent(view.getContext(), EnsaioActivity.class);
        intent.putExtra("NomeProjeto", extras.getString("NomeProjeto"));
        view.getContext().startActivity(intent);


    }

    private void homeButtonListener (View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo: limpar tasks;
    }
}
