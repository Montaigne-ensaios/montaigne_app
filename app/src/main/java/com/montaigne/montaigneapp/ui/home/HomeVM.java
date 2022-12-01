package com.montaigne.montaigneapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.data.ModelHolder;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.Projeto;

import java.util.ArrayList;
import java.util.List;

public class HomeVM extends ViewModel implements ModelHolder<Projeto> {
    // Keys de Bundle:
    public static final String PROJETO = "projeto";

    private List<Projeto> projetosSalvos = new ArrayList<>();
    private ProjetosSalvosAdapter adapter;

    protected void initializeProjetoCategoriaAdapter(RecyclerView recyclerProjetoCategorias) {
        ArrayList<Object[]> categorias = new ArrayList<>();  // lista de filtros de projeto
        Context context = recyclerProjetoCategorias.getContext();
        categorias.add(new Object[]{context.getString(R.string.categoria_spt), R.drawable.ic_logospt_azul});
        categorias.add(new Object[]{context.getString(R.string.categoria_granulometria), R.drawable.ic_logospt_azul});

        ProjetoCategoriaAdapter adapter = new ProjetoCategoriaAdapter();
        adapter.setCategoriasProjeto(categorias);

        recyclerProjetoCategorias.setAdapter(adapter);
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

    private void categoriaFilterListener(View view) {
        // seleciona apenas os projetos da categoria especifica
    }

    protected void newProject(Context context) {
        // passa novo projeto vazio
        Intent intent = new Intent(context, SptActivity.class);
        intent.putExtra(HomeVM.PROJETO, new ProjetoSpt());
        context.startActivity(intent);
    }

    public void removeProjects() {
        for (int i = 0; i < projetosSalvos.size(); i++) {
            if (adapter.getIsCheckedList().get(i)) {
                Projeto projeto = projetosSalvos.get(i);
                if (projeto.getClass() == ProjetoSpt.class) {
                    Log.d("Delete", "Deletando projeto " + projeto.getNome());
                    ProjetoSptUseCase.delete((ProjetoSpt) projeto);
                }
            }
        }
        refreshProjetosSalvos();
    }
}
