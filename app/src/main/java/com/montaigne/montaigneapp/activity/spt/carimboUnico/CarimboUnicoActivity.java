package com.montaigne.montaigneapp.activity.spt.carimboUnico;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;

public class CarimboUnicoActivity extends AbstractActivity {
    protected Button buttonPegarLocalizacao;
    protected Button buttonIniciarEnsaio;
    protected EditText editTextDataInicio;
    protected EditText editTextNivelFuro;
    protected ImageButton imageButtonHelpDataInicio;
    protected ImageButton imageButtonHelpNivelFuro;
    protected ImageButton imageButtonHelpCoordenadaFuro;
    protected ImageButton imageButtonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeViews();
        CarimboUnicoVM viewModel = new ViewModelProvider(this).get(CarimboUnicoVM.class);

        viewModel.setExtras(getIntent().getExtras());
        imageButtonHome.setOnClickListener(viewModel::homeButtonListener);
        buttonIniciarEnsaio.setOnClickListener(v -> viewModel.ensaioButtonListener (v, editTextDataInicio));
    }

    @Override
    protected boolean initializeViews() {
        setContentView(R.layout.activity_carimbo_unico);

        buttonPegarLocalizacao = findViewById(R.id.buttonGetLocation);
        buttonIniciarEnsaio = findViewById(R.id.buttonStartEnsaio);
        editTextDataInicio = findViewById(R.id.editTextStartDate);
        editTextNivelFuro = findViewById(R.id.editTextNivelFuro);
       // imageButtonHelpCoordenadaFuro = findViewById(R.id.imageButtonHelpCoordenadaFuro);
       // imageButtonHelpDataInicio = findViewById(R.id.imageButtonHelpStartDate);
       // imageButtonHelpNivelFuro = findViewById(R.id.imageButtonHelpNivelFuro);
        imageButtonHome = findViewById(R.id.imageButtonHome);

        return buttonIniciarEnsaio == null;
    }
}