package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CarimboDefinitivoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeViews();

        CarimboDefinitivoVM viewModel = new CarimboDefinitivoVM();
    }

    private void initializeViews() {

    }
}