package com.montaigne.montaigneapp.ui.spt;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.montaigne.montaigneapp.R;
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

//        addMenuProvider(new SptActivity.MenuProvider());  // não necessário no momento
    }

    private class MenuProvider implements androidx.core.view.MenuProvider {
        @Override
        public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.menu_spt_projeto, menu);
        }

        @Override
        public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
            if (menuItem.getItemId() == android.R.id.home)
                onBackPressed();
            return true;
        }
    }
}
