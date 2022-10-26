package com.montaigne.montaigneapp.activity.spt.carimboEnsaio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class CarimboEnsaioFragment extends Fragment {
    private CarimboEnsaioVM carimboUnicoVM;

    public static CarimboEnsaioFragment newInstance() {
        Bundle args = new Bundle();

        CarimboEnsaioFragment fragment = new CarimboEnsaioFragment();
        fragment.setArguments(args);
        return fragment;
    }
//        imageButtonHome.setOnClickListener(viewModel::homeButtonListener);
//        buttonIniciarEnsaio.setOnClickListener(v -> viewModel.ensaioButtonListener (v, editTextDataInicio));


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        carimboUnicoVM = new ViewModelProvider(this).get(CarimboEnsaioVM.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}