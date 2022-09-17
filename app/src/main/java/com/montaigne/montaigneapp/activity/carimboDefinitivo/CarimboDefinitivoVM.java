package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.carimboUnico.CarimboUnicoActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class CarimboDefinitivoVM extends ViewModel {

    // método de getData (validação de entradas)

    protected void continuarCarimboButtonListener (View view, HashMap<String, EditText>fields) {
        Intent intent = new Intent(view.getContext(), CarimboUnicoActivity.class);
        intent.putExtra("Tecnico", fields.get ("Tecnico"). getText(). toString());
        intent.putExtra("Empresa", fields.get ("Empresa"). getText(). toString());
        intent.putExtra("Contato",fields.get ("Contato"). getText(). toString());
        intent.putExtra("Cliente",fields.get ("Cliente"). getText(). toString());
        intent.putExtra("LocalObra",fields.get ("LocalObra"). getText(). toString());
        intent.putExtra("nFuros",fields.get ("QuantidadeFuros"). getText(). toString());
        intent.putExtra("ReferenciaNivel",fields.get ("ReferenciaNivel"). getText(). toString());
        intent.putExtra("NomeProjeto", fields.get ("NomeProjeto"). getText(). toString());

        view.getContext().startActivity(intent);

    }

    protected void homeButtonListener (View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo:limpar tasks;
    }
}
