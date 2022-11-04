package com.montaigne.montaigneapp.ui.home;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

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

        setSupportActionBar(binding.toolbarHomeInclude.toolbarHome);

        viewModel.initializeProjetosSalvosAdapter(binding.recyclerProjetosSalvos);
        viewModel.initializeProjetoCategoriaAdapter(binding.recyclerCategorias);
        binding.fabNewProjeto.setOnClickListener(v -> viewModel.newProject(this));
        binding.toolbarHomeInclude.toolbarHome.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.add) {
                viewModel.newProject(this);
            } else if (item.getItemId() == R.id.delete) {
                viewModel.removeProjects();
            }
            return true;
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        viewModel.refreshProjetosSalvos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}