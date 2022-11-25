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

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.FragmentCarimboEnsaioBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;

import java.util.HashMap;
import java.util.Map;

public class CarimboEnsaioFragment extends Fragment {
    private CarimboEnsaioVM viewModel;
    private SptVM projectViewModel;
    private FragmentCarimboEnsaioBinding binding;
    private Map<String, EditText> fields;

    public CarimboEnsaioFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(CarimboEnsaioVM.class);
        projectViewModel = new ViewModelProvider(requireActivity()).get(SptVM.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentCarimboEnsaioBinding.inflate(inflater, container, false);

        fields = new HashMap<>();
        fields.put("DataInicio", binding.editTextStartDate);
        fields.put("NivelFuro", binding.editTextNivelFuro);

        ProjetoSpt projeto = projectViewModel.getProjeto();
        viewModel.setProjeto(projeto, fields);

        ((SptActivity) getActivity())
                .setNavigateButtonText(getString(R.string.btn_navigate_carimbo_furo));

        return binding.getRoot();
    }

    @Override
    public void onPause() {
        super.onPause();
        projectViewModel.updateProjeto(viewModel.getProjeto(fields));
    }
}