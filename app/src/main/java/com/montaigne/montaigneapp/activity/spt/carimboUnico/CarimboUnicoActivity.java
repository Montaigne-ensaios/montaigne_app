package com.montaigne.montaigneapp.activity.spt.carimboUnico;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.montaigne.montaigneapp.activity.AbstractActivity;

public class CarimboUnicoActivity extends AbstractActivity {
    protected Button buttonRetorno;
    protected Button buttonInicial;
    protected Button buttonCapturarLocalizacao;
    protected Button buttonComecar;
    protected EditText fieldData;
    protected EditText fieldNivelFuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CarimboUnicoVM viewModel = new CarimboUnicoVM(this);
    }

    @Override
    protected void initializeViews() {

    }
}