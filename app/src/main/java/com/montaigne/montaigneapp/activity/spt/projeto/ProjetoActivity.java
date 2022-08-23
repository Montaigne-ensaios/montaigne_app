package com.montaigne.montaigneapp.activity.spt.projeto;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;

public class ProjetoActivity extends AbstractActivity {
    protected RecyclerView recyclerFuros;
    protected ImageButton buttonDeleteFuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projeto);

        initializeViews();

        ProjetoVM viewModel = new ProjetoVM(this);
    }

    @Override
    protected void initializeViews() {
        recyclerFuros = findViewById(R.id.recyclerFuro);
        buttonDeleteFuro = findViewById(R.id.imageButtonDeleteFuro);
    }
}