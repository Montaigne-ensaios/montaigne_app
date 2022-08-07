package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.montaigne.montaigneapp.activity.AbstractActivity;

public class CarimboDefinitivoActivity extends AbstractActivity {
    protected Button buttonReturn;
    protected Button buttonHome;
    protected Button buttonContinuation;
    protected ImageButton buttonCamera;
    protected ImageView imagePerson;
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