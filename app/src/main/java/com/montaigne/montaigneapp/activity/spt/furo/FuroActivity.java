package com.montaigne.montaigneapp.activity.spt.furo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;

public class FuroActivity extends AbstractActivity {
    protected RecyclerView recyclerAmostras;
    protected ImageButton buttonAddAmostra;
    protected ImageButton buttonDeleteAmostra;
    protected Button buttonPrint;
    protected TextView textAmostra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String nome = getIntent().getStringExtra("name");
        textAmostra.setText(nome);
        FuroVM viewModel = new FuroVM(this);
    }

    @Override
    protected boolean initializeViews() {
        setContentView(R.layout.acitivity_furo);

        buttonAddAmostra = findViewById(R.id.imageButtonAddAmostra);
        buttonDeleteAmostra = findViewById(R.id.imageButtonDeleteAmostra);
        buttonPrint = findViewById(R.id.buttonPrint);
        recyclerAmostras = findViewById(R.id.recyclerAmostra);
        textAmostra = findViewById(R.id.textAmostra);

        return buttonAddAmostra == null;
    }
}