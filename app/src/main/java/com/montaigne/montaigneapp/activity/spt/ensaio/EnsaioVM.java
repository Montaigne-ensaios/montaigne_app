package com.montaigne.montaigneapp.activity.spt.ensaio;

import android.content.Intent;
import android.view.View;

import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.projeto.ProjetoActivity;
import com.montaigne.montaigneapp.data.usecase.SaveAmostraSpt;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class EnsaioVM {
    private final EnsaioActivity activity;
    private final ProjetoSpt projeto;
    private final FuroSpt furo;
    private final AmostraSpt amostra;

    public EnsaioVM(EnsaioActivity activity) {

        this.activity = activity;

        Intent intent = activity.getIntent();
        projeto = (ProjetoSpt) intent.getSerializableExtra("Projeto");
        furo = projeto.getPolls().get(intent.getIntExtra("nFuro", 0));
        amostra = furo.getSamples().get(intent.getIntExtra("nAmostra", 0));

        activity.textAmostraN.setText("Amostra " + amostra.getId());

        activity.buttonFinalizarFuro.setOnClickListener(this::finalizarFuroButtonListener);
        activity.imageButtonHome.setOnClickListener(this::homeButtonListener);
//        setGolpeModfiersListners();
    }

    private void finalizarFuroButtonListener(View view) {
        updateAmostra();

        view.getContext().startActivity(new Intent(view.getContext(), ProjetoActivity.class));
    }

    private void homeButtonListener(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo:limpar tasks
    }

    private void updateAmostra(){
        amostra.setBlows1(getGolpe(0));
        amostra.setBlows2(getGolpe(1));
        amostra.setBlows3(getGolpe(2));

        amostra.setNspt(getGolpe(1) + getGolpe(2));

        SaveAmostraSpt.saveAmostraSpt(amostra);
    }

    private void setGolpeModfiersListners(){
        for (int i = 0; i < 3; i++) {
            int finalI = i;  // finalização necessária para os lambdas
            activity.buttonsIncrementGolpes.get(i).setOnClickListener(v -> incrementGolpe(finalI));
            activity.buttonsDecrementGolpes.get(i).setOnClickListener(v -> decrementGolpe(finalI));
        }
    }

    private void incrementGolpe(int segmento) {
        setGolpe(segmento, getGolpe(segmento) + 1);
    }

    private void decrementGolpe(int segmento) {
        // garante que o valor jamais será menor que zero
        int v = getGolpe(segmento);
        v = (v > 0) ? (v - 1) : v;
        setGolpe(segmento, v);
    }

    private int getGolpe(int segmento) {
        return Integer.parseInt(String.valueOf(activity.golpes.get(segmento).getText()));
    }

    private void setGolpe(int segmento, int value) {
        activity.golpes.get(segmento).setText(String.valueOf(value));
    }
}
