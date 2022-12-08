package com.montaigne.montaigneapp.ui.home;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
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

        addMenuProvider(new HomeActivity.MenuProvider());
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        viewModel.refreshProjetosSalvos();
    }

    private class MenuProvider implements androidx.core.view.MenuProvider {
        @Override
        public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.menu_main, menu);
        }

        @Override
        public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
            if (menuItem.getItemId() == R.id.add) {
                viewModel.newProject(HomeActivity.this);
            } else if (menuItem.getItemId() == R.id.delete) {
                viewModel.removeProjects();
            }
            return true;
        }
    }
}