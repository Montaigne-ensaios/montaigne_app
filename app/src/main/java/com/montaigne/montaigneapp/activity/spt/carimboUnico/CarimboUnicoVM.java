package com.montaigne.montaigneapp.activity.spt.carimboUnico;

import android.content.Intent;
import android.view.View;

import com.montaigne.montaigneapp.activity.carimboDefinitivo.CarimboDefinitivoActivity;
import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.ensaio.EnsaioActivity;

public class CarimboUnicoVM {
    private final CarimboUnicoActivity activity;

    public CarimboUnicoVM(CarimboUnicoActivity activity) {

        this.activity = activity;
        activity.buttonIniciarEnsaio.setOnClickListener(this::ensaioButtonListener);
        activity.imageButtonHome.setOnClickListener(this:: homeButtonListener);
    }

    private void ensaioButtonListener(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), EnsaioActivity.class));
    }

    private void homeButtonListener (View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo: limpar tasks;
    }
}
