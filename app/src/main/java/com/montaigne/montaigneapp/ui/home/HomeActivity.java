package com.montaigne.montaigneapp.ui.home;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private HomeVM viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(HomeVM.class);
        setSupportActionBar(binding.toolbarHome.toolbarHome);  // todo: criar toolbar para home
        viewModel.initializeProjetosSalvosAdapter(binding.recyclerProjetosSalvos);
        viewModel.initializeProjetoCategoriaAdapter(binding.recyclerCategorias);
        binding.fabNewProjeto.setOnClickListener(viewModel::newProjectFabListener);
    }

    @Override
    protected void onPostResume() {
        // todo: revisar se o refresh deve ser aqui
        super.onPostResume();
        viewModel.refreshProjetosSalvos();
    }
}