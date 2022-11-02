package com.montaigne.montaigneapp.activity.home;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.carimboDefinitivo.CarimboDefinitivoActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeVM extends ViewModel {
    private ProjetoCategoriaAdapter adapterCategorias;
    private ProjetosSalvosAdapter adapterProjetosSalvos;

    protected void initializeProjetoCategoriaAdapter(RecyclerView recyclerProjetoCategorias) {
        this.adapterCategorias = new ProjetoCategoriaAdapter();

        // todo: substituir strings por referência ao `values.xml`
        List<Object[]> categorias = new ArrayList<>();  // lista de filtros de projeto
        categorias.add(new Object[]{"SPT", R.drawable.ic_logospt_azul});
        categorias.add(new Object[]{"Granulometria", R.drawable.ic_logospt_azul});

        adapterCategorias.setCategoriasProjeto(categorias);

        recyclerProjetoCategorias.setAdapter(adapterCategorias);
        recyclerProjetoCategorias.setLayoutManager(new LinearLayoutManager(
                        recyclerProjetoCategorias.getContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false));
    }

    protected void initializeProjetosSalvosAdapter(RecyclerView recyclerProjetosSalvos) {
        adapterProjetosSalvos = new ProjetosSalvosAdapter(recyclerProjetosSalvos.getContext());
        adapterProjetosSalvos.refreshProjetoList();

        recyclerProjetosSalvos.setAdapter(adapterProjetosSalvos);
        recyclerProjetosSalvos.setLayoutManager(new LinearLayoutManager(
                recyclerProjetosSalvos.getContext(),
                LinearLayoutManager.VERTICAL,
                false));
    }

//    @Override
//    public void addModel(Projeto projeto) {
//        projetosSalvos.add(projeto);
//        adapter.setProjetoList(projetosSalvos);
//    }
//
//    @Override
//    public void clearModels() {
//        projetosSalvos = new ArrayList<>();
//        adapter.setProjetoList(projetosSalvos);
//    }

    private void categoriaFilterListener(View view) {
        // seleciona apenas os projetos da categoria especifica
    }

    protected void newProjectFabListener(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), CarimboDefinitivoActivity.class));
    }
}
