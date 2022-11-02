package com.montaigne.montaigneapp.ui.spt.projeto;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.List;

public class ProjetoVM extends ViewModel {
    private ProjetoSpt projetoSpt;

    protected void updateFurosAdapter(RecyclerView recyclerFuros) {
        // TODO: no caso de passar o projetoSpt para o adapter, não é preciso setar ele aqui
        FurosAdapter adapter = new FurosAdapter();
        adapter.setFuros(projetoSpt.getListaDeFuros());
        adapter.setProjetoSpt(projetoSpt);

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
