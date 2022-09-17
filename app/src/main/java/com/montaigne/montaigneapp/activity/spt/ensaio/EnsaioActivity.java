package com.montaigne.montaigneapp.activity.spt.ensaio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;
import com.montaigne.montaigneapp.activity.home.HomeVM;

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
        EnsaioVM viewModel = new ViewModelProvider(this).get(EnsaioVM.class);
        viewModel.setExtras(getIntent().getExtras());

        textAmostraN.setText("Amostra " + viewModel.getAmostra().getId());

        buttonFinalizarFuro.setOnClickListener(v -> viewModel.finalizarFuroButtonListener (v, golpes, penetracoes));
        imageButtonHome.setOnClickListener(viewModel::homeButtonListener);

        for (int i = 0; i < 3; i++) {
            buttonsIncrementGolpes.get(i).setOnClickListener(v -> viewModel.incrementGolpe((EditText) v));
            buttonsDecrementGolpes.get(i).setOnClickListener(v -> viewModel.decrementGolpe((EditText) v));
        }
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

