package com.montaigne.montaigneapp.ui.carimboProjeto;

import android.os.Bundle;
import android.util.Log;
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

import java.util.HashMap;

public class CarimboProjetoFragment extends Fragment {
    private CarimboProjetoVM viewModel;
    private FragmentCarimboProjetoBinding binding;
    protected final HashMap<String, EditText> fields = new HashMap<>();
    private final Projeto projeto;

    public CarimboProjetoFragment() {projeto = new ProjetoSpt();}

    public CarimboProjetoFragment(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(CarimboProjetoVM.class);
    }  // todo: criar um adapter que adapte todos os campos de um projeto para os dados de um editText

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentCarimboProjetoBinding.inflate(inflater, container, false);
        fields.put("NomeProjeto", binding.editTextNameProjeto);
        fields.put ("Empresa",  binding.editTextEmpresa);
        fields.put ("Tecnico",  binding.editTextTecnico);
        fields.put ("Contato",  binding.editTextContato);
        fields.put ("Cliente",  binding.editTextCliente);
        fields.put ("LocalObra",  binding.editTextLocalObra);
        fields.put ("QuantidadeFuros",  binding.editTextQuantidadeFuros);
        binding.buttonContinueCarimbo.setOnClickListener(v -> viewModel.updateProjeto (v, fields));

        viewModel.setProjeto(projeto, fields);

        return binding.getRoot();
    }

    public Projeto getProjeto() {return viewModel.getProjeto();}
}