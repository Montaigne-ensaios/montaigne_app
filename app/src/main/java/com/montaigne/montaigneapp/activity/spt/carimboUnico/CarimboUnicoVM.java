package com.montaigne.montaigneapp.activity.spt.carimboUnico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.ensaio.EnsaioActivity;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class CarimboUnicoVM extends ViewModel {
    private Bundle extras;

    protected void setExtras(Bundle bundle) {
        extras = bundle;
    }

    protected void ensaioButtonListener(View view, ProjetoSpt projetoSpt) {
        Intent intent = new Intent(view.getContext(), EnsaioActivity.class);
        intent.putExtra("ProjetoSpt", projetoSpt);
        view.getContext().startActivity(intent);
    }

    protected void homeButtonListener (View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo: limpar tasks;
    }
}
