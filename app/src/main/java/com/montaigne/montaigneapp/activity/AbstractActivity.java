package com.montaigne.montaigneapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class AbstractActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (initializeViews()) {  // teste obrigatório para testar a inicialização das views
            throw new AssertionError("Erro ao inicializar views");
        }
    }

    protected abstract boolean initializeViews();
    // deve retornar true se uma view de teste for nula
}
