package com.montaigne.montaigneapp.ui.spt.furo;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class FuroVM extends ViewModel {
    private String  idFuro;
    private ProjetoSpt projetoSpt;

//    private FuroSpt getFuro() {
//        return projetoSpt.getListaDeFuros().get(idFuro);
//    }

    public ProjetoSpt getProjetoSpt() {
        return projetoSpt;
    }

    public void setFuro(ProjetoSpt projetoSpt, String idFuro) {
        this.idFuro = idFuro;
        this.projetoSpt = projetoSpt;
    }

    protected void updateFurosAdapter(RecyclerView recyclerAmostras) {
        // todo: implementar deleção
        AmostraAdapter adapter = new AmostraAdapter();
        adapter.setIdFuro(idFuro);
        adapter.setProjetoSpt(projetoSpt);

        recyclerAmostras.setAdapter(adapter);
        recyclerAmostras.setLayoutManager(new LinearLayoutManager(recyclerAmostras.getContext()));
    }

}
