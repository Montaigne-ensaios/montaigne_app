package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.carimboUnico.CarimboUnicoActivity;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class CarimboDefinitivoVM extends ViewModel {
    // método de getData (validação de entradas)

    protected void continuarCarimbo(View view, ProjetoSpt projetoSpt) {
        Intent intent = new Intent(view.getContext(), CarimboUnicoActivity.class);
        intent.putExtra("ProjetoSpt", projetoSpt);

        view.getContext().startActivity(intent);
    }

    protected void homeButtonListener(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo:limpar tasks;
    }
}
