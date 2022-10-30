package com.montaigne.montaigneapp.ui.spt.carimboEnsaio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.databinding.FragmentCarimboEnsaioBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.HashMap;
import java.util.Map;

public class CarimboEnsaioFragment extends Fragment {
    private CarimboEnsaioVM viewModel;
    private FragmentCarimboEnsaioBinding binding;
    private Map<String, EditText> fields;

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

        fields = new HashMap<>();
        fields.put("DataInicio", binding.editTextStartDate);
        fields.put("NivelFuro", binding.editTextNivelFuro);

        binding.buttonStartEnsaio.setOnClickListener(v -> viewModel.ensaioButtonListener (v,
                binding.editTextStartDate));  // todo: remover essa responsabilidade daqui

        return binding.getRoot();
    }

    public void setProjetoSpt(ProjetoSpt projetoSpt) {viewModel.setProjeto(projetoSpt, fields);}
}