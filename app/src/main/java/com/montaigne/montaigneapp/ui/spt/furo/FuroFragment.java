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
import com.montaigne.montaigneapp.ui.spt.projeto.ProjetoFragment;

public class FuroFragment extends Fragment {
    private FuroVM viewModel;
    private SptVM projectViewModel;
    private FragmentFuroBinding binding;
    private int idFuro;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(FuroVM.class);
        projectViewModel = new ViewModelProvider(requireActivity()).get(SptVM.class);

        getParentFragmentManager().setFragmentResultListener(
                ProjetoFragment.SELECTEDKEY, this, ((requestKey, result) -> {
                    String idFuro = result.getString(ProjetoFragment.IDKEY);

                    ProjetoSpt projeto = projectViewModel.getProjeto();
                    viewModel.setFuro(projeto, idFuro);
                }));
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentFuroBinding.inflate(inflater, container, false);

        ProjetoSpt projeto = projectViewModel.getProjeto();
        viewModel.setFuro(projeto, idFuro);
        viewModel.updateFurosAdapter(binding.recyclerAmostra);

        SptActivity activity = (SptActivity) getActivity();
        activity.setNavigateButtonText(getString(R.string.btn_navigate_furo));
        activity.setActionBarTitle("Furo " + idFuro + 1);

        return binding.getRoot();
    }

    @Override
    public void onPause() {
        super.onPause();
        projectViewModel.updateProjeto(viewModel.getProjetoSpt());
    }
}