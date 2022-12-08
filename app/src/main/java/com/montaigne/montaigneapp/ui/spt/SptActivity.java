package com.montaigne.montaigneapp.ui.spt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.home.HomeVM;
import com.montaigne.montaigneapp.databinding.AcitivitySptBinding;

public class SptActivity extends AppCompatActivity {
    private AcitivitySptBinding binding;
    private SptVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AcitivitySptBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(SptVM.class);
        setSupportActionBar(binding.toolbarSptInclude.toolbarSpt);
        getSupportActionBar().setTitle("Substituir nome do ensaio");//substituir por o tipo de ensaio exemplo: Granulometria ou SPT
        getSupportActionBar().setIcon(R.drawable.icon_arrow_left);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        viewModel.setupViewModel(
                (ProjetoSpt) getIntent().getExtras().getSerializable(HomeVM.PROJETO),
                getSupportFragmentManager()
        );

        binding.imgButtonHome.setOnClickListener(viewModel::intentHome);
        binding.buttonNavigate.setOnClickListener(v -> viewModel.handleNavigation(getSupportFragmentManager()));

//        addMenuProvider(new SptActivity.MenuProvider());  // não necessário no momento
    }

    public void setNavigateButtonText(String string) {
        binding.buttonNavigate.setText(string);
    }

    private static class MenuProvider implements androidx.core.view.MenuProvider {
        @Override
        public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.menu_spt, menu);
        }

        @Override
        public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
            return false;
        }
    }
}
