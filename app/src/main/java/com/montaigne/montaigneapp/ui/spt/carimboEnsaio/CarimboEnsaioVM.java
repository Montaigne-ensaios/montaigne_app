package com.montaigne.montaigneapp.ui.spt.carimboEnsaio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.ui.home.HomeActivity;
import com.montaigne.montaigneapp.ui.spt.ensaio.EnsaioActivity;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;
import java.util.Map;

public class CarimboEnsaioVM extends ViewModel {
    private ProjetoSpt projeto;

    private void updateProjeto(EditText editTextDataInicio) {
        projeto.setDataInicio(editTextDataInicio.getText().toString());

        ProjetoSptUseCase.save(projeto);  // todo: decidir quando dar save e quando dar update
    }

    protected void ensaioButtonListener(View view, EditText editTextDataInicio) {
        FuroSpt furoSpt = new FuroSpt();
        ArrayList<AmostraSpt> amostras = new ArrayList<>();
        amostras.add(new AmostraSpt());
        amostras.get(0).setId("0");

        furoSpt.setListaDeAmostras(amostras);

        ArrayList<FuroSpt> furos = new ArrayList();
        furos.add(furoSpt);

        projeto.setListaDeFuros(furos);
        updateProjeto(editTextDataInicio);

        Intent intent = new Intent(view.getContext(), EnsaioActivity.class);
        intent.putExtra("Projeto", projeto);
        view.getContext().startActivity(intent);
    }

    public ProjetoSpt getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoSpt projeto, Map<String, EditText> fields) {
        this.projeto = projeto;

        try {
            fields.get("DataInicio").setText(projeto.getDataInicio());
            fields.get("NivelFuro").setText("Não implementado");
        } catch (NullPointerException ignored) {
            // todo: forma adequada de checar se os campos foram ou não definidos
        }
    }
}
