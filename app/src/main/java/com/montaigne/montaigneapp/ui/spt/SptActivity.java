package com.montaigne.montaigneapp.ui.spt;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.AbstractProjectActivity;
import com.montaigne.montaigneapp.databinding.ActivitySptBinding;

public class SptActivity extends AbstractProjectActivity<SptVM, ProjetoSpt> {
    private ActivitySptBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySptBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setViewModel(new ViewModelProvider(this).get(SptVM.class));

        setSupportActionBar(binding.toolbarSptInclude.toolbarSpt);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setButtonHome(binding.imgButtonHome);
        setButtonNavigate(binding.buttonNavigate);

        getSupportActionBar().setTitle(super.viewModel.getProjeto().getNome());
    }
}
