package com.montaigne.montaigneapp.activity.spt.furo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
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
        setContentView(R.layout.acitivity_furo);

        initializeViews();

        String nome = getIntent().getStringExtra("name");
        textAmostra.setText(nome);
        FuroVM viewModel = new ViewModelProvider(this).get(FuroVM.class);
        buttonDeleteAmostra.setOnClickListener(viewModel::deleteAmostrasButtonListener);
        viewModel.updateAmostrasAdapter(recyclerAmostras);
    }

    @Override
    protected void initializeViews() {
        buttonAddAmostra = findViewById(R.id.imageButtonAddAmostra);
        buttonDeleteAmostra = findViewById(R.id.imageButtonDeleteAmostra);
        buttonPrint = findViewById(R.id.buttonPrint);
        recyclerAmostras = findViewById(R.id.recyclerAmostra);
        textAmostra = findViewById(R.id.textAmostra);
    }
}