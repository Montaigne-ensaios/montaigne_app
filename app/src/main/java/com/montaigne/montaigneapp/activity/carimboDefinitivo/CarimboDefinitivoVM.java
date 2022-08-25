package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.content.Intent;
import android.view.View;

import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.carimboUnico.CarimboUnicoActivity;

public class CarimboDefinitivoVM {
    private final CarimboDefinitivoActivity activity;

    public CarimboDefinitivoVM(CarimboDefinitivoActivity activity) {
        this.activity = activity;
        activity.buttonContinuarCarimbo.setOnClickListener(this::continuarCarimboButtonListener);
        activity.imageButtonHome.setOnClickListener(this::homeButtonListener);

    }
    // método de getData (validação de entradas)

    private void continuarCarimboButtonListener (View view) {
        view.getContext().startActivity(new Intent(view.getContext(), CarimboUnicoActivity.class));
        //todo:passar dados dessa activity para a carimbo unico.
    }

    private void homeButtonListener (View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo:limpar tasks;
    }
}
