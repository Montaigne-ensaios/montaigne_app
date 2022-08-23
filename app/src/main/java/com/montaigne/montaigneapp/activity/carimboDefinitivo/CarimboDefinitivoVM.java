package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.content.Intent;
import android.view.View;

import com.montaigne.montaigneapp.activity.spt.carimboUnico.CarimboUnicoActivity;

public class CarimboDefinitivoVM {
    private final CarimboDefinitivoActivity activity;

    public CarimboDefinitivoVM(CarimboDefinitivoActivity activity) {
        this.activity = activity;
    }
    // método de getData (validação de entradas)

    private void continuarCarimboButtonListener (View view) {
        activity.startActivity(new Intent(activity, CarimboUnicoActivity.class));
    }

    private void inicialButtonListener (View view) {
    }

    private void cameraButtonListener (View view) {
    }



}
