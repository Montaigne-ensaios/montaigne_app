package com.montaigne.montaigneapp.activity.spt.projeto;

import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.montaigne.montaigneapp.activity.AbstractActivity;

public class ProjetoActivity extends AbstractActivity {
    protected RecyclerView recyclerFuros;
    protected Button buttonDeleteFuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ProjetoVM viewModel = new ProjetoVM(this);
    }

    @Override
    protected void initializeViews() {

    }
}