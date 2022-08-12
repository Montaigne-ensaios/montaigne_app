package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.montaigne.montaigneapp.activity.AbstractActivity;

public class CarimboDefinitivoActivity extends AbstractActivity {
    protected Button buttonRetorno;
    protected Button buttonInicial;
    protected Button buttonContinuacao;
    protected ImageButton buttonCamera;
    protected ImageView imagePessoa;
    protected EditText fieldNomeProjeto;
    protected EditText fieldTecnica;
    protected EditText fieldCompanhia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CarimboDefinitivoVM viewModel = new CarimboDefinitivoVM(this);
        initializeViews();
    }

    protected void initializeViews() {

    }
}