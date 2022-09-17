package com.montaigne.montaigneapp.activity.spt.furo;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FuroVM extends ViewModel {
    private ArrayList<String> amostras;

    private ArrayList<String> getAmostras() {
        ArrayList<String> mock = new ArrayList<>();
        mock.add("amostra1");
        mock.add("eu to literalmente copiando mocks aqui");
        mock.add("affs chato isso");
        return mock;
    }

    protected void updateAmostrasAdapter(RecyclerView recyclerAmostras) {
        amostras = getAmostras();
        AmostraAdapter adapter = new AmostraAdapter();
        adapter.setAmostras(amostras);
        recyclerAmostras.setAdapter(adapter);
        recyclerAmostras.setLayoutManager(new LinearLayoutManager(recyclerAmostras.getContext()));
    }

    protected void deleteAmostrasButtonListener(View view) {
    }
}
