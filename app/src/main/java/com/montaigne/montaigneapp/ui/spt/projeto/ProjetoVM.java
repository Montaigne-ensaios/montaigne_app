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
    private List<FuroSpt> furos;

    protected void updateFurosAdapter(RecyclerView recyclerFuros) {
        // TODO: no caso de passar o projetoSpt para o adapter, não é preciso setar ele aqui
        FurosAdapter adapter = new FurosAdapter();
        adapter.setFuros(projetoSpt.getListaDeFuros());
        adapter.setProjetoSpt(projetoSpt);

        recyclerFuros.setAdapter(adapter);
        recyclerFuros.setLayoutManager(new LinearLayoutManager(recyclerFuros.getContext()));
    }

    protected void deleteFurosButtonListener(View view) {
    }

    private List<FuroSpt> getFuros() {
        /*
        ArrayList<String> mock = new ArrayList<>();
        mock.add("furo1");
        mock.add("outro furo");
        mock.add("vc já entendeu");
        return mock;
         */

        return projetoSpt.getListaDeFuros();
    }

    public ProjetoSpt getProjetoSpt() {
        return projetoSpt;
    }

    public void setProjetoSpt(ProjetoSpt projetoSpt) {
        this.projetoSpt = projetoSpt;
    }
}
