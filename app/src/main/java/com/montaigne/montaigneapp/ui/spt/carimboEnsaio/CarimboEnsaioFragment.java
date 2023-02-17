package com.montaigne.montaigneapp.ui.spt.carimboEnsaio;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.databinding.FragmentSptCarimboEnsaioBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptVM;
import com.montaigne.montaigneapp.utils.Geolocation;
import com.montaigne.montaigneapp.utils.DatePickerUtil;
import com.montaigne.montaigneapp.utils.PreparaDataUtil;
import com.montaigne.montaigneapp.utils.editTextInputParser;

import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class CarimboEnsaioFragment extends Fragment {
    private CarimboEnsaioVM viewModel;
    private SptVM projectViewModel;
    private FragmentSptCarimboEnsaioBinding binding;
    private final Map<String, EditText> fields = new HashMap<>();

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
        binding = FragmentSptCarimboEnsaioBinding.inflate(inflater, container, false);

        fields.put("NivelFuro", binding.editTextNivelFuro);
        fields.put("DataInicio", binding.editTextStartDate);

        ProjetoSpt projeto = projectViewModel.getProjeto();
        int furoId = requireArguments().getInt("furoId");
        viewModel.setupViewModel(projeto, furoId, fields);

        SptActivity activity = (SptActivity) requireActivity();
        activity.setButtonNavigateText(getString(R.string.btn_navigate_carimbo_furo));

        binding.buttonGetLocation.setOnClickListener(v -> viewModel.setLocation(
                Geolocation.getLatlog(v)
        ));

        binding.editTextStartDate.setOnClickListener(v -> {
            DatePickerUtil datePicker = new DatePickerUtil(
                    this.getActivity(),
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        binding.editTextStartDate.setText(
                                PreparaDataUtil.preparaData(selectedYear, selectedMonth, selectedDay
                                )
                        );
                        fields.put("DataInicio", binding.editTextStartDate);
                    }
            );
            datePicker.create();
        });

        return binding.getRoot();
    }

    public int getFuroId() {
        return viewModel.furoId;
    }

    @Override
    public void onPause() {
        super.onPause();
        projectViewModel.updateProjeto(viewModel.getProjeto(fields));
    }
}