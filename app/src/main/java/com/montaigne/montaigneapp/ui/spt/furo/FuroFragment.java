package com.montaigne.montaigneapp.ui.spt.furo;

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
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.FragmentSptFuroBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.IClickListener;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;
import com.montaigne.montaigneapp.ui.spt.projeto.ProjetoFragment;
import com.montaigne.montaigneapp.utils.FragmentNavigator;

import java.util.Locale;

public class FuroFragment extends Fragment {
    private FuroVM viewModel;
    private SptVM projectViewModel;
    private FragmentSptFuroBinding binding;
    private ActionMode actionMode;
    private static String TAG = "FuroFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(FuroVM.class);
        projectViewModel = new ViewModelProvider(requireActivity()).get(SptVM.class);
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentSptFuroBinding.inflate(inflater, container, false);

        Bundle b = requireArguments();

        int furoId = b.getInt("furoId");

        ProjetoSpt projeto = projectViewModel.getProjeto();
        viewModel.setFuro(projeto, furoId);

        binding.textAmostra.setText(String.format(
                Locale.getDefault(),
                "%d%s",
                R.string.fragment_spt_furo_title,
                projeto.getListaDeFuros().get(furoId).getCodigo())
        );

        viewModel.updateAmostrasAdapter(binding.recyclerAmostra);
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
        activity.setButtonNavigateText(getString(R.string.btn_navigate_furo));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireActivity().addMenuProvider(new FuroFragment.MenuProvider(),
                getViewLifecycleOwner(), Lifecycle.State.RESUMED);
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
                        viewModel.removeAmostras();
                        actionMode.finish();
                        viewModel.getSelectedItems().clear();
                    }
                    return false;
                }

                @Override
                public void onDestroyActionMode(android.view.ActionMode mode) {
                    viewModel.getSelectedItems().clear();
                    actionMode = null;
                    viewModel.getAmostraAdapter().notifyDataSetChanged();
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
    public void onPause() {
        super.onPause();
        projectViewModel.updateProjeto(viewModel.getProjeto());
    }

    public class MenuProvider implements androidx.core.view.MenuProvider {
        @Override
        public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.menu_spt_furo, menu);
        }

        @Override
        public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
            if (menuItem.getItemId() == R.id.action_edit_carimboEnsaio) {
                Bundle b = new Bundle();
                b.putInt("furoId", viewModel.getFuroId());
                FragmentNavigator.navigate(R.id.action_edit_CarimboEnsaio,
                        requireActivity().getSupportFragmentManager(),
                        R.id.containerSpt, b);
                Log.v(TAG, "action_edit_CarimboEnsaio");
            }
            return false;
        }
    }
}