package com.montaigne.montaigneapp.activity.spt.projeto;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProjetoVM extends ViewModel {
    private ArrayList<String> furos;

    protected void updateFurosAdapter(RecyclerView recyclerFuros) {
        furos = getFuros();
        FurosAdapter adapter = new FurosAdapter();
        adapter.setFuros(furos);
        recyclerFuros.setAdapter(adapter);
        recyclerFuros.setLayoutManager(new LinearLayoutManager(recyclerFuros.getContext()));
    }

    protected void deleteFurosButtonListener(View view) {
    }

    private ArrayList<String> getFuros() {
        ArrayList<String> mock = new ArrayList<>();
        mock.add("furo1");
        mock.add("outro furo");
        mock.add("vc já entendeu");
        return mock;
    }
}
