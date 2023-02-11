package com.montaigne.montaigneapp.ui.spt.ensaio;

import static com.montaigne.montaigneapp.utils.editTextInputParser.getFloat;
import static com.montaigne.montaigneapp.utils.editTextInputParser.setValue;

import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.LockingTextWatcher;

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

        setValue(golpes.get(0), amostra.getGolpe1());
        setValue(golpes.get(1), amostra.getGolpe2());
        setValue(golpes.get(2), amostra.getGolpe3());
        setValue(penetracoes.get(0), amostra.getPenatracao1());
        setValue(penetracoes.get(1), amostra.getPenatracao2());
        setValue(penetracoes.get(2), amostra.getPenatracao3());

        setValue(fields.get(0), amostra.getProfundidade());
        setValue(fields.get(1), getFuro().getNivelDAgua());

        fields.get(0).addTextChangedListener(new LockingTextWatcher(true,
                "profundidadeFuro" + furoId) {
            @Override
            public void afterValidChangeListener(String string) {
                amostra.setProfundidade(Float.parseFloat(string));
            }
        });
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

        // profundidade definida pelo listener
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
        setValue(editText, (int) getFloat(editText) + 1);
    }

    protected void decrementGolpe(EditText editText) {
        // garante que o valor jamais será menor que zero
        int v = (int) getFloat(editText);
        v = (v > 0) ? (v - 1) : v;
        setValue(editText, v);
    }

}
