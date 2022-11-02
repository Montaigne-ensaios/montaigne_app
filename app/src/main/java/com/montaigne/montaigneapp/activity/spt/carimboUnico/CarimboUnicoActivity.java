package com.montaigne.montaigneapp.activity.spt.carimboUnico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;
import java.util.List;

public class CarimboUnicoActivity extends AbstractActivity {
    private ProjetoSpt projetoSpt;
    private CarimboUnicoVM viewModel;

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

        Intent intent = getIntent();
        projetoSpt = (ProjetoSpt) intent.getExtras().get("ProjetoSpt");

        viewModel = new ViewModelProvider(this).get(CarimboUnicoVM.class);

        viewModel.setExtras(getIntent().getExtras());
        imageButtonHome.setOnClickListener(viewModel::homeButtonListener);
        buttonIniciarEnsaio.setOnClickListener(view -> ensaioButtonListener(view));
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

    public void ensaioButtonListener(View view) {
        FuroSpt furoSpt = new FuroSpt();

        List<AmostraSpt> amostras = new ArrayList<>();

        // TODO: revisar a criação de uma nova amostra, a primeira talvez só possa ser criada quando ela for salva
        // A manipulação dos ids vai ficar por conta do List, não precisa mais disso
        amostras.add(new AmostraSpt());
        amostras.get(0).setId("0");

        furoSpt.setListaDeAmostras(amostras);

        List<FuroSpt> furos = new ArrayList();
        furos.add(furoSpt);

        projetoSpt.setListaDeFuros(furos);
        updateProjeto();

        viewModel.ensaioButtonListener(view, projetoSpt);
    }

    private void updateProjeto() {
        projetoSpt.setDataInicio(editTextDataInicio.getText().toString());

        ProjetoSptUseCase.save(projetoSpt).addOnCompleteListener(dataTask -> {
            if (dataTask.isSuccessful()) {
                Toast.makeText(editTextDataInicio.getContext(),
                        "Sucesso ao criar projeto",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(editTextDataInicio.getContext(),
                        "Falha ao criar projeto",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}