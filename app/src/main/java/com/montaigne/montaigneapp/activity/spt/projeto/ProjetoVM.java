package com.montaigne.montaigneapp.activity.spt.projeto;

import android.view.View;

public class ProjetoVM {
    private final ProjetoActivity activity;

    public ProjetoVM(ProjetoActivity activity) {
        this.activity = activity;
        
        intializeFurosAdapter();
        
        activity.buttonDeleteFuro.setOnClickListener(this::deleteFurosButtonListener);
    }

    private void intializeFurosAdapter() {
    }

    private void deleteFurosButtonListener(View view) {
    }
}
