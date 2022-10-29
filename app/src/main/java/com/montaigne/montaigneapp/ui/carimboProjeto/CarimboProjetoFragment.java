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

import java.util.HashMap;

public class CarimboProjetoFragment extends Fragment {
    private CarimboProjetoVM viewModel;
    private FragmentCarimboProjetoBinding binding;
    protected final HashMap<String, EditText> fields = new HashMap<>();

    public CarimboProjetoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CarimboProjetoVM viewModel = new ViewModelProvider(this).get(CarimboProjetoVM.class);
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentCarimboProjetoBinding.inflate(inflater, container, false);
        fields.put ("Tecnico",  binding.editTextTecnico);
        fields.put ("Empresa",  binding.editTextEmpresa);
        fields.put ("Contato",  binding.editTextContato);
        fields.put ("Cliente",  binding.editTextCliente);
        fields.put ("LocalObra",  binding.editTextLocalObra);
        fields.put ("QuantidadeFuros",  binding.editTextQuantidadeFuros);
        binding.buttonContinueCarimbo.setOnClickListener(v -> viewModel.continuarCarimboButtonListener (v, fields));

        return binding.getRoot();
    }
}