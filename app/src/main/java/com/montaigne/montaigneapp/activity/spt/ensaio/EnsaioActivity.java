package com.montaigne.montaigneapp.activity.spt.ensaio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.montaigne.montaigneapp.activity.AbstractActivity;

import java.util.ArrayList;

public class EnsaioActivity extends AbstractActivity {
    protected TextView textNomeAmostra;
    protected EditText fieldProfundidade, fieldNivelDAgua;
    protected ArrayList<EditText> golpes, penetracoes;
    // lista de golpes e penetrações por segmento
    protected ArrayList<Button> buttonsIncrementGolpes, buttonsDecrementGolpes;
    protected Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EnsaioVM viewModel = new EnsaioVM(this);
    }

    @Override
    protected void initializeViews() {

    }
}

