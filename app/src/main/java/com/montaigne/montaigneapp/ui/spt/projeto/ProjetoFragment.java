package com.montaigne.montaigneapp.ui.spt.projeto;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.FragmentSptProjetoBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.IClickListener;
import com.montaigne.montaigneapp.utils.FragmentNavigator;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;

public class ProjetoFragment extends Fragment {
    private static String TAG = "ProjetoFragment";

    private ProjetoVM viewModel;
    private SptVM projectViewModel;
    private FragmentSptProjetoBinding binding;
    private ActionMode actionMode;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ProjetoVM.class);
        projectViewModel = new ViewModelProvider(requireActivity()).get(SptVM.class);
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentSptProjetoBinding.inflate(inflater, container, false);

        ProjetoSpt projeto = projectViewModel.getProjeto();
        viewModel.setProjeto(projeto);
        viewModel.updateFurosAdapter(binding.recyclerFuro);

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
        SptActivity activity = (SptActivity) requireActivity();
        activity.setButtonNavigateText(getString(R.string.btn_navigate_projeto));

        return binding.getRoot();
    }

    private void enableActionMode(int position) {
        if (actionMode == null)
            actionMode = requireActivity().startActionMode(new ActionMode.Callback() {
                @Override
                public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
                    mode.getMenuInflater().inflate(R.menu.delete_menu, menu);
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
                    if (item.getItemId() == R.id.action_delete) {
                        viewModel.removeFuros();
                        actionMode.finish();
                        viewModel.getSelectedItems().clear();
                    }
                    return false;
                }

                @Override
                public void onDestroyActionMode(android.view.ActionMode mode) {
                    viewModel.getSelectedItems().clear();
                    actionMode = null;
                    viewModel.getFurosAdapter().notifyDataSetChanged();
                }


            });

        viewModel.togglePositions(position);
        final int size = viewModel.getSelectedItems().size();
        if (size == 0) {
            actionMode.finish();
        } else {
            actionMode.setTitle(size + "");
            actionMode.invalidate();
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireActivity().addMenuProvider(new ProjetoFragment.MenuProvider(),
                getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        // menu visível apenas quando a view for criada
    }

    @Override
    public void onResume() {
        super.onResume();
        // todo: refresh adapter
    }

    private class MenuProvider implements androidx.core.view.MenuProvider {
        @Override
        public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.menu_spt_projeto, menu);
        }

        @Override
        public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
            if (menuItem.getItemId() == R.id.action_edit_carimbo) {
                FragmentNavigator.navigate(R.id.action_edit_Carimbo,
                        requireActivity().getSupportFragmentManager(),
                        R.id.containerSpt);
                Log.v(TAG, "action_edit_Carimbo");
            }
            return true;
        }
    }
}