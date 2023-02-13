package com.montaigne.montaigneapp.ui.spt.carimboEnsaio;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.databinding.FragmentCarimboEnsaioBinding;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.ui.spt.SptVM;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class CarimboEnsaioFragment extends Fragment {
    private CarimboEnsaioVM viewModel;
    private SptVM projectViewModel;
    private FragmentCarimboEnsaioBinding binding;
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
        binding = FragmentCarimboEnsaioBinding.inflate(inflater, container, false);

        fields.put("NivelFuro", binding.editTextNivelFuro);

        ProjetoSpt projeto = projectViewModel.getProjeto();
        int furoId = requireArguments().getInt("furoId");
        viewModel.setupViewModel(projeto, furoId, fields);

        SptActivity activity = (SptActivity) requireActivity();
        activity.setNavigateButtonText(getString(R.string.btn_navigate_carimbo_furo));
        activity.setActionBarTitle(getString(R.string.furo_action_bar_title) + (furoId + 1));

        binding.buttonGetLocation.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), R.string.notImplemented, Toast.LENGTH_SHORT).show();
//            viewModel.setLocation();  // todo: implementar coordenadas
        });

        binding.calendarioDataInicio.setOnClickListener(v -> {
            Calendar calendario = Calendar.getInstance(TimeZone.getDefault());
            DatePickerDialog datePicker = new DatePickerDialog(
                    this.getActivity(),
                    AlertDialog.THEME_DEVICE_DEFAULT_DARK,
                    datePickerListener,
                    calendario.get(Calendar.YEAR),
                    calendario.get(Calendar.MONTH),
                    calendario.get(Calendar.DAY_OF_MONTH)
            );
            datePicker.setCancelable(false);
            datePicker.show();
        });

        return binding.getRoot();
    }

    public int getFuroId() {
        return viewModel.furoId;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = (view, selectedYear, selectedMonth, selectedDay) -> {
        String ano = preparaData(selectedYear);
        String mes = preparaData(selectedMonth + 1);
        String dia = preparaData(selectedDay);

        binding.editTextStartDate.setText(dia + "/" + mes + "/" + ano);
        fields.put("DataInicio", binding.editTextStartDate);
    };

    @Override
    public void onPause() {
        super.onPause();
        projectViewModel.updateProjeto(viewModel.getProjeto(fields));
    }

    private String preparaData(int data) {
        if (data < 10) {
            return "0" + String.valueOf(data);
        } else {
            return String.valueOf(data);
        }
    }
}