package com.montaigne.montaigneapp.activity.spt.furo;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class FuroVM {
    private final FuroActivity activity;
    private ArrayList<String> amostras;

    public FuroVM(FuroActivity activity) {
        this.activity = activity;

        amostras = getAmostras();
        updateAmostrasAdapter(amostras);

        activity.buttonDeleteAmostra.setOnClickListener(this::deleteAmostrasButtonListener);
    }

    private ArrayList<String> getAmostras() {
        ArrayList<String> mock = new ArrayList<>();
        mock.add("amostra1");
        mock.add("eu to literalmente copiando mocks aqui");
        mock.add("affs chato isso");
        return mock;
    }

    private void updateAmostrasAdapter(ArrayList<String> amostras) {
        AmostraAdapter adapter = new AmostraAdapter();
        adapter.setAmostras(amostras);
        activity.recyclerAmostras.setAdapter(adapter);
        activity.recyclerAmostras.setLayoutManager(new LinearLayoutManager(activity));
    }

    private void deleteAmostrasButtonListener(View view) {
    }
}
