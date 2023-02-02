package com.montaigne.montaigneapp.ui.spt.furo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.FragmentFuroBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;

public class FuroFragment extends Fragment {
    private FuroVM viewModel;
    private SptVM projectViewModel;
    private FragmentFuroBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(FuroVM.class);
        projectViewModel = new ViewModelProvider(requireActivity()).get(SptVM.class);
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentFuroBinding.inflate(inflater, container, false);

        Bundle b = requireArguments();

        int furoId = b.getInt("furoId");

        ProjetoSpt projeto = projectViewModel.getProjeto();
        viewModel.setFuro(projeto, furoId);
        viewModel.updateAmostrasAdapter(binding.recyclerAmostra);

        SptActivity activity = (SptActivity) requireActivity();
        activity.setButtonNavigateText(getString(R.string.btn_navigate_furo));
        activity.setActionBarTitle("Furo " + (furoId + 1));

        return binding.getRoot();
    }

    @Override
    public void onPause() {
        super.onPause();
        projectViewModel.updateProjeto(viewModel.getProjeto());
    }
}