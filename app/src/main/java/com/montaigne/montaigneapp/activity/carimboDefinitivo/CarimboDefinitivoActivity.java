package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;

import java.util.HashMap;

public class CarimboDefinitivoActivity extends AbstractActivity {
    protected final HashMap<String, EditText> fields = new HashMap<>();
    protected final HashMap<EditText, ImageButton> buttonsHelp = new HashMap<>();

    protected Button buttonContinuarCarimbo;
    protected ImageButton imageButtonHome, imageButtonCamera;
    protected ImageView imagePerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carimbo_definitivo);

        initializeViews();
        CarimboDefinitivoVM viewModel = new CarimboDefinitivoVM(this);
    }

    protected boolean initializeViews() {
        buttonContinuarCarimbo = findViewById(R.id.buttonContinueCarimbo);
        imageButtonHome = findViewById(R.id.imageButtonHome);
        imageButtonCamera = findViewById(R.id.imageButtonPhoto);
        imagePerfil = findViewById(R.id.imageProfile);

        fields.put ("Tecnico", (EditText) findViewById(R.id.editTextTecnico));
        fields.put ("Empresa", (EditText) findViewById(R.id.editTextEmpresa));
        fields.put ("Contato", (EditText) findViewById(R.id.editTextContato));
        fields.put ("Cliente", (EditText) findViewById(R.id.editTextCliente));
        fields.put ("LocalObra", (EditText) findViewById(R.id.editTextLocalObra));
        fields.put ("QuantidadeFuros", (EditText) findViewById(R.id.editTextQuantidadeFuros));
        fields.put ("ReferenciaNivel", (EditText) findViewById(R.id.editTextReferenciaNivel));
        fields.put ("NomeProjeto", (EditText) findViewById(R.id.editTextNameProjeto));

        buttonsHelp.put(fields.get ("Tecnico"),
                (ImageButton) findViewById(R.id.imageButtonHelpLocalObra));
        buttonsHelp.put(fields.get ("Empresa"),
                (ImageButton)findViewById(R.id.imageButtonHelpNameProjeto));
        buttonsHelp.put(fields.get ("Contato"),
                (ImageButton)findViewById(R.id.imageButtonHelpTecnico));
        buttonsHelp.put(fields.get ("Cliente"),
                (ImageButton)findViewById(R.id. imageButtonHelpEmpresa));
        buttonsHelp.put(fields.get ("LocalObra"),
                (ImageButton) findViewById(R.id.imageButtonHelpContato));
        buttonsHelp.put(fields.get ("QuantidadeFuros"),
                (ImageButton) findViewById(R.id.imageButtonHelpQuantidadeFuros));
        buttonsHelp.put(fields.get ("ReferenciaNivel"),
                (ImageButton)findViewById(R.id.imageButtonHelpReferenciaNivel));
        buttonsHelp.put(fields.get ("NomeProjeto"),
                (ImageButton) findViewById(R.id.imageButtonHelpCliente));

        return imageButtonCamera == null;
    }
}