package com.montaigne.montaigneapp.activity.spt.furo;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.List;

public class FuroVM extends ViewModel {
    private int idFuro;
    private ProjetoSpt projetoSpt;
    private List<AmostraSpt> amostras;

    public int getIdFuro() {
        return idFuro;
    }

    public void setIdFuro(int idFuro) {
        this.idFuro = idFuro;
    }

    public ProjetoSpt getProjetoSpt() {
        return projetoSpt;
    }

    public void setProjetoSpt(ProjetoSpt projetoSpt) {
        this.projetoSpt = projetoSpt;
    }

    private List<AmostraSpt> getAmostras() {
        /*
        ArrayList<String> mock = new ArrayList<>();
        mock.add("amostra1");
        mock.add("eu to literalmente copiando mocks aqui");
        mock.add("affs chato isso");
         */

        return projetoSpt.getListaDeFuros().get(idFuro).getListaDeAmostras();
    }

    protected void updateAmostrasAdapter(RecyclerView recyclerAmostras) {
        amostras = getAmostras();
        idFuro = getIdFuro();

        AmostraAdapter adapter = new AmostraAdapter();
        adapter.setAmostras(amostras);
        adapter.setIdFuro(idFuro);
        adapter.setProjetoSpt(projetoSpt);

        recyclerAmostras.setAdapter(adapter);
        recyclerAmostras.setLayoutManager(new LinearLayoutManager(recyclerAmostras.getContext()));
    }

    protected void deleteAmostrasButtonListener(View view) {
    }
}
