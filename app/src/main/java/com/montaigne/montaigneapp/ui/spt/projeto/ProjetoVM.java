package com.montaigne.montaigneapp.ui.spt.projeto;

import android.os.Bundle;
import android.util.SparseBooleanArray;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.IClickListener;
import com.montaigne.montaigneapp.utils.FragmentNavigator;
import com.montaigne.montaigneapp.ui.spt.SptActivity;

import java.util.ArrayList;
import java.util.List;

public class ProjetoVM extends ViewModel {
    private ProjetoSpt projeto;
    private FurosAdapter furosAdapter;
    protected void updateFurosAdapter(RecyclerView recyclerFuros) {
        furosAdapter = new FurosAdapter(projeto.getListaDeFuros());
        furosAdapter.getOnClickObservable().observeForever(furoSpt -> {
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

            FragmentNavigator.navigate(R.id.action_edit_Furo, manager, R.id.containerSpt, b);
        });

        recyclerFuros.setAdapter(furosAdapter);
        recyclerFuros.setLayoutManager(new LinearLayoutManager(recyclerFuros.getContext()));
    }

    protected void removeFuros() {
        List<FuroSpt> furosDeletados = new ArrayList<>();
        for (int i = 0; i < projeto.getListaDeFuros().size(); i++) {
            FuroSpt furo = projeto.getListaDeFuros().get(i);
            if (furo.getClass() == FuroSpt.class) {
                furosDeletados.add(furo);
            }
        }
        refreshFurosSalvos(furosDeletados);
    }

    private void refreshFurosSalvos(List<FuroSpt> furosDeletados) {
        projeto.getListaDeFuros().removeAll(furosDeletados);
        ProjetoSptUseCase.update(projeto);
        furosAdapter.setFuros(projeto.getListaDeFuros());
    }

    public ProjetoSpt getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoSpt projeto) {
        this.projeto = projeto;
    }

    public void setClickListener(IClickListener clickListener) {
        furosAdapter.setClickListener(clickListener);
    }

    public SparseBooleanArray getSelectedItems() {
        return furosAdapter.getSelectedItems();
    }

    public FurosAdapter getFurosAdapter() {
        return furosAdapter;
    }

    public void togglePositions(int position) {
        furosAdapter.togglePositions(position);
    }
}
