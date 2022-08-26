package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;

public class CarimboDefinitivoActivity extends AbstractActivity {
    protected Button buttonContinuarCarimbo;
    protected ImageButton imageButtonHome;
    protected ImageButton imageButtonHelpLocalObra;
    protected ImageButton imageButtonCamera;
    protected ImageButton imageButtonHelpNomeProjeto;
    protected ImageButton imageButtonHelpTecnico;
    protected ImageButton imageButtonHelpEmpresa;
    protected ImageButton imageButtonHelpContato;
    protected ImageButton imageButtonHelpQuantidadeFuros;
    protected ImageButton imageButtonHelpReferenciaNivel;
    protected ImageButton imageButtonHelpCliente;
    protected ImageView imagePerfil;
    protected EditText editTextNomeProjeto;
    protected EditText editTextTecnico;
    protected EditText editTextEmpresa;
    protected EditText editTextContato;
    protected EditText editTextCliente;
    protected EditText editTextLocalObra;
    protected EditText editTextQuantidadeFuros;
    protected EditText editTextReferenciaNivel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CarimboDefinitivoVM viewModel = new CarimboDefinitivoVM(this);
        setContentView(R.layout.activity_carimbo_definitivo);

        initializeViews();
    }

    protected void initializeViews() {
        buttonContinuarCarimbo = findViewById(R.id.buttonContinuarCarimbo);
        imageButtonHome = findViewById(R.id.imageButtonHome);
        imageButtonHelpLocalObra = findViewById(R.id.imageButtonHelpLocalObra);
        imageButtonCamera = findViewById(R.id.imageButtonCamera);
        imageButtonHelpNomeProjeto = findViewById(R.id.imageButtonHelpNomeProjeto);
        imageButtonHelpTecnico = findViewById(R.id.imageButtonHelpTecnico);
        imageButtonHelpEmpresa = findViewById(R.id. imageButtonHelpEmpresa);
        imageButtonHelpContato = findViewById(R.id.imageButtonHelpContato);
        imageButtonHelpQuantidadeFuros = findViewById(R.id.imageButtonHelpQuantidadeFuros);
        imageButtonHelpReferenciaNivel = findViewById(R.id.imageButtonHelpReferenciaNivel);
        imageButtonHelpCliente = findViewById(R.id.imageButtonHelpCliente);
        imagePerfil = findViewById(R.id.imagePerfil);
        editTextNomeProjeto = findViewById(R.id.editTextNomeProjeto);
        editTextTecnico = findViewById(R.id.editTextTecnico);
        editTextEmpresa = findViewById(R.id.editTextEmpresa);
        editTextContato = findViewById(R.id.editTextContato);
        editTextCliente = findViewById(R.id.editTextCliente);
        editTextLocalObra = findViewById(R.id.editTextLocalObra);
        editTextQuantidadeFuros = findViewById(R.id.editTextQuantidadeFuros);
        editTextReferenciaNivel = findViewById(R.id.editTextReferenciaNivel);

    }
}