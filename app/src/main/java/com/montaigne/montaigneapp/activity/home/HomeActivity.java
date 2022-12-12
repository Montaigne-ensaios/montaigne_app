package com.montaigne.montaigneapp.activity.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;



public class HomeActivity extends AbstractActivity {
    protected FloatingActionButton newProjectFab;
    protected RecyclerView recyclerProjetoCategorias, recyclerProjetosSalvos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HomeVM viewModel = new ViewModelProvider(this).get(HomeVM.class);

        viewModel.initializeProjetosSalvosAdapter(recyclerProjetosSalvos);
        viewModel.initializeProjetoCategoriaAdapter(recyclerProjetoCategorias);
        newProjectFab.setOnClickListener(viewModel::newProjectFabListener);
        viewModel.refreshProjetosSalvos();
    }

    @Override
    protected boolean initializeViews() {
        setContentView(R.layout.activity_home);

        newProjectFab = findViewById(R.id.fabNewProjeto);
        recyclerProjetoCategorias = findViewById(R.id.recyclerCategorias);
        recyclerProjetosSalvos = findViewById(R.id.recyclerProjetosSalvos);

        return newProjectFab == null;
    }

}