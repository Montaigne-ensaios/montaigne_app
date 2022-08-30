package com.montaigne.montaigneapp.activity.spt.carimboUnico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.ensaio.EnsaioActivity;
import com.montaigne.montaigneapp.data.usecase.SaveAmostraSpt;
import com.montaigne.montaigneapp.data.usecase.SaveProjetoSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class CarimboUnicoVM {
    private final CarimboUnicoActivity activity;
    private ProjetoSpt projeto;
    private Bundle extras;

    public CarimboUnicoVM(CarimboUnicoActivity activity) {

        this.activity = activity;
        activity.buttonIniciarEnsaio.setOnClickListener(this::ensaioButtonListener);
        activity.imageButtonHome.setOnClickListener(this:: homeButtonListener);

        this.extras = activity.getIntent().getExtras();

        ProjetoSpt projeto = new ProjetoSpt();
        projeto.setName(extras.getString("NomeProjeto"));
        projeto.setTechnician(extras.getString("Tecnico"));
        projeto.setCompany(extras.getString("Empresa"));
        projeto.setPhoneNumber(extras.getString("Contato"));
        projeto.setClient(extras.getString("Cliente"));
//        projeto.setCoordinate(extras.getString("Cliente"));  // precisa da interface de coordenadas
        projeto.setHoleNumber(extras.getInt("nFuros"));

        SaveProjetoSpt.saveProjetoSpt(projeto);
    }

    private void ensaioButtonListener(View view) {
        Intent intent = new Intent(view.getContext(), EnsaioActivity.class);
        intent.putExtra("NomeProjeto", projeto);
        view.getContext().startActivity(intent);


    }

    private void homeButtonListener (View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo: limpar tasks;
    }
}
