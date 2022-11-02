package com.montaigne.montaigneapp.ui.spt.furo;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.List;

public class FuroVM extends ViewModel {
    private int idFuro;
    private ProjetoSpt projetoSpt;

    private FuroSpt getFuro() {
        return projetoSpt.getListaDeFuros().get(idFuro);
    }

    public void setIdFuro(int idFuro) {
        this.idFuro = idFuro;
    }

    public ProjetoSpt getProjetoSpt() {
        return projetoSpt;
    }

    public void setFuro(ProjetoSpt projetoSpt, int idFuro) {
        this.idFuro = idFuro;
        this.projetoSpt = projetoSpt;
    }

    protected void updateFurosAdapter(RecyclerView recyclerAmostras) {

        AmostraAdapter adapter = new AmostraAdapter();
        adapter.setIdFuro(idFuro);
        adapter.setProjetoSpt(projetoSpt);

        recyclerAmostras.setAdapter(adapter);
        recyclerAmostras.setLayoutManager(new LinearLayoutManager(recyclerAmostras.getContext()));
    }

}
