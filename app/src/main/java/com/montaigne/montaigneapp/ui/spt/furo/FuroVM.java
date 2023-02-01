package com.montaigne.montaigneapp.ui.spt.furo;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class FuroVM extends ViewModel {
    private ProjetoSpt projeto;
    private int furoId;
    private FuroSpt furo;

    protected ProjetoSpt getProjeto() {
        return projeto;
    }

    protected void setFuro(ProjetoSpt projeto, int idFuro) {
        this.projeto = projeto;
        this.furoId = idFuro;

        if (idFuro == projeto.getListaDeFuros().size()) {
            furo = new FuroSpt();
        } else {
            furo = this.projeto.getListaDeFuros().get(idFuro);
        }
    }

    protected void updateAmostrasAdapter(RecyclerView recyclerAmostras) {
        // todo: implementar deleção
        AmostraAdapter adapter = new AmostraAdapter();
        adapter.setAmostras(projeto.getListaDeFuros().get(furoId).getListaDeAmostras());

        recyclerAmostras.setAdapter(adapter);
        recyclerAmostras.setLayoutManager(new LinearLayoutManager(recyclerAmostras.getContext()));
    }

}
