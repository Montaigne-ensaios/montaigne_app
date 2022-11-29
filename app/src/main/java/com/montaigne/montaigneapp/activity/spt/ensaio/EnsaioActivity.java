package com.montaigne.montaigneapp.activity.spt.ensaio;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

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

        initializeViews();
        EnsaioVM viewModel = new ViewModelProvider(this).get(EnsaioVM.class);
        // viewModel.setExtras(getIntent().getExtras());
        //TODO   Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'int java.lang.Integer.intValue()' on a null object reference
        //        at com.montaigne.montaigneapp.activity.spt.ensaio.EnsaioActivity.onCreate(EnsaioActivity.java:35)×
        // Não existe o extra idFuro, idAmostra, projuetoSPT em CarimboUnicoVM.java linha 68
        try {
            int idFuro = (int) getIntent().getExtras().get("idFuro");
            int idAmostra = (int) getIntent().getExtras().get("idAmostra");
            ProjetoSpt projetoSpt = (ProjetoSpt) getIntent().getExtras().get("projetoSpt");

            viewModel.setIdFuro(idFuro);
            viewModel.setIdAmostra(idAmostra);
            viewModel.setProjeto(projetoSpt);
            // TODO: rever métodos de atualização de uma amostra

        } catch (NullPointerException e) {
            Log.e("EnsaioActivity", e.getMessage());
            //TODO: Colocar os valores padrão dos extras.
        }

        for (int i = 0; i < 3; i++) {
            EditText editTextGolpe = golpes.get(i);
            buttonsIncrementGolpes.get(i).setOnClickListener(v ->
                    viewModel.incrementGolpe(editTextGolpe));
            buttonsDecrementGolpes.get(i).setOnClickListener(v ->
                    viewModel.decrementGolpe(editTextGolpe));
        }

    }

    @Override
    protected boolean initializeViews() {
        setContentView(R.layout.activity_ensaio);

        textAmostraN = findViewById(R.id.textAmostraN);
        editTextProfundidade = findViewById(R.id.editTextProfundidade);

        golpes.add(findViewById(R.id.editTextGolpe1));
        golpes.add(findViewById(R.id.editTextGolpe2));
        golpes.add(findViewById(R.id.editTextGolpe3));

        penetracoes.add(findViewById(R.id.editTextPenetracao1));
        penetracoes.add(findViewById(R.id.editTextPenetracao2));
        penetracoes.add(findViewById(R.id.editTextPenetracao3));

        editTextNivelAgua = findViewById(R.id.editTextNivelAgua);
        buttonFinalizarFuro = findViewById(R.id.buttonFinishFuro);
        imageButtonHome = findViewById(R.id.imageButtonHome);
        imageButtonHelpNivelAgua = findViewById(R.id.imageButtonHelpNivelAgua);

        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonIcrementGolpe1));
        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonIcrementGolpe2));
        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonIcrementGolpe3));

        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonDecrementGolpe1));
        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonDecrementGolpe2));
        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonDecrementGolpe3));

        return textAmostraN == null;
    }
}

