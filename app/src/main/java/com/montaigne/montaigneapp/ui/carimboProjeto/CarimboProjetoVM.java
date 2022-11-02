package com.montaigne.montaigneapp.ui.carimboProjeto;

import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.model.Projeto;

import java.util.Map;

public class CarimboProjetoVM extends ViewModel {
    private Projeto projeto;

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

    protected Projeto getProjeto(Map<String, EditText> fields) {
        projeto.setNome(fields.get("NomeProjeto").getText().toString());
        projeto.setEmpresa(fields.get("Empresa").getText().toString());
        projeto.setCliente(fields.get("Cliente").getText().toString());
        projeto.setTecnico(fields.get("Tecnico").getText().toString());
        projeto.setNumeroDeTelefone(fields.get("Contato").getText().toString());
        return projeto;
    }
}
