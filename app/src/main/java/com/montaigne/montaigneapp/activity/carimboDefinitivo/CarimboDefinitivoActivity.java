package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class CarimboDefinitivoActivity extends AbstractActivity {
    protected Button buttonContinuarCarimbo;
    protected ImageButton imageButtonHome, imageButtonCamera;
    protected ImageView imagePerfil;
    private EditText editTextNomeProjeto, editTextCliente, editTextContato, editTextTecnico,
            editTextEmpresa, editTextLocalObra, editTextQuantidadeFuros, editTextReferenciaNivel;

    private CarimboDefinitivoVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();

        this.viewModel = new ViewModelProvider(this).get(CarimboDefinitivoVM.class);

        buttonContinuarCarimbo.setOnClickListener(view -> continuarCarimboButtonListener(view));
        imageButtonHome.setOnClickListener(viewModel::homeButtonListener);
    }

    protected boolean initializeViews() {
        setContentView(R.layout.activity_carimbo_definitivo);

        buttonContinuarCarimbo = findViewById(R.id.buttonContinueCarimbo);
        imageButtonHome = findViewById(R.id.imageButtonHome);
        imageButtonCamera = findViewById(R.id.imageButtonPhoto);
        imagePerfil = findViewById(R.id.imageProfile);

        editTextNomeProjeto = findViewById(R.id.editTextNameProjeto);
        editTextCliente = findViewById(R.id.editTextCliente);
        editTextContato = findViewById(R.id.editTextContato);
        editTextTecnico = findViewById(R.id.editTextTecnico);
        editTextEmpresa = findViewById(R.id.editTextEmpresa);
        editTextLocalObra = findViewById(R.id.editTextLocalObra);
        editTextQuantidadeFuros = findViewById(R.id.editTextQuantidadeFuros);
        editTextReferenciaNivel = findViewById(R.id.editTextReferenciaNivel);

        return imageButtonCamera == null;
    }

    public void continuarCarimboButtonListener(View view) {
        String nome = editTextNomeProjeto.getText().toString();
        String empresa = editTextEmpresa.getText().toString();
        String tecnico = editTextTecnico.getText().toString();
        String cotato = editTextContato.getText().toString();
        String cliente = editTextCliente.getText().toString();
        String local = editTextLocalObra.getText().toString();
        String referenciaNivel = editTextReferenciaNivel.getText().toString();
        //String nFuros = fields.get("nFuros").getText().toString();

        ProjetoSpt projetoSpt = new ProjetoSpt();
        projetoSpt.setNome(nome);
        projetoSpt.setEmpresa(empresa);
        projetoSpt.setCliente(cliente);
        projetoSpt.setTecnico(tecnico);
        projetoSpt.setNumeroDeTelefone(cotato);
        projetoSpt.setEmpresa(empresa);

        viewModel.continuarCarimbo(view, projetoSpt);
    }
}