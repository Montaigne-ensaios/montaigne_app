package com.montaigne.montaigneapp.activity.spt.projeto;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;

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

        String nome = getIntent().getStringExtra("name");
        // talvez seja uma boa usar enum para padronizar os nomes dos extras em intents
        textFuro.setText(nome + ". " + textFuro.getText());

        ProjetoVM viewModel = new ViewModelProvider(this).get(ProjetoVM.class);
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