package com.montaigne.montaigneapp.ui.spt.carimboEnsaio;

import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

public class CarimboEnsaioVM extends ViewModel {
    private ProjetoSpt projeto;
    private FuroSpt furo;

    public void setupViewModel(ProjetoSpt projeto, int furoId, Map<String, EditText> fields) {
        this.projeto = projeto;
        if (furoId == projeto.getListaDeFuros().size()) {
            furo = new FuroSpt();
            furo.setCodigo(String.valueOf(furoId + 1));
        } else {
            furo = projeto.getListaDeFuros().get(furoId);

            fields.get("dataInicio").setText(furo.getDataInicio().toString());
            fields.get("NivelFuro").setText(String.valueOf(furo.getCotaInicial()));
        }
    }

    public void setLocation(Coordenada coordenada) {
        furo.setCoordenada(coordenada);
    }

    public ProjetoSpt getProjeto(Map<String, EditText> fields) {
        furo.setCotaInicial(Float.parseFloat(fields.get("NivelFuro").getText().toString()));
        furo.setDataInicio(Date.valueOf(fields.get("DataInicio").getText().toString()));
        furo.setListaDeAmostras(new ArrayList<>());

        projeto.getListaDeFuros().add(furo);
        return projeto;
    }
}
