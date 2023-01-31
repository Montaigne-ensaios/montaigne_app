package com.montaigne.montaigneapp.data.ui.spt.ensaio;

import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;

public class EnsaioVM extends ViewModel {
    private ProjetoSpt projeto;
    protected int furoId;
    protected int amostraId;
    private AmostraSpt amostra;

    public void setupViewModel(ProjetoSpt projeto, int idFuro, int idAmostra,
                               ArrayList<EditText> golpes, ArrayList<EditText> penetracoes,
                               ArrayList<EditText> fields) {
        this.projeto = projeto;
        this.furoId = idFuro;
        this.amostraId = idAmostra;

        if (idAmostra == getFuro().getListaDeAmostras().size()) {
            amostra = new AmostraSpt();
        } else {
            amostra = getAmostra();
        }

        setInt(golpes.get(0), amostra.getGolpe1());
        setInt(golpes.get(1), amostra.getGolpe2());
        setInt(golpes.get(2), amostra.getGolpe3());
        setFloat(penetracoes.get(0), amostra.getPenatracao1());
        setFloat(penetracoes.get(1), amostra.getPenatracao2());
        setFloat(penetracoes.get(2), amostra.getPenatracao3());

        setFloat(fields.get(0), amostra.getProfundidade());
        setFloat(fields.get(1), getFuro().getNivelDAgua());
    }

    private FuroSpt getFuro() {
        return projeto.getListaDeFuros().get(furoId);
    }

    private AmostraSpt getAmostra() {
        return projeto.getListaDeFuros().get(furoId).getListaDeAmostras().get(amostraId);
    }

    protected ProjetoSpt getProjeto(
            ArrayList<EditText> golpes, ArrayList<EditText> penetracoes, ArrayList<EditText> fields) {
        FuroSpt furo = getFuro();

        amostra.setGolpe1((int) getFloat(golpes.get(0)));
        amostra.setGolpe2((int) getFloat(golpes.get(1)));
        amostra.setGolpe3((int) getFloat(golpes.get(2)));
        amostra.setPenatracao1(getFloat(penetracoes.get(0)));
        amostra.setPenatracao2(getFloat(penetracoes.get(1)));
        amostra.setPenatracao3(getFloat(penetracoes.get(2)));

        amostra.setProfundidade(getFloat(fields.get(0)));
        furo.setNivelDAgua(getFloat(fields.get(1)));

        boolean isNew = true;
        for (AmostraSpt amostraI: furo.getListaDeAmostras()) {
            if (amostraI.getProfundidade() == amostra.getProfundidade()) {
                isNew = false;
                break;
            }
        }

        if (isNew)
            furo.getListaDeAmostras().add(amostra);
        else
            furo.getListaDeAmostras().set(amostraId, amostra);

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
        String value = String.valueOf(editText.getText());
        return value.equals("") ? 0 : Float.parseFloat(value);
    }

    private void setFloat(@NonNull EditText editText, float value) {
        editText.setText(String.valueOf(value));
    }

    private void setInt(@NonNull EditText editText, int value) {
        editText.setText(String.valueOf(value));
    }
}
