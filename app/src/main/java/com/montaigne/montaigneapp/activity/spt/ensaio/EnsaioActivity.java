package com.montaigne.montaigneapp.activity.spt.ensaio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;

import java.util.ArrayList;

public class EnsaioActivity extends AbstractActivity {
    protected EditText editTextProfundidade, editTextNivelAgua;
    protected final ArrayList<EditText> golpes = new ArrayList<>(), penetracoes = new ArrayList<>();
    // lista de golpes e penetrações por segmento
    protected final ArrayList<ImageButton> buttonsIncrementGolpes = new ArrayList<>(),
            buttonsDecrementGolpes = new ArrayList<>();
    protected Button buttonFinalizarFuro;
    protected ImageButton imageButtonHelpNivelAgua, imageButtonHome;
    protected TextView textAmostraN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ensaio);

        initializeViews();
        EnsaioVM viewModel = new EnsaioVM(this);
    }

    @Override
    protected void initializeViews() {
        textAmostraN = findViewById(R.id.textAmostraN);
        editTextProfundidade = findViewById(R.id.editTextProfundidade);
        golpes.add(findViewById(R.id.editTextGolpe1));
        golpes.add(findViewById(R.id.editTextGolpe2));
        golpes.add(findViewById(R.id.editTextGolpe3));
        penetracoes.add(findViewById(R.id.editTextPenetracao1));
        penetracoes.add(findViewById(R.id.editTextPenetracao2));
        penetracoes.add(findViewById(R.id.editTextPenetracao3));
        editTextNivelAgua = findViewById(R.id.editTextNivelAgua);
        buttonFinalizarFuro = findViewById(R.id.buttonFinishFuro);
        imageButtonHome = findViewById(R.id.imageButtonHome);
        imageButtonHelpNivelAgua = findViewById(R.id.imageButtonHelpNivelAgua);
        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonIcrementGolpe1));
        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonIcrementGolpe2));
        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonIcrementGolpe3));
        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonDecrementGolpe1));
        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonDecrementGolpe2));
        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonDecrementGolpe3));

    }
}

