package com.montaigne.montaigneapp.activity.home;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;
import com.montaigne.montaigneapp.data.usecase.AmostraSptUseCase;
import com.montaigne.montaigneapp.data.usecase.FuroSptUseCase;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeActivity extends AbstractActivity {
    protected FloatingActionButton newProjectFab;
    protected RecyclerView recyclerProjetoCategorias, recyclerProjetosSalvos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeViews();

        HomeVM viewModel = new ViewModelProvider(this).get(HomeVM.class);

        viewModel.initializeProjetosSalvosAdapter(recyclerProjetosSalvos);
        viewModel.initializeProjetoCategoriaAdapter(recyclerProjetoCategorias);
        newProjectFab.setOnClickListener(viewModel::newProjectFabListener);
        viewModel.refreshProjetosSalvos();
    }

    @Override
    protected void initializeViews() {
        newProjectFab = findViewById(R.id.fabNewProjeto);
        recyclerProjetoCategorias = findViewById(R.id.recyclerCategorias);
        recyclerProjetosSalvos = findViewById(R.id.recyclerProjetosSalvos);
    }
}