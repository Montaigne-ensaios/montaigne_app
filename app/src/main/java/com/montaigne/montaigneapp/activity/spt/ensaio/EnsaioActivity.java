package com.montaigne.montaigneapp.activity.spt.ensaio;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;
import com.montaigne.montaigneapp.databinding.ActivityEnsaioBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class EnsaioActivity extends AbstractActivity {
    /*
    protected EditText editTextProfundidade, editTextNivelAgua;

    // lista de golpes e penetrações por segmento
    protected ArrayList<EditText> golpes = new ArrayList<>(), penetracoes = new ArrayList<>();
    protected List<View> buttonsIncrementGolpes = new ArrayList<>();
    protected List<View> buttonsDecrementGolpes = new ArrayList<>();

    protected Button buttonFinalizarFuro;
    protected ImageButton imageButtonHelpNivelAgua, imageButtonHome;
    protected TextView textAmostraN;
     */

    ActivityEnsaioBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ensaio);

        initializeViews();
        EnsaioVM viewModel = new ViewModelProvider(this).get(EnsaioVM.class);
        // viewModel.setExtras(getIntent().getExtras());
        int idFuro = (int) getIntent().getExtras().get("idFuro");
        int idAmostra = (int) getIntent().getExtras().get("idAmostra");
        ProjetoSpt projetoSpt = (ProjetoSpt) getIntent().getExtras().get("projetoSpt");

        viewModel.setIdFuro(idFuro);
        viewModel.setIdAmostra(idAmostra);
        viewModel.setProjeto(projetoSpt);

        binding.textAmostraN.setText("Amostra " + (idAmostra + 1));

        // TODO: rever métodos de atualização de uma amostra
        // binding.buttonFinalizarFuro.setOnClickListener(v -> viewModel.finalizarFuroButtonListener (v, golpes, penetracoes));

        binding.imageButtonHome.setOnClickListener(viewModel::homeButtonListener);

        binding.imageButtonDiminuirGolpe1
                .setOnClickListener(v -> viewModel.decrementGolpe(binding.editTextGolpe1));

        binding.imageButtonDiminuirGolpe2
                .setOnClickListener(v -> viewModel.decrementGolpe(binding.editTextGolpe2));

        binding.imageButtonDiminuirGolpe3
                .setOnClickListener(v -> viewModel.decrementGolpe(binding.editTextGolpe3));

        binding.imageButtonAumentarGolpe1
                .setOnClickListener(v -> viewModel.incrementGolpe(binding.editTextGolpe1));

        binding.imageButtonAumentarGolpe2
                .setOnClickListener(v -> viewModel.incrementGolpe(binding.editTextGolpe2));

        binding.imageButtonAumentarGolpe3
                .setOnClickListener(v -> viewModel.incrementGolpe(binding.editTextGolpe3));

        /*
        for (int i = 0; i < 3; i++) {
            Log.i("inc", String.valueOf(i));

            EditText editText = findViewById(R.id.editTextGolpe1);
            editText.setText("0");
            /*
            ImageButton ib = findViewById(R.id.imageButtonAumentarGolpe1);

            ib.setOnClickListener(v -> {
                int value = Integer.parseInt(editText.getText().toString());
                editText.setText(value + 1);
            });


            buttonsIncrementGolpes.get(i).setOnClickListener(v -> viewModel.incrementGolpe(editText));
            buttonsDecrementGolpes.get(i).setOnClickListener(v -> viewModel.decrementGolpe(editText));
        }

         */
    }

    @Override
    protected void initializeViews() {
        binding = ActivityEnsaioBinding.inflate(getLayoutInflater());

        /*
        textAmostraN = findViewById(R.id.textAmostraN);
        editTextProfundidade = findViewById(R.id.editTextProfundidade);

        golpes.add(findViewById(R.id.editTextGolpe1));
        golpes.add(findViewById(R.id.editTextGolpe2));
        golpes.add(findViewById(R.id.editTextGolpe3));

        penetracoes.add(findViewById(R.id.editTextPenetracao1));
        penetracoes.add(findViewById(R.id.editTextPenetracao2));
        penetracoes.add(findViewById(R.id.editTextPenetracao3));

        editTextNivelAgua = findViewById(R.id.editTextNivelAgua);
        buttonFinalizarFuro = findViewById(R.id.buttonFinalizarFuro);
        imageButtonHome = findViewById(R.id.imageButtonHome);
        imageButtonHelpNivelAgua = findViewById(R.id.imageButtonHelpNivelAgua);

        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonDiminuirGolpe1));
        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonDiminuirGolpe2));
        buttonsDecrementGolpes.add(findViewById(R.id.imageButtonDiminuirGolpe3));
        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonAumentarGolpe1));
        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonAumentarGolpe2));
        buttonsIncrementGolpes.add(findViewById(R.id.imageButtonAumentarGolpe3));

        buttonsIncrementGolpes.get(0).setOnClickListener(c -> Log.i("incp", "Passou"));
         */
    }
}

