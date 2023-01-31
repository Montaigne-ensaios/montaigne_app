package com.montaigne.montaigneapp.ui.spt.projeto;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.data.usecase.FuroSptUseCase;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;

public class ProjetoVM extends ViewModel {
    private ProjetoSpt projetoSpt;

    protected void updateFurosAdapter(RecyclerView recyclerFuros) {
        // TODO: implementar deleção
        FurosAdapter adapter = new FurosAdapter(projetoSpt.getListaDeFuros());
        adapter.getOnClickObservable().observeForever(furoSpt -> {
            FragmentManager manager = ((SptActivity) recyclerFuros.getContext())
                    .getSupportFragmentManager();

            SptVM.navigateFragments(R.id.action_edit_Furo, manager);
        });

        recyclerFuros.setAdapter(adapter);
        recyclerFuros.setLayoutManager(new LinearLayoutManager(recyclerFuros.getContext()));
    }

    protected void removeFuro(FuroSpt furoSpt) {
//        FuroSptUseCase.delete(furoSpt.getId(), projetoSpt);  // fixme: tipo do id incompatível
    }

    public ProjetoSpt getProjetoSpt() {
        return projetoSpt;
    }

    public void setProjetoSpt(ProjetoSpt projetoSpt) {
        this.projetoSpt = projetoSpt;
    }
}
