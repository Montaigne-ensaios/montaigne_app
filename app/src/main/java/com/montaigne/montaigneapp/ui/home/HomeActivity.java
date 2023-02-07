package com.montaigne.montaigneapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;
import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.ActivityHomeBinding;
import com.montaigne.montaigneapp.ui.auth.AuthActivity;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private HomeVM viewModel;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(HomeVM.class);

        checkAuthentication();

        setSupportActionBar(binding.toolbarHomeInclude.toolbarHome);
        viewModel.initializeProjetosSalvosAdapter(binding.recyclerProjetosSalvos);
        viewModel.initializeProjetoCategoriaAdapter(binding.recyclerCategorias);

        binding.toolbarHomeInclude.toolbarHome.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.add) {
                viewModel.newProject(this);
            } else if (item.getItemId() == R.id.delete) {
                viewModel.removeProjects();
            }

            return true;
        });

        binding.toolbarHomeInclude.toolbarItemLogout.setOnClickListener(this::menuItemLogout);
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

    private void checkAuthentication() {
        if (mAuth.getCurrentUser() == null) {
            Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void menuItemLogout(View view) {
        FirebaseAuth.getInstance().signOut();
        checkAuthentication();
    }
}