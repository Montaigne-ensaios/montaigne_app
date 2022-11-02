package com.montaigne.montaigneapp.ui.spt.ensaio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.databinding.FragmentEnsaioBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptVM;

import java.util.ArrayList;

public class EnsaioFragment extends Fragment {
    private EnsaioVM viewModel;
    private SptVM projectViewModel;
    private FragmentEnsaioBinding binding;
    protected final ArrayList<EditText> golpes = new ArrayList<>(), penetracoes = new ArrayList<>();
    // lista de golpes e penetrações por segmento
    private int idFuro;
    private int idAmostra;


    public EnsaioFragment() {}

    public EnsaioFragment(int idFuro, int idAmostra) {
        this.idFuro = idFuro;
        this.idAmostra = idAmostra;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(EnsaioVM.class);
        projectViewModel = new ViewModelProvider(requireActivity()).get(SptVM.class);
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentEnsaioBinding.inflate(inflater, container, false);

        golpes.add(binding.editTextGolpe1);
        golpes.add(binding.editTextGolpe2);
        golpes.add(binding.editTextGolpe3);

        penetracoes.add(binding.editTextPenetracao1);
        penetracoes.add(binding.editTextPenetracao2);
        penetracoes.add(binding.editTextPenetracao3);

        binding.imageButtonDecrementGolpe1.setOnClickListener(v -> viewModel.decrementGolpe(golpes.get(1)));
        binding.imageButtonDecrementGolpe2.setOnClickListener(v -> viewModel.decrementGolpe(golpes.get(2)));
        binding.imageButtonDecrementGolpe3.setOnClickListener(v -> viewModel.decrementGolpe(golpes.get(3)));

        binding.imageButtonIcrementGolpe1.setOnClickListener(v -> viewModel.incrementGolpe(golpes.get(1)));
        binding.imageButtonIcrementGolpe2.setOnClickListener(v -> viewModel.incrementGolpe(golpes.get(2)));
        binding.imageButtonIcrementGolpe3.setOnClickListener(v -> viewModel.incrementGolpe(golpes.get(3)));

        ProjetoSpt projeto = projectViewModel.getProjeto();
        viewModel.setAmostra(projeto, idFuro, idAmostra, golpes, penetracoes);

        return binding.getRoot();
    }

    @Override
    public void onPause() {
        super.onPause();
        projectViewModel.updateProjeto(viewModel.getProjeto(golpes, penetracoes));
    }


}

