package com.montaigne.montaigneapp.ui.spt.carimboProjeto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.FragmentCarimboProjetoBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;
import com.montaigne.montaigneapp.utils.DatePickerUtil;
import com.montaigne.montaigneapp.utils.PreparaDataUtil;
import com.montaigne.montaigneapp.utils.Geolocation;

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

        binding.buttonGetLocation.setOnClickListener(v -> viewModel.setLocal(
                requireActivity(), Geolocation.getLatlog(v)
        ));

        binding.calendarioDataInicio.setOnClickListener(v -> {
            DatePickerUtil datePicker = new DatePickerUtil(
                    this.getActivity(),
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        binding.editTextDataInicioProjeto.setText(
                                PreparaDataUtil.preparaData(selectedYear, selectedMonth, selectedDay
                                )
                        );
                    }
            );
            datePicker.create();
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