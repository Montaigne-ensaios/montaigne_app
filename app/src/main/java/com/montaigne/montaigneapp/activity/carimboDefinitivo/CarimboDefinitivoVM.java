package com.montaigne.montaigneapp.activity.carimboDefinitivo;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.carimboUnico.CarimboUnicoActivity;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.Map;

public class CarimboDefinitivoVM extends ViewModel {
    // método de getData (validação de entradas)

    protected void continuarCarimboButtonListener(View view, Map<String, EditText> fields) {
        Intent intent = new Intent(view.getContext(), CarimboUnicoActivity.class);

        /*
        intent.putExtra("Tecnico", activity.fields.get ("Tecnico"). getText(). toString());
        intent.putExtra("Empresa", activity.fields.get ("Empresa"). getText(). toString());
        intent.putExtra("Contato", activity.fields.get ("Contato"). getText(). toString());
        intent.putExtra("Cliente", activity.fields.get ("Cliente"). getText(). toString());
        intent.putExtra("LocalObra", activity.fields.get ("LocalObra"). getText(). toString());
        intent.putExtra("nFuros", activity.fields.get ("QuantidadeFuros"). getText(). toString());
        intent.putExtra("ReferenciaNivel", activity.fields.get ("ReferenciaNivel"). getText(). toString());
        intent.putExtra("NomeProjeto", activity.fields.get ("NomeProjeto"). getText(). toString());
         */

        String nome = fields.get("NomeProjeto").getText().toString();
        String empresa = fields.get("Empresa").getText().toString();
        String tecnico = fields.get("Tecnico").getText().toString();
        String cotato = fields.get("Contato").getText().toString();
        String cliente = fields.get("Cliente").getText().toString();
        String local = fields.get("LocalObra").getText().toString();
        //String nFuros = fields.get("nFuros").getText().toString();
        String referenciaNivel = fields.get("ReferenciaNivel").getText().toString();


        ProjetoSpt projetoSpt = new ProjetoSpt();
        projetoSpt.setNome(nome);
        projetoSpt.setEmpresa(empresa);
        projetoSpt.setCliente(cliente);
        projetoSpt.setTecnico(tecnico);
        projetoSpt.setNumeroDeTelefone(cotato);
        projetoSpt.setEmpresa(empresa);

        intent.putExtra("ProjetoSpt", projetoSpt);

        view.getContext().startActivity(intent);
    }

    protected void homeButtonListener(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo:limpar tasks;
    }
}
