package com.montaigne.montaigneapp.ui.spt.furo;

import android.util.Log;
import android.util.SparseBooleanArray;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.data.usecase.FuroSptUseCase;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.IClickListener;

import java.util.ArrayList;
import java.util.List;

public class FuroVM extends ViewModel {
    private ProjetoSpt projeto;
    private int furoId;
    private FuroSpt furo;
    private List<FuroSpt> listaDeFuros;
    private IClickListener clickListener;
    private AmostraAdapter amostraAdapter;

    public AmostraAdapter getAmostraAdapter() {
        return amostraAdapter;
    }

    public void setAmostraAdapter(AmostraAdapter amostraAdapter) {
        this.amostraAdapter = amostraAdapter;
    }

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
        amostraAdapter = new AmostraAdapter();
        listaDeFuros = projeto.getListaDeFuros();
        amostraAdapter.setAmostras(projeto.getListaDeFuros().get(furoId).getListaDeAmostras());

        recyclerAmostras.setAdapter(amostraAdapter);
        recyclerAmostras.setLayoutManager(new LinearLayoutManager(recyclerAmostras.getContext()));
    }

    public void setClickListener(IClickListener clickListener) {
        amostraAdapter.setClickListener(clickListener);
    }

    public void togglePositions(int position) {
        amostraAdapter.togglePositions(position);
    }

    public SparseBooleanArray getSelectedItems() {
        return amostraAdapter.getSelectedItems();
    }

    protected void removeFuros(RecyclerView recyclerAmostra) {
        List<FuroSpt> deletedFurosList = new ArrayList<>();
        for (int i = 0; i < projeto.getListaDeFuros().size(); i++) {
            if (amostraAdapter.getSelectedItems().get(i)) {
                FuroSpt furo = projeto.getListaDeFuros().get(i);
                deletedFurosList.add(furo);
                if (furo.getClass() == FuroSpt.class) {
                    Log.d("Delete", "Deletando furo " + furo.getCodigo());
                    FuroSptUseCase.delete(i, projeto);
                }
            }
        }

        updateFuros(deletedFurosList, recyclerAmostra);
    }

    protected void updateFuros(List<FuroSpt> furosList, RecyclerView recyclerView) {
        projeto.getListaDeFuros().removeAll(furosList);
        updateAmostrasAdapter(recyclerView);
    }
}
