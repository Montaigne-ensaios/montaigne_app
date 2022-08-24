package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.content.Intent;
import android.view.View;

import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.carimboUnico.CarimboUnicoActivity;

public class CarimboDefinitivoVM {
    private final CarimboDefinitivoActivity activity;

    public CarimboDefinitivoVM(CarimboDefinitivoActivity activity) {
        this.activity = activity;
    }
    // método de getData (validação de entradas)

    private void continuarCarimboButtonListener (View view) {
        view.getContext().startActivity(new Intent(view.getContext(), CarimboUnicoActivity.class));
    }

    private void HomeListener (View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
    }

    private void cameraButtonListener (View view) {
    }



}
