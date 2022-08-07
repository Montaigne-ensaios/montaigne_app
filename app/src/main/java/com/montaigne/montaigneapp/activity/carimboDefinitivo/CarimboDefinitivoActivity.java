package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.montaigne.montaigneapp.activity.AbstractActivity;

public class CarimboDefinitivoActivity extends AbstractActivity {
    protected Button buttonReturn;
    protected Button buttonHome;
    protected Button buttonCamera;
    protected Button buttonContinuation;
    protected EditText fieldProjectName;
    protected EditText fieldTecnic;
    protected EditText fieldCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CarimboDefinitivoVM viewModel = new CarimboDefinitivoVM(this);
        initializeViews();
    }

    protected void initializeViews() {

    }
}