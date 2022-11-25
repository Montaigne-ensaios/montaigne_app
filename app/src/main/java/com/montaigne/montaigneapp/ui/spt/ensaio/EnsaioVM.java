package com.montaigne.montaigneapp.ui.spt.ensaio;

import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;

public class EnsaioVM extends ViewModel {
    private  int idFuro;
    private  int idAmostra;
    private  ProjetoSpt projeto;

    public void setAmostra(ProjetoSpt projeto,int idFuro, int idAmostra,
                           ArrayList<EditText> golpes, ArrayList<EditText> penetracoes) {
        this.projeto = projeto;
        this.idAmostra = idAmostra;
        this.idFuro = idFuro;
        golpes.get(1).setText(getAmostra().getGolpe1());
        golpes.get(2).setText(getAmostra().getGolpe2());
        golpes.get(3).setText(getAmostra().getGolpe3());
        penetracoes.get(1).setText(R.string.notImplemented);
        penetracoes.get(2).setText(R.string.notImplemented);
        penetracoes.get(3).setText(R.string.notImplemented);
        // TODO: 02/11/2022 Implementar penetracoes na Amostra.

    }

    private FuroSpt getFuro() {
        return projeto.getListaDeFuros().get(idFuro);
    }

    private AmostraSpt getAmostra() {
        return projeto.getListaDeFuros().get(idFuro).getListaDeAmostras().get(idAmostra);
    }

    protected ProjetoSpt getProjeto(ArrayList<EditText> golpes, ArrayList<EditText> penetracoes) {
        AmostraSpt amostra = getAmostra();
        FuroSpt furo = getFuro();

        amostra.setGolpe1(getInt(golpes.get(1)));
        amostra.setGolpe2(getInt(golpes.get(2)));
        amostra.setGolpe3(getInt(golpes.get(3)));
        // TODO: 02/11/2022 implementar penetracoes.

        furo.getListaDeAmostras().set(idAmostra, amostra);
        projeto.getListaDeFuros().set(idFuro, furo);

        return projeto;
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
