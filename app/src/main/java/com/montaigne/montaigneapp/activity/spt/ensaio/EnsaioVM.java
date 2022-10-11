package com.montaigne.montaigneapp.activity.spt.ensaio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.activity.home.HomeActivity;
import com.montaigne.montaigneapp.activity.spt.projeto.ProjetoActivity;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;

public class EnsaioVM extends ViewModel {
    private  ProjetoSpt projeto;
    private  FuroSpt furo;
    private  AmostraSpt amostra;


    protected void setExtras(Bundle bundle) {
        projeto = (ProjetoSpt) bundle.getSerializable("Projeto");
        //TODO: java.lang.NullPointerException: Attempt to invoke interface method 'java.lang.Object java.util.List.get(int)' on a null object reference
        furo = projeto.getListaDeFuros().get(bundle.getInt("nFuro", 0));
        amostra = furo.getListaDeAmostras().get(bundle.getInt("nAmostra", 0));
    }

    public AmostraSpt getAmostra() {
        return amostra;
    }

    protected void finalizarFuroButtonListener(View view, ArrayList<EditText> golpes,
                                               ArrayList<EditText> penetracoes) {
        updateAmostra(golpes, penetracoes);

        view.getContext().startActivity(new Intent(view.getContext(), ProjetoActivity.class));
    }

    protected void homeButtonListener(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HomeActivity.class));
        //todo:limpar tasks
    }

    private void updateAmostra(ArrayList<EditText> golpes, ArrayList<EditText> penetracoes){
        amostra.setGolpe1(getInt(golpes.get(0)));
        amostra.setGolpe2(getInt(golpes.get(1)));
        amostra.setGolpe3(getInt(golpes.get(2)));

        // amostra.setNspt(getInt(penetracoes.get(1)) + getInt(penetracoes.get(2)));

        // SaveAmostraSpt.saveAmostraSpt(amostra);
    }


    protected void incrementGolpe(EditText editText) {
        setInt(editText, getInt(editText) + 1);
    }

    protected void decrementGolpe(EditText editText) {
        // garante que o valor jamais será menor que zero
        int v = getInt(editText);
        v = (v > 0) ? (v - 1) : v;
        setInt(editText, v);
    }

    private int getInt(EditText editText) {
        return Integer.parseInt(String.valueOf(editText.getText()));
    }

    private void setInt(EditText editText, int value) {
        editText.setText(String.valueOf(value));
    }
}
