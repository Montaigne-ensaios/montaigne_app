package com.montaigne.montaigneapp.ui.spt.projeto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.databinding.FragmentProjetoBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptVM;

public class ProjetoFragment extends Fragment {
    private ProjetoVM viewModel;
    private SptVM projectViewModel;
    private FragmentProjetoBinding binding;

    public ProjetoFragment() {}

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

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        // todo: refresh adapter
    }

    @Override
    public void onPause() {
        super.onPause();
        projectViewModel.updateProjeto(viewModel.getProjetoSpt());
    }
}