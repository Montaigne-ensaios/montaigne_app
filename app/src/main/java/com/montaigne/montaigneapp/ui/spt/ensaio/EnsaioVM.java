package com.montaigne.montaigneapp.ui.spt.ensaio;

import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;

public class EnsaioVM extends ViewModel {
    private  ProjetoSpt projeto;
    private  int furoId;
    private  int amostraId;
    private AmostraSpt amostra;

    public void setupViewModel(ProjetoSpt projeto, int idFuro, int idAmostra,
                               ArrayList<EditText> golpes, ArrayList<EditText> penetracoes) {
        this.projeto = projeto;
        this.furoId = idFuro;
        this.amostraId = idAmostra;

        if (idAmostra == getFuro().getListaDeAmostras().size()) {
            amostra = new AmostraSpt();
        } else {
            amostra = getAmostra();
        }

        setInt(golpes.get(1), getAmostra().getGolpe1());
        setInt(golpes.get(2), getAmostra().getGolpe2());
        setInt(golpes.get(3), getAmostra().getGolpe3());
        setFloat(penetracoes.get(1), getAmostra().getPenatracao1());
        setFloat(penetracoes.get(2), getAmostra().getPenatracao2());
        setFloat(penetracoes.get(3), getAmostra().getPenatracao3());
    }

    private FuroSpt getFuro() {
        return projeto.getListaDeFuros().get(furoId);
    }

    private AmostraSpt getAmostra() {
        return projeto.getListaDeFuros().get(furoId).getListaDeAmostras().get(amostraId);
    }

    protected ProjetoSpt getProjeto(ArrayList<EditText> golpes, ArrayList<EditText> penetracoes) {
        FuroSpt furo = getFuro();

        amostra.setGolpe1((int) getFloat(golpes.get(0)));
        amostra.setGolpe2((int) getFloat(golpes.get(1)));
        amostra.setGolpe3((int) getFloat(golpes.get(2)));
        amostra.setPenatracao1(getFloat(penetracoes.get(0)));
        amostra.setPenatracao2(getFloat(penetracoes.get(1)));
        amostra.setPenatracao3(getFloat(penetracoes.get(2)));

        if (amostraId >= furo.getListaDeAmostras().size())
            furo.getListaDeAmostras().set(amostraId, amostra);
        else
            furo.getListaDeAmostras().add(amostra);
        projeto.getListaDeFuros().set(furoId, furo);

        return projeto;
    }

    protected void incrementGolpe(EditText editText) {
        setInt(editText, (int) getFloat(editText) + 1);
    }

    protected void decrementGolpe(EditText editText) {
        // garante que o valor jamais será menor que zero
        int v = (int) getFloat(editText);
        v = (v > 0) ? (v - 1) : v;
        setInt(editText, v);
    }

    private float getFloat(EditText editText) {
        return Integer.parseInt(String.valueOf(editText.getText()));
    }

    private void setFloat(@NonNull EditText editText, float value) {
        editText.setText(String.valueOf(value));
    }

    private void setInt(@NonNull EditText editText, int value) {
        editText.setText(String.valueOf(value));
    }
}
