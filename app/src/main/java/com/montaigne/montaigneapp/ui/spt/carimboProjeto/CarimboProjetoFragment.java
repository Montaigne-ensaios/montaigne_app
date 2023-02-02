package com.montaigne.montaigneapp.ui.spt.carimboProjeto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.FragmentCarimboProjetoBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;

public class CarimboProjetoFragment extends Fragment {
    private CarimboProjetoVM viewModel;
    private SptVM projectViewModel;
    private FragmentCarimboProjetoBinding binding;

    public CarimboProjetoFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(CarimboProjetoVM.class);
        projectViewModel = new ViewModelProvider(requireActivity()).get(SptVM.class);
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentCarimboProjetoBinding.inflate(inflater, container, false);

        ProjetoSpt projetoSpt = projectViewModel.getProjeto();
        viewModel.setProjeto(projetoSpt);
        viewModel.initializeRecycler(binding.recyclerCarimboProjeto);

        SptActivity activity = (SptActivity) getActivity();
        activity.setButtonNavigateText(getString(R.string.btn_navigate_carimbo_projeto));
        activity.setActionBarTitle(projetoSpt.getNome());

        binding.buttonGetLocation.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), R.string.not_implemented, Toast.LENGTH_SHORT).show();
//            viewModel.setLocation();  // todo: implementar coordenadas
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        projectViewModel.updateProjeto((ProjetoSpt) viewModel.getProjeto());
    }
}