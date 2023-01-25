package com.montaigne.montaigneapp.ui.spt.carimboEnsaio;

import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

public class CarimboEnsaioVM extends ViewModel {
    private ProjetoSpt projeto;
    private int furoId;

    public void setFuroId(ProjetoSpt projeto, int furoId, Map<String, EditText> fields) {
        this.projeto = projeto;
        this.furoId = furoId;
    }

    public ProjetoSpt getProjeto(Map<String, EditText> fields) {
        FuroSpt furoSpt = new FuroSpt(
                String.valueOf(furoId),
                String.valueOf(furoId + 1),
                Float.parseFloat(fields.get("NivelFuro").getText().toString()),
                Date.valueOf(fields.get("DataInicio").getText().toString()),
                new ArrayList<AmostraSpt>()
                );

        projeto.setDataInicio((String) fields.get("DataInicio").getText().toString());
        return projeto;
    }
}
