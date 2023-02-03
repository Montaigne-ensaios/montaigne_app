package com.montaigne.montaigneapp.ui.spt.carimboEnsaio;

import static com.montaigne.montaigneapp.data.utils.editTextInputParser.getCurrentDate;
import static com.montaigne.montaigneapp.data.utils.editTextInputParser.getDate;
import static com.montaigne.montaigneapp.data.utils.editTextInputParser.getFloat;
import static com.montaigne.montaigneapp.data.utils.editTextInputParser.setValue;

import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.google.android.material.snackbar.Snackbar;
import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class CarimboEnsaioVM extends ViewModel {
    private final String TAG = "CarimboEnsaio";

    private ProjetoSpt projeto;
    private FuroSpt furo;
    protected int furoId;

    protected void setupViewModel(ProjetoSpt projeto, int furoId, Map<String, EditText> fields) {
        this.projeto = projeto;
        this.furoId = furoId;
        if (furoId == projeto.getListaDeFuros().size()) {
            furo = new FuroSpt();
            furo.setCodigo("SP-0" + (furoId + 1));
        } else {
            furo = projeto.getListaDeFuros().get(furoId);

            if (furo.getDataInicio() != null)
                setValue(Objects.requireNonNull(fields.get("dataInicio")), furo.getDataInicio());
            else
                setValue(Objects.requireNonNull(fields.get("dataInicio")), getCurrentDate());

            setValue(Objects.requireNonNull(fields.get("NivelFuro")), furo.getCotaInicial());
        }
    }

    protected void setLocation(Coordenada coordenada) {
        furo.setCoordenada(coordenada);
    }

    protected ProjetoSpt getProjeto(Map<String, EditText> fields) {
        furo.setCotaInicial(getFloat(Objects.requireNonNull(fields.get("NivelFuro"))));
        try {
            furo.setDataInicio(getDate(Objects.requireNonNull(fields.get("DataInicio"))));
        } catch (ParseException e) {
            Toast.makeText(Objects.requireNonNull(fields.get("DataInicio")).getContext(), "Formato de data ilegal", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "Formato de data inválido.", e);
        }  // todo: substituir por datepicker

        boolean isNew = true;
        for (FuroSpt furoI: projeto.getListaDeFuros()) {
            if (furoI.getCodigo().equals(furo.getCodigo())) {
                isNew = false;
                break;
            }
        }

        if (isNew) {
            projeto.getListaDeFuros().add(furo);
            furo.setListaDeAmostras(new ArrayList<>());
        }
        else
            projeto.getListaDeFuros().set(furoId, furo);

        return projeto;
    }
}
