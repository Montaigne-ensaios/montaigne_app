package com.montaigne.montaigneapp.activity.spt.furo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;

public class FuroActivity extends AbstractActivity {
    protected RecyclerView recyclerAmostras;
    protected ImageButton buttonAddAmostra;
    protected ImageButton buttonDeleteAmostra;
    protected Button buttonPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_furo);

        initializeViews();
        FuroVM viewModel = new FuroVM(this);
    }

    @Override
    protected void initializeViews() {
        buttonAddAmostra = findViewById(R.id.imageButtonAddAmostra);
        buttonDeleteAmostra = findViewById(R.id.imageButtonDeleteAmostra);
        buttonPrint = findViewById(R.id.buttonPrint);
        recyclerAmostras = findViewById(R.id.recyclerAmostra);
    }
}