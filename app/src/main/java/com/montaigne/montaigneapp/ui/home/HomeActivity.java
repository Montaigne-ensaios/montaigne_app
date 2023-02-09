package com.montaigne.montaigneapp.ui.home;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
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

        binding.toolbarHomeInclude.toolbarHome.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.addProjetoSpt) {
                viewModel.newProjectSpt(this);
            } else if (item.getItemId() == R.id.addProjetoGranulometria) {
                // todo: granulometria
            } else if (item.getItemId() == R.id.action_help) {
                // todo: help
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
    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this,view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.addProjetoSpt) {
                viewModel.newProjectSpt(this);
            } else if (item.getItemId() == R.id.addProjetoGranulometria) {
                // todo: granulometria
            } else if (item.getItemId() == R.id.action_help) {
                // todo: help
            }
            return true;
        };
    }