package com.montaigne.montaigneapp.activity.spt.ensaio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;

import java.util.ArrayList;

public class EnsaioActivity extends AbstractActivity {
    protected EditText editTextProfundidade, editTextNivelAgua;
    protected ArrayList<EditText> golpes, penetracoes;
    // lista de golpes e penetrações por segmento
    protected ArrayList<Button> buttonsIncrementGolpes = new ArrayList<>(),
            buttonsDecrementGolpes = new ArrayList<>();
    protected Button buttonFinalizarFuro;
    protected ImageButton imageButtonHelpNivelAgua, imageButtonHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EnsaioVM viewModel = new EnsaioVM(this);
        initializeViews();
        setContentView(R.layout.activity_ensaio);
    }

    @Override
    protected void initializeViews() {
        editTextProfundidade = findViewById(R.id.editTextProfundidade);
        golpes.add(findViewById(R.id.editTextGolpe1));
        golpes.add(findViewById(R.id.editTextGolpe2));
        golpes.add(findViewById(R.id.editTextGolpe3));
        penetracoes.add(findViewById(R.id.editTextPenetracao1));
        penetracoes.add(findViewById(R.id.editTextPenetracao2));
        penetracoes.add(findViewById(R.id.editTextPenetracao3));
        editTextNivelAgua = findViewById(R.id.editTextNivelAgua);
        buttonFinalizarFuro = findViewById(R.id.buttonFinalizarFuro);
        imageButtonHome = findViewById(R.id.imageButtonHome);
        imageButtonHelpNivelAgua = findViewById(R.id.imageButtonHelpNivelAgua);
        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonDiminuirGolpe1));
        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonDiminuirGolpe2));
        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonDiminuirGolpe3));
        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonAumentarGolpe1));
        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonAumentarGolpe2));
        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonAumentarGolpe3));

    }
}

