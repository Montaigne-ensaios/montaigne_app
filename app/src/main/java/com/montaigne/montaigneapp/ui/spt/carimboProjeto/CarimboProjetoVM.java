package com.montaigne.montaigneapp.ui.spt.carimboProjeto;

import android.app.Activity;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.utils.Geolocation;

import java.io.IOException;
import java.util.Map;

public class CarimboProjetoVM extends ViewModel {
    private ProjetoSpt projetoSpt;
    private CarimboProjetoAdapter adapter;

    protected void setProjeto(ProjetoSpt projetoSpt) { this.projetoSpt = projetoSpt; }

    protected Projeto getProjeto() {
        return adapter.updateProjetoSpt(projetoSpt);
    }

    protected void setLocal(Activity activity, Coordenada coordenada) {
        try {
            projetoSpt.setEndereco(Geolocation.geocoder(activity, coordenada));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }     // todo: handle exception
    }

    protected void initializeRecycler(RecyclerView recycler) {
        adapter = new CarimboProjetoAdapter(projetoSpt);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(recycler.getContext()));
    }
}
