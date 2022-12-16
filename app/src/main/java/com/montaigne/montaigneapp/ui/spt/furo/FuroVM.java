package com.montaigne.montaigneapp.ui.spt.furo;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.data.usecase.FuroSptUseCase;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.Objects;

public class FuroVM extends ViewModel {
    private String  idFuro;
    private ProjetoSpt projetoSpt;

//    private FuroSpt getFuro() {
//        return projetoSpt.getListaDeFuros().get(idFuro);  // fixme: como recuperar furo de uma lista de furos
//    }

    public ProjetoSpt getProjetoSpt() {
        return projetoSpt;
    }

    public void setFuro(ProjetoSpt projetoSpt, String idFuro) {
        this.projetoSpt = projetoSpt;
        if (!Objects.equals(idFuro, "")) {
            this.idFuro = idFuro;
        } else {
            FuroSpt furo = new FuroSpt();
            FuroSptUseCase.save(furo, projetoSpt);
            this.idFuro = furo.getId();  // fixme: como esse id será gerado???
        }
    }

    protected void updateAmostrasAdapter(RecyclerView recyclerAmostras) {
        // todo: implementar deleção
        AmostraAdapter adapter = new AmostraAdapter();
        adapter.setIdFuro(idFuro);
        adapter.setProjetoSpt(projetoSpt);

        recyclerAmostras.setAdapter(adapter);
        recyclerAmostras.setLayoutManager(new LinearLayoutManager(recyclerAmostras.getContext()));
    }

}
