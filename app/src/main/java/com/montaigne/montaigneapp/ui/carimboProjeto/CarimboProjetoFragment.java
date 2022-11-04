package com.montaigne.montaigneapp.ui.carimboProjeto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.databinding.FragmentCarimboProjetoBinding;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptVM;

public class CarimboProjetoFragment extends Fragment {
    private CarimboProjetoVM viewModel;
    private SptVM projectViewModel;  // todo: criar uma classe abstrata de viewmodel agnóstica ao tipo de ensaio
    private FragmentCarimboProjetoBinding binding;

    public CarimboProjetoFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(CarimboProjetoVM.class);
        projectViewModel = new ViewModelProvider(requireActivity()).get(SptVM.class);
    }  // todo: criar um adapter que adapte todos os campos de um projeto para os dados de um editText

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentCarimboProjetoBinding.inflate(inflater, container, false);

        Projeto projeto = projectViewModel.getProjeto();
        viewModel.setProjeto(projeto);
        viewModel.initializeRecycler(binding.recyclerCarimboProjeto);

        return binding.getRoot();
    }

    @Override
    public void onPause() {
        super.onPause();
        projectViewModel.updateProjeto((ProjetoSpt) viewModel.getProjeto());
    }
}