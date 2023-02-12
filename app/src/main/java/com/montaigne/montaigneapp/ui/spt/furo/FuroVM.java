package com.montaigne.montaigneapp.ui.spt.furo;

import android.util.Log;
import android.util.SparseBooleanArray;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.montaigne.montaigneapp.data.usecase.AmostraSptUseCase;
import com.montaigne.montaigneapp.data.usecase.FuroSptUseCase;
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
    private final String TAG = "FuroFragment";

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
        for (int i = 0; i < projeto.getListaDeFuros().get(furoId).getListaDeAmostras().size(); i++) {
            if (amostraAdapter.getSelectedItems().get(i)) {
                AmostraSpt amostra = projeto.getListaDeFuros().get(furoId).getListaDeAmostras().get(i);
                if (amostra.getClass() == AmostraSpt.class) {
                    Log.d("Delete", "Deletando amostra");
                    AmostraSptUseCase.delete(i, furoId, projeto);
                }
            }
        }

        refreshAmostrasSalvas();
    }

    protected void refreshAmostrasSalvas() {
        ProjetoSptUseCase.read().addOnCompleteListener(t -> {
            if(t.isSuccessful()) {
                listaDeAmostras = new ArrayList<>();
                for (int i = 0; i < t.getResult().getChildrenCount(); i++) {
                    listaDeAmostras.add(
                            t.getResult().
                                    getValue(ProjetoSpt.class).
                                    getListaDeFuros().
                                    get(furoId).
                                    getListaDeAmostras().
                                    get(i)
                    );
                }
                amostraAdapter.setAmostras(listaDeAmostras);
            } else {
                Log.e(TAG, "Falha ao ler projetos do Banco de dados");
            }
        });
    }

    protected void updateFuros(List<FuroSpt> furosList, RecyclerView recyclerView) {
        projeto.getListaDeFuros().removeAll(furosList);
        updateAmostrasAdapter(recyclerView);
    }
}
