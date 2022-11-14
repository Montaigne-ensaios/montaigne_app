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
import com.montaigne.montaigneapp.databinding.ActivityCarimboDefinitivoBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class CarimboDefinitivoActivity extends AbstractActivity {
    protected Button buttonContinuarCarimbo;
    protected ImageButton imageButtonHome, imageButtonCamera;
    protected ImageView imagePerfil;
    private EditText editTextNomeProjeto, editTextCliente, editTextContato, editTextTecnico,
            editTextEmpresa, editTextLocalObra, editTextReferenciaNivel;

    private ActivityCarimboDefinitivoBinding binding;

    private CarimboDefinitivoVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCarimboDefinitivoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        editTextNomeProjeto = binding.editTextNameProjeto;

        buttonContinuarCarimbo = binding.buttonContinueCarimbo;
        imageButtonHome = binding.imageButtonHome;
        imageButtonCamera = binding.imageButtonPhoto;
        imagePerfil = binding.imageProfile;

        editTextCliente = binding.editTextCliente;
        editTextContato = binding.editTextContato;
        editTextTecnico = binding.editTextTecnico;
        editTextEmpresa = binding.editTextEmpresa;
        editTextLocalObra = binding.editTextLocalObra;
        editTextReferenciaNivel = binding.editTextReferenciaNivel;

        viewModel = new ViewModelProvider(this).get(CarimboDefinitivoVM.class);

        buttonContinuarCarimbo.setOnClickListener(viewOnClick -> continuarCarimboButtonListener(viewOnClick));
        imageButtonHome.setOnClickListener(viewModel::homeButtonListener);

    }

    protected boolean initializeViews() {
        setContentView(R.layout.activity_carimbo_definitivo);

        // TODO: inicializar as views da interface aqui

        return false;
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
        projetoSpt.setContato(cotato);
        projetoSpt.setEmpresa(empresa);
        projetoSpt.setCliente(cliente);
        projetoSpt.setTecnico(tecnico);
        projetoSpt.setEmpresa(empresa);
        projetoSpt.setReferenciaNivel(referenciaNivel);

        viewModel.continuarCarimbo(view, projetoSpt);
    }
}