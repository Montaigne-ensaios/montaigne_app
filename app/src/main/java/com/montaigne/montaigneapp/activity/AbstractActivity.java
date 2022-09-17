package com.montaigne.montaigneapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.montaigne.montaigneapp.activity.home.HomeActivity;

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

    public static void homeButtonListener(View view) {
        Intent intent = new Intent(view.getContext(), HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }
}
