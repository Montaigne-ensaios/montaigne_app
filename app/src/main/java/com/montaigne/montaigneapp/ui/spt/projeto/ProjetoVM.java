package com.montaigne.montaigneapp.ui.spt.projeto;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class ProjetoVM extends ViewModel {
    private ProjetoSpt projetoSpt;

    protected void updateFurosAdapter(RecyclerView recyclerFuros) {
        // TODO: implementar deleção
        FurosAdapter adapter = new FurosAdapter();
        adapter.setFuros(projetoSpt.getListaDeFuros());
        adapter.getOnClickObservable().observeForever(furoSpt -> {
            Log.d("FurosAdapterClick", "Furo clicado: " + furoSpt.getCodigo());
        });

        recyclerFuros.setAdapter(adapter);
        recyclerFuros.setLayoutManager(new LinearLayoutManager(recyclerFuros.getContext()));
    }

    public ProjetoSpt getProjetoSpt() {
        return projetoSpt;
    }

    public void setProjetoSpt(ProjetoSpt projetoSpt) {
        this.projetoSpt = projetoSpt;
    }
}
