package com.montaigne.montaigneapp.activity.spt.projeto;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class ProjetoActivity extends AbstractActivity {
    protected RecyclerView recyclerFuros;
    protected ImageButton buttonDeleteFuro, buttonAddFuro;
    // todo: pensar na implementação do DeleteFuro
    protected TextView textFuro;  // todo: remover quando corrigido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projeto);

        initializeViews();

        ProjetoSpt projetoSpt = (ProjetoSpt) getIntent().getSerializableExtra("projeto");
        // talvez seja uma boa usar enum para padronizar os nomes dos extras em intents
        textFuro.setText(projetoSpt.getNome() + ". " + textFuro.getText());

        ProjetoVM viewModel = new ViewModelProvider(this).get(ProjetoVM.class);
        viewModel.setProjetoSpt(projetoSpt);

        projetoSpt.getListaDeFuros();

        buttonDeleteFuro.setOnClickListener(viewModel::deleteFurosButtonListener);
        viewModel.updateFurosAdapter(recyclerFuros);
    }

    @Override
    protected void initializeViews() {
        recyclerFuros = findViewById(R.id.recyclerFuro);
        buttonDeleteFuro = findViewById(R.id.imageButtonDeleteFuro);
        buttonAddFuro = findViewById(R.id.imageButtonAddFuro);
        textFuro = findViewById(R.id.textFuro);  // adicionado apenas pela atual ausência
        // de título na activity
    }
}