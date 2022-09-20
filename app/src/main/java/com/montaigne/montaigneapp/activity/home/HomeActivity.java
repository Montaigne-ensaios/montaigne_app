package com.montaigne.montaigneapp.activity.home;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;
public class HomeActivity extends AbstractActivity {
    protected FloatingActionButton newProjectFab;
    protected RecyclerView recyclerProjetoCategorias, recyclerProjetosSalvos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeViews();

        HomeVM viewModel = new HomeVM(this);
    }

    @Override
    protected void initializeViews() {
        newProjectFab = findViewById(R.id.fabNewProjeto);
        recyclerProjetoCategorias = findViewById(R.id.recyclerCategorias);
        recyclerProjetosSalvos = findViewById(R.id.recyclerProjetosSalvos);
    }

    }