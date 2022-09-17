package com.montaigne.montaigneapp.activity.spt.carimboUnico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.ensaio.EnsaioActivity;
import com.montaigne.montaigneapp.data.usecase.SaveAmostraSpt;
import com.montaigne.montaigneapp.data.usecase.SaveProjetoSpt;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;

public class CarimboUnicoVM extends ViewModel {
    private final ProjetoSpt projeto;
    private Bundle extras;

    public CarimboUnicoVM() {
        projeto = new ProjetoSpt();
    }

    protected void setExtras(Bundle bundle) {
        extras = bundle;
    }

    private void updateProjeto(EditText editTextDataInicio) {
        projeto.setName(extras.getString("NomeProjeto"));
        projeto.setTechnician(extras.getString("Tecnico"));
        projeto.setCompany(extras.getString("Empresa"));
        projeto.setPhoneNumber(extras.getString("Contato"));
        projeto.setClient(extras.getString("Cliente"));
//        projeto.setCoordinate(extras.getString("Cliente"));  // precisa da api de coordenadas
        projeto.setHoleNumber(extras.getInt("nFuros"));
        // todo: eliminar a recuperação dos campos por intent

        projeto.setStarData(editTextDataInicio.getText().toString());
        SaveProjetoSpt.saveProjetoSpt(projeto);
    }

    protected void ensaioButtonListener(View view, EditText editTextDataInicio) {
        FuroSpt furoSpt = new FuroSpt();
        furoSpt.setCode("0");
        ArrayList<AmostraSpt> amostras = new ArrayList<>();
        amostras.add(new AmostraSpt());
        amostras.get(0).setId("0");
        furoSpt.setSamples(amostras);
        ArrayList<FuroSpt> furos = new ArrayList();
        furos.add(furoSpt);
        projeto.setPolls(furos);
        updateProjeto(editTextDataInicio);

        Intent intent = new Intent(view.getContext(), EnsaioActivity.class);
        intent.putExtra("Projeto", projeto);
        view.getContext().startActivity(intent);
    }

    protected void homeButtonListener (View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo: limpar tasks;
    }
}
