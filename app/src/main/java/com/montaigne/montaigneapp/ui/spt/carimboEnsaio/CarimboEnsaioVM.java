package com.montaigne.montaigneapp.ui.spt.carimboEnsaio;

import android.widget.EditText;
import android.widget.Toast;

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
    protected int furoId;

    protected void setupViewModel(ProjetoSpt projeto, int furoId, Map<String, EditText> fields) {
        this.projeto = projeto;
        this.furoId = furoId;
        if (furoId == projeto.getListaDeFuros().size()) {
            furo = new FuroSpt();
            furo.setCodigo("SP-0" + furoId + 1);
        } else {
            furo = projeto.getListaDeFuros().get(furoId);

            fields.get("dataInicio").setText(furo.getDataInicio().toString());
            fields.get("NivelFuro").setText(String.valueOf(furo.getCotaInicial()));
        }
    }

    protected void setLocation(Coordenada coordenada) {
        furo.setCoordenada(coordenada);
    }

    protected ProjetoSpt getProjeto(Map<String, EditText> fields) {
        furo.setCotaInicial(Float.parseFloat(fields.get("NivelFuro").getText().toString()));
        try {
            furo.setDataInicio(Date.valueOf(fields.get("DataInicio").getText().toString()));
        } catch (IllegalArgumentException e) {
            Toast.makeText(fields.get("DataInicio").getContext(), "Formato de data ilegal", Toast.LENGTH_SHORT).show();
        }  // todo: date parser adequado
        furo.setListaDeAmostras(new ArrayList<>());

        boolean isNew = true;
        for (FuroSpt furoI: projeto.getListaDeFuros()) {
            if (furoI.getCodigo().equals(furo.getCodigo())) {
                isNew = false;
                break;
            }
        }

        if (isNew)
            projeto.getListaDeFuros().add(furo);
        else
            projeto.getListaDeFuros().set(furoId, furo);

        return projeto;
    }
}
