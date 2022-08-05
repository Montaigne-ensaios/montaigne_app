package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.montaigne.montaigneapp.activity.AbstractActivity;

public class CarimboDefinitivoActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeViews();

        CarimboDefinitivoVM viewModel = new CarimboDefinitivoVM();
    }

    protected void initializeViews() {

    }
}