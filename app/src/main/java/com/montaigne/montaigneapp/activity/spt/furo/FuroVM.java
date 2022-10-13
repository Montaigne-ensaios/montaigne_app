package com.montaigne.montaigneapp.activity.spt.furo;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FuroVM extends ViewModel {
    private int idFuro;
    private ArrayList<String> amostras;

    private ArrayList<String> getAmostras() {
        ArrayList<String> mock = new ArrayList<>();
        mock.add("amostra1");
        mock.add("eu to literalmente copiando mocks aqui");
        mock.add("affs chato isso");
        return mock;
    }

    private int getIdFuro() {
        return 0;
    }

    protected void updateAmostrasAdapter(RecyclerView recyclerAmostras) {
        amostras = getAmostras();
        idFuro = getIdFuro();

        AmostraAdapter adapter = new AmostraAdapter();
        adapter.setAmostras(amostras);
        adapter.setIdFuro(idFuro);

        recyclerAmostras.setAdapter(adapter);
        recyclerAmostras.setLayoutManager(new LinearLayoutManager(recyclerAmostras.getContext()));
    }

    protected void deleteAmostrasButtonListener(View view) {
    }
}
