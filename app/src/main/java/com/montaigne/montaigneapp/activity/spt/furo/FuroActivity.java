package com.montaigne.montaigneapp.activity.spt.furo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;

public class FuroActivity extends AbstractActivity {
    protected RecyclerView recyclerAmostras;
    protected Button buttonDeleteAmostras;
    protected ImageButton imageButtonExcluirAmostra;
    protected ImageButton imageButtonAdicionarAmostra;
    protected Button buttonImprimir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();
        setContentView(R.layout.acitivity_furo);
        FuroVM viewModel = new FuroVM(this);
    }

    @Override
    protected void initializeViews() {
        imageButtonAdicionarAmostra = findViewById(R.id.imageButtonAdicionarAmostra);
        imageButtonExcluirAmostra = findViewById(R.id.imageButtonExcluirAmostra);
        buttonImprimir = findViewById(R.id.buttonImprimir);
    }
}