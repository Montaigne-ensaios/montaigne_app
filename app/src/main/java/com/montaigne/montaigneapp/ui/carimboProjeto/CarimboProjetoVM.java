package com.montaigne.montaigneapp.ui.carimboProjeto;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.ui.home.HomeVM;
import com.montaigne.montaigneapp.ui.spt.SptActivity;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.Map;

public class CarimboProjetoVM extends ViewModel {
    private Projeto projeto;

    // método de getData (validação de entradas)
    protected void updateProjeto(View view, Map<String, EditText> fields) {
        // todo: revisar o fluxo de dados deste fragment
        // revisar como a comunicação foi planejada
        projeto.setNome(fields.get("NomeProjeto").getText().toString());
        projeto.setEmpresa(fields.get("Empresa").getText().toString());
        projeto.setCliente(fields.get("Tecnico").getText().toString());
        projeto.setTecnico(fields.get("Contato").getText().toString());
        projeto.setNumeroDeTelefone(fields.get("Cliente").getText().toString());
        projeto.setEmpresa(fields.get("LocalObra").getText().toString());
//        fields.get("nFuros").getText().toString();
//        fields.get("ReferenciaNivel").getText().toString;

//        ProjetoSptUseCase.save((ProjetoSpt) projeto);  // todo: decidir quando dar save e quando dar update
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto, Map<String, EditText> fields) {
        this.projeto = projeto;

        try {
            fields.get("NomeProjeto").setText(projeto.getNome());
            fields.get("Empresa").setText(projeto.getEmpresa());
            fields.get("Tecnico").setText(projeto.getTecnico());
            fields.get("Contato").setText(projeto.getNumeroDeTelefone());
            fields.get("Cliente").setText(projeto.getCliente());
            fields.get("LocalObra").setText("Não implementado");
            fields.get("ReferenciaNivel").setText("Não implementado");
        } catch (NullPointerException ignored) {
            // todo: forma adequada de checar se os campos foram ou não definidos
        }
    }
}
