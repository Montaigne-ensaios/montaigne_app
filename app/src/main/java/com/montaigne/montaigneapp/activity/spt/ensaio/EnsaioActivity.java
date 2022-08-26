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
    protected EditText editTextProfundidade, editTextGolpe1, editTextGolpe2, editTextGolpe3,
            editTextPenetracao1, editTextPenetracao2, editTextPenetracao3, editTextNivelAgua;
    protected ArrayList<EditText> golpes, penetracoes;
    // lista de golpes e penetrações por segmento
    protected ArrayList<Button> buttonsIncrementGolpes, buttonsDecrementGolpes;
    protected Button buttonFinalizarFuro;
    protected ImageButton imageButtonDiminuirGolpe1, imageButtonDiminuirGolpe2, imageButtonDiminuirGolpe3, imageButtonAumentarGolpe3,
        imageButtonAumentarGolpe2, imageButtonAumentarGolpe1, imageButtonHelpNivelAgua, imageButtonHome;


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
        editTextGolpe1 = findViewById(R.id.editTextGolpe1);
        editTextGolpe2 = findViewById(R.id.editTextGolpe2);
        editTextGolpe3 = findViewById(R.id.editTextGolpe3);
        editTextPenetracao1 = findViewById(R.id.editTextPenetracao1);
        editTextPenetracao2 = findViewById(R.id.editTextPenetracao2);
        editTextPenetracao3 = findViewById(R.id.editTextPenetracao3);
        editTextNivelAgua = findViewById(R.id.editTextNivelAgua);
        buttonFinalizarFuro = findViewById(R.id.buttonFinalizarFuro);
        imageButtonHome = findViewById(R.id.imageButtonHome);
        imageButtonDiminuirGolpe1 = findViewById(R.id.imageButtonDiminuirGolpe1);
        imageButtonDiminuirGolpe2 = findViewById(R.id.imageButtonDiminuirGolpe2);
        imageButtonDiminuirGolpe3 = findViewById(R.id.imageButtonDiminuirGolpe3);
        imageButtonAumentarGolpe1 = findViewById(R.id.imageButtonAumentarGolpe1);
        imageButtonAumentarGolpe2 = findViewById(R.id.imageButtonAumentarGolpe2);
        imageButtonAumentarGolpe3 = findViewById(R.id.imageButtonAumentarGolpe3);
        imageButtonHelpNivelAgua = findViewById(R.id.imageButtonHelpNivelAgua);
    }
}

