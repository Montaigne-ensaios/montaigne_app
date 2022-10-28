package com.montaigne.montaigneapp.activity.spt.carimboEnsaio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.databinding.FragmentCarimboEnsaioBinding;

public class CarimboEnsaioFragment extends Fragment {
    private CarimboEnsaioVM viewModel;
    private FragmentCarimboEnsaioBinding binding;

    public CarimboEnsaioFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(CarimboEnsaioVM.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentCarimboEnsaioBinding.inflate(inflater, container, false);

        binding.imageButtonHome.setOnClickListener(viewModel::homeButtonListener);
        binding.buttonStartEnsaio.setOnClickListener(v -> viewModel.ensaioButtonListener (v,
                binding.editTextStartDate));

        return binding.getRoot();
    }
}