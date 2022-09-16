package com.montaigne.montaigneapp.activity.home;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.carimboDefinitivo.CarimboDefinitivoActivity;

import java.util.ArrayList;

public class HomeVM extends ViewModel {
    private ArrayList<String> projetosSalvos;

    public HomeVM (HomeActivity activity) {
        updateProjetos();
    }

    protected void initializeProjetoCategoriaAdapter(HomeActivity activity) {
        ArrayList<Object[]> categorias = new ArrayList<>();  // lista de filtros de projeto
        categorias.add(new Object[]{"SPT", R.drawable.ic_logospt_azul});
        categorias.add(new Object[]{"Granulometria", R.drawable.ic_logospt_azul});

        ProjetoCategoriaAdapter adapter = new ProjetoCategoriaAdapter();
        adapter.setCategoriasProjeto(categorias);
        activity.recyclerProjetoCategorias.setAdapter(adapter);
        activity.recyclerProjetoCategorias.setLayoutManager(new LinearLayoutManager(
                        activity,
                        LinearLayoutManager.HORIZONTAL,
                        false));
    }

    protected void initializeProjetosSalvosAdapter(HomeActivity activity) {
        ProjetosSalvosAdapter adapter = new ProjetosSalvosAdapter(this.projetosSalvos);
        activity.recyclerProjetosSalvos.setAdapter(adapter);
        activity.recyclerProjetosSalvos.setLayoutManager(new LinearLayoutManager(activity));
    }

    private void updateProjetos() {
        ArrayList<String> mock = new ArrayList<>();
        mock.add("Exemplo de projeto");
        mock.add("Outro exemplo");
        mock.add("Só mais um");
        mock.add("Tá bom parei");
        this.projetosSalvos = mock;
    }

    protected void categoriaFilterListener(View view) {
        // seleciona apenas os projetos da categoria especifica
    }

    protected void newProjectFabListener(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), CarimboDefinitivoActivity.class));
    }
}
