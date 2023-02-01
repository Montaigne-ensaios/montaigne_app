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

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.FragmentEnsaioBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;

import java.util.ArrayList;

public class EnsaioFragment extends Fragment {
    private EnsaioVM viewModel;
    private SptVM projectViewModel;
    private FragmentEnsaioBinding binding;
    protected final ArrayList<EditText> golpes = new ArrayList<>(),
            penetracoes = new ArrayList<>(),
            fields = new ArrayList<>();
    // lista de golpes e penetrações por segmento

    public EnsaioFragment() {}

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

        fields.add(binding.textInputEditTextProfundidade);
        fields.add(binding.textInputEditTextNivelDAgua);

        binding.imageButtonDecrementGolpe1.setOnClickListener(v -> viewModel.decrementGolpe(golpes.get(0)));
        binding.imageButtonDecrementGolpe2.setOnClickListener(v -> viewModel.decrementGolpe(golpes.get(1)));
        binding.imageButtonDecrementGolpe3.setOnClickListener(v -> viewModel.decrementGolpe(golpes.get(2)));

        binding.imageButtonIcrementGolpe1.setOnClickListener(v -> viewModel.incrementGolpe(golpes.get(0)));
        binding.imageButtonIcrementGolpe2.setOnClickListener(v -> viewModel.incrementGolpe(golpes.get(1)));
        binding.imageButtonIcrementGolpe3.setOnClickListener(v -> viewModel.incrementGolpe(golpes.get(2)));

        ProjetoSpt projeto = projectViewModel.getProjeto();
        Bundle args = requireArguments();
        int furoId = args.getInt("furoId");
        int amostraId = args.getInt("amostraId");
        viewModel.setupViewModel(projeto, furoId, amostraId, golpes, penetracoes, fields);

        SptActivity activity = (SptActivity) requireActivity();
        activity.setNavigateButtonText(getString(R.string.btn_navigate_ensaio));
        activity.setActionBarTitle(getString(R.string.furo_action_bar_title) + (furoId + 1));

        binding.buttonFinnishEnsaio.setOnClickListener(v -> SptVM.navigateFragments(
                R.id.action_finish_Ensaio, activity.getSupportFragmentManager()));

        return binding.getRoot();
    }

    public int getFuroId() {
        return viewModel.furoId;
    }

    @Override
    public void onPause() {
        super.onPause();
        projectViewModel.updateProjeto(viewModel.getProjeto(golpes, penetracoes, fields));
    }


}

