package com.montaigne.montaigneapp.ui.spt.carimboEnsaio;

import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.Map;

public class CarimboEnsaioVM extends ViewModel {
    private ProjetoSpt projeto;

    public void setProjeto(ProjetoSpt projeto, Map<String, EditText> fields) {
        this.projeto = projeto;

        try {
            fields.get("DataInicio").setText(projeto.getDataInicio());
            fields.get("NivelFuro").setText("Não implementado");
        } catch (NullPointerException ignored) {
            // todo: forma adequada de checar se os campos foram ou não definidos
        }
    }

    public ProjetoSpt getProjeto(Map<String, EditText> fields) {
        projeto.setDataInicio((String) fields.get("DataInicio").getText().toString());
        return projeto;
    }
}
