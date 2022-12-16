package com.montaigne.montaigneapp.ui.spt.projeto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.FragmentProjetoBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;

public class ProjetoFragment extends Fragment {
    public static final String SELECTEDKEY = "projetoFragmentResult";
    public static final String IDKEY = "furoId";

    private ProjetoVM viewModel;
    private SptVM projectViewModel;
    private FragmentProjetoBinding binding;

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
        binding = FragmentProjetoBinding.inflate(inflater, container, false);

        ProjetoSpt projeto = projectViewModel.getProjeto();
        viewModel.setProjetoSpt(projeto);
        viewModel.updateFurosAdapter(binding.recyclerFuro);

        ((SptActivity) getActivity())
                .setNavigateButtonText(getString(R.string.btn_navigate_projeto));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireActivity().addMenuProvider(new ProjetoFragment.MenuProvider(),
                getViewLifecycleOwner(), Lifecycle.State.RESUMED);  // menu visível apenas quando
    }

    @Override
    public void onResume() {
        super.onResume();
        // todo: refresh adapter
    }

    private class MenuProvider implements androidx.core.view.MenuProvider {
        @Override
        public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.menu_spt, menu);
        }

        @Override
        public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
            if (menuItem.getItemId() == R.id.addfuro) {
                SptVM.navigateFragments(R.id.action_new_Furo,
                        requireActivity().getSupportFragmentManager());
            } else if (menuItem.getItemId() == R.id.deletefuro) {
                // TODO: handle delete
            }

            return true;
        }
    }
}