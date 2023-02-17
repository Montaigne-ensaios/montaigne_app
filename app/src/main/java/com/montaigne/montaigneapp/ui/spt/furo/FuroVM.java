package com.montaigne.montaigneapp.ui.spt.furo;

import android.util.SparseBooleanArray;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
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
    private List<AmostraSpt> listaDeAmostras;
    private IClickListener clickListener;
    private AmostraAdapter amostraAdapter;

    public AmostraAdapter getAmostraAdapter() {
        return amostraAdapter;
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
        amostraAdapter = new AmostraAdapter();
        listaDeFuros = projeto.getListaDeFuros();
        listaDeAmostras = listaDeFuros.get(furoId).getListaDeAmostras();
        amostraAdapter.setAmostras(listaDeAmostras);

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

    protected void removeAmostras() {
        List<AmostraSpt> listaDeAmostrasDeletadas = new ArrayList<>();
        for (int i = 0; i < listaDeAmostras.size(); i++) {
            if (amostraAdapter.getSelectedItems().get(i)) {
                AmostraSpt amostra = listaDeAmostras.get(i);
                if (amostra.getClass() == AmostraSpt.class) {
                    listaDeAmostrasDeletadas.add(amostra);
                }
            }
        }
        refreshAmostrasSalvas(listaDeAmostrasDeletadas);
    }

    private void refreshAmostrasSalvas(List<AmostraSpt> amostras) {
        System.out.println(amostras.size());
        projeto.getListaDeFuros().get(furoId).getListaDeAmostras().removeAll(amostras);
        ProjetoSptUseCase.update(projeto);
        amostraAdapter.setAmostras(projeto.getListaDeFuros().get(furoId).getListaDeAmostras());
    }

}
