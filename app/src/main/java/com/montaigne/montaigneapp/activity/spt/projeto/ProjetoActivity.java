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
    protected TextView textFuro;  // fixme: remover quando corrigido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ProjetoSpt projetoSpt = (ProjetoSpt) getIntent().getSerializableExtra("projeto");
        // todo: talvez seja uma boa usar enum para padronizar os nomes dos extras em intents
        textFuro.setText(projetoSpt.getNome() + ". " + textFuro.getText());

        ProjetoVM viewModel = new ViewModelProvider(this).get(ProjetoVM.class);
        viewModel.setProjetoSpt(projetoSpt);

        projetoSpt.getListaDeFuros();

        buttonDeleteFuro.setOnClickListener(viewModel::deleteFurosButtonListener);
        viewModel.updateFurosAdapter(recyclerFuros);
    }

    @Override
    protected boolean initializeViews() {
        setContentView(R.layout.fragment_projeto);

        recyclerFuros = findViewById(R.id.recyclerFuro);
        buttonDeleteFuro = findViewById(R.id.imageButtonDeleteFuro);
        buttonAddFuro = findViewById(R.id.imageButtonAddFuro);
        textFuro = findViewById(R.id.textFuro);  // adicionado apenas pela atual ausência
        // de título na activity

        return recyclerFuros == null;
    }
}