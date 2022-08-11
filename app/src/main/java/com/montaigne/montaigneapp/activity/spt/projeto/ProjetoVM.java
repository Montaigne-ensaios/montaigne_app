package com.montaigne.montaigneapp.activity.spt.projeto;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class ProjetoVM {
    private final ProjetoActivity activity;
    private ArrayList<String> furos;

    public ProjetoVM(ProjetoActivity activity) {
        this.activity = activity;

        furos = getFuros();
        updateFurosAdapter(furos);
        
        activity.buttonDeleteFuro.setOnClickListener(this::deleteFurosButtonListener);
    }

    private void updateFurosAdapter(ArrayList<String> furos) {
        FurosAdapter adapter = new FurosAdapter(activity); // todo: revisar quando passar a lista
        adapter.setFuros(furos);
        activity.recyclerFuros.setAdapter(adapter);
        activity.recyclerFuros.setLayoutManager(new LinearLayoutManager(activity));
    }

    private void deleteFurosButtonListener(View view) {
    }

    private ArrayList<String> getFuros() {
        ArrayList<String> mock = new ArrayList<>();
        mock.add("furo1");
        mock.add("outro furo");
        mock.add("vc já entendeu");
        return mock;
    }
}
