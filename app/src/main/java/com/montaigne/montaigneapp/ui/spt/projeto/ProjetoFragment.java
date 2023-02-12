package com.montaigne.montaigneapp.ui.spt.projeto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.FragmentProjetoBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.utils.FragmentNavigator;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;

public class ProjetoFragment extends Fragment {
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
        viewModel.setProjeto(projeto);
        viewModel.updateFurosAdapter(binding.recyclerFuro);

        SptActivity activity = (SptActivity) requireActivity();
        activity.setButtonNavigateText(getString(R.string.btn_navigate_projeto));
        activity.setActionBarTitle(projeto.getNome());

        return binding.getRoot();
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
            if (menuItem.getItemId() == R.id.action_add_furo) {
                FragmentNavigator.navigate(R.id.action_new_furo,
                        requireActivity().getSupportFragmentManager(),
                        R.id.containerSpt);
            } else if (menuItem.getItemId() == R.id.action_genarate_report) {
                Toast.makeText(requireContext(), R.string.not_implemented, Toast.LENGTH_SHORT).show();
                // todo: implementar geração de ensaios xlsx
            }

            return true;
        }
    }
}