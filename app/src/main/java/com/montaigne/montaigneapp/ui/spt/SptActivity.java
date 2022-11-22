package com.montaigne.montaigneapp.ui.spt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;

import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.home.HomeVM;
import com.montaigne.montaigneapp.databinding.AcitivitySptBinding;

public class SptActivity extends AppCompatActivity {
    private AcitivitySptBinding binding;
    private SptVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AcitivitySptBinding .inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(SptVM.class);
        viewModel.setupViewModel(
                (ProjetoSpt) getIntent().getExtras().getSerializable(HomeVM.PROJETO),
                binding.buttonContinue,
                getSupportFragmentManager()
        );

        binding.imgButtonHome.setOnClickListener(viewModel::intentHome);
        binding.buttonContinue.setOnClickListener(v -> viewModel.handleNavigation((Button) v, getSupportFragmentManager()));
    }
}
