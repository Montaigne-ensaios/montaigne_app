package com.montaigne.montaigneapp.activity.spt.carimboUnico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class CarimboUnicoFragment extends Fragment {
    private CarimboUnicoVM carimboUnicoVM;

    public static CarimboUnicoFragment newInstance() {
        Bundle args = new Bundle();

        CarimboUnicoFragment fragment = new CarimboUnicoFragment();
        fragment.setArguments(args);
        return fragment;
    }
//        imageButtonHome.setOnClickListener(viewModel::homeButtonListener);
//        buttonIniciarEnsaio.setOnClickListener(v -> viewModel.ensaioButtonListener (v, editTextDataInicio));


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        carimboUnicoVM = new ViewModelProvider(this).get(CarimboUnicoVM.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}