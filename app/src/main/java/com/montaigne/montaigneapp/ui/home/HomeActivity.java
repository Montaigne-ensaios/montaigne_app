package com.montaigne.montaigneapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;
import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.ActivityHomeBinding;
import com.montaigne.montaigneapp.ui.auth.AuthActivity;
import com.montaigne.montaigneapp.ui.IClickListener;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private HomeVM viewModel;
    private ActionMode actionMode;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(HomeVM.class);
        setSupportActionBar(binding.toolbarHomeInclude.toolbarHome);

        checkAuthentication();

        setSupportActionBar(binding.toolbarHomeInclude.toolbarHome);
        viewModel.initializeProjetosSalvosAdapter(binding.recyclerProjetosSalvos);
        viewModel.initializeProjetoCategoriaAdapter(binding.recyclerCategorias);
        viewModel.setClickListener(new IClickListener() {
            @Override
            public void onItemClick(int position) {
                enableActionMode(position);
            }

            @Override
            public void onItemLongClick(int position) {
                enableActionMode(position);
            }
        });
//        addMenuProvider(new HomeActivity.MenuProvider());
    }

        binding.toolbarHomeInclude.toolbarHome.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.add) {
                viewModel.newProject(this);
            } else if (item.getItemId() == R.id.delete) {
                viewModel.removeProjects();
            }

            return true;
        });

        binding.toolbarHomeInclude.toolbarItemLogout.setOnClickListener(this::menuItemLogout);
    private void enableActionMode(int position) {
        if (actionMode == null)
            actionMode = startSupportActionMode(new androidx.appcompat.view.ActionMode.Callback() {
                @Override
                public boolean onCreateActionMode(androidx.appcompat.view.ActionMode mode, Menu menu) {
                    mode.getMenuInflater().inflate(R.menu.delete_menu, menu);
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(androidx.appcompat.view.ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(androidx.appcompat.view.ActionMode mode, MenuItem item) {
                    if (item.getItemId() == R.id.action_delete) {
                        viewModel.removeProjects();
                        actionMode.finish();
                        viewModel.getIsCheckedList().clear();
                    }
                    return false;
                }

                @Override
                public void onDestroyActionMode(androidx.appcompat.view.ActionMode mode) {
                    viewModel.getIsCheckedList().clear();
                    actionMode = null;
                    viewModel.getAdapterProjetosSalvos().notifyDataSetChanged();
                }
            });

        viewModel.togglePositions(position);
        final int size = viewModel.getIsCheckedList().size();
        if (size == 0) {
            actionMode.finish();
        } else {
            actionMode.setTitle(size + "");
            actionMode.invalidate();
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        viewModel.refreshProjetosSalvos();
    }

    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(new OnMenuItemClickListener());
        popup.inflate(R.menu.home_menu_popup);
        popup.show();
    }

    private class OnMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.addProjetoSpt) {
                viewModel.newProjectSpt(HomeActivity.this);
            } else if (item.getItemId() == R.id.addProjetoGranulometria) {
                Toast.makeText(HomeActivity.this, R.string.not_implemented, Toast.LENGTH_SHORT).show();
                // todo: granulometria
            }
            return true;
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