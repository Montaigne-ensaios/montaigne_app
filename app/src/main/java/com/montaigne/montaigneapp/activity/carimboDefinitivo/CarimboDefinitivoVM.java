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
        Intent intent = new Intent(view.getContext(), CarimboUnicoActivity.class);
        intent.putExtra("Tecnico", activity.fields.get ("Tecnico"). getText(). toString());
        intent.putExtra("Empresa", activity.fields.get ("Empresa"). getText(). toString());
        intent.putExtra("Contato", activity.fields.get ("Contato"). getText(). toString());
        intent.putExtra("Cliente", activity.fields.get ("Cliente"). getText(). toString());
        intent.putExtra("LocalObra", activity.fields.get ("LocalObra"). getText(). toString());
        intent.putExtra("nFuros", activity.fields.get ("QuantidadeFuros"). getText(). toString());
        intent.putExtra("ReferenciaNivel", activity.fields.get ("ReferenciaNivel"). getText(). toString());
        intent.putExtra("NomeProjeto", activity.fields.get ("NomeProjeto"). getText(). toString());

        view.getContext().startActivity(intent);

    }

    private void homeButtonListener (View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo:limpar tasks;
    }
}
