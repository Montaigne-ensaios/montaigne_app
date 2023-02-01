package com.montaigne.montaigneapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.ActivityHomeBinding;
import com.montaigne.montaigneapp.ui.IClickListener;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private HomeVM viewModel;
    private ActionMode actionMode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(HomeVM.class);
      setSupportActionBar(binding.toolbarHomeInclude.toolbarHome);
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
    }

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
                    if (item.getItemId() == R.id.action_delete)
                        viewModel.removeProjects();
                    return false;
                }

                @Override
                public void onDestroyActionMode(androidx.appcompat.view.ActionMode mode) {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}