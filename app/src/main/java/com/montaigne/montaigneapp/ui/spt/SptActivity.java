package com.montaigne.montaigneapp.ui.spt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.ui.carimboProjeto.CarimboProjetoFragment;
import com.montaigne.montaigneapp.ui.spt.carimboEnsaio.CarimboEnsaioFragment;
import com.montaigne.montaigneapp.databinding.ActivitySptBinding;

public class SptActivity extends AppCompatActivity {
    private ActivitySptBinding binding;
    private SptVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySptBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(SptVM.class);
        binding.imgButtonHome.setOnClickListener(viewModel::intentHome);
        binding.buttonContinue.setOnClickListener(v ->
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.containerSpt, new CarimboEnsaioFragment())
                                .commitNow()
//                viewModel::navigateFragments
        );

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerSpt, new CarimboProjetoFragment())
                .commitNow();
    }
}
