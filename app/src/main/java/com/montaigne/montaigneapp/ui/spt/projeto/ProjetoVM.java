package com.montaigne.montaigneapp.ui.spt.projeto;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.data.usecase.FuroSptUseCase;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;

public class ProjetoVM extends ViewModel {
    private ProjetoSpt projeto;

    protected void updateFurosAdapter(RecyclerView recyclerFuros) {
        // TODO: implementar deleção
        FurosAdapter adapter = new FurosAdapter(projeto.getListaDeFuros());
        adapter.getOnClickObservable().observeForever(furoSpt -> {
            FragmentManager manager = ((SptActivity) recyclerFuros.getContext())
                    .getSupportFragmentManager();

            Bundle b = new Bundle();

            int furoId = 0;
            for (int i = 0; i < projeto.getListaDeFuros().size(); i++) {
                if (furoSpt.equals(projeto.getListaDeFuros().get(i))) {
                    furoId = i;
                    break;
                }
            }
            
            b.putInt("furoId", furoId);

            SptVM.navigateFragments(R.id.action_edit_Furo, manager, b);
        });

        recyclerFuros.setAdapter(adapter);
        recyclerFuros.setLayoutManager(new LinearLayoutManager(recyclerFuros.getContext()));
    }

    protected void removeFuro(int furoId) {
        FuroSptUseCase.delete(furoId, projeto);
    }

    public ProjetoSpt getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoSpt projeto) {
        this.projeto = projeto;
    }
}
