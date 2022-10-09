package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.List;

public class FuroSptUseCase {
    public static void save(FuroSpt furoSpt, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        listaDeFuros.add(furoSpt);

        Log.i("Lista", String.valueOf(listaDeFuros.size()));

        projetoSpt.setListaDeFuros(listaDeFuros);
        ProjetoSptUseCase.update(projetoSpt);
    }

    public static void update(int idFuro, FuroSpt furoSpt, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        listaDeFuros.set(idFuro, furoSpt);

        projetoSpt.setListaDeFuros(listaDeFuros);
        ProjetoSptUseCase.update(projetoSpt);
    }

    public static void delete(int idFuro, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        listaDeFuros.remove(idFuro);

        projetoSpt.setListaDeFuros(listaDeFuros);
        ProjetoSptUseCase.update(projetoSpt);
    }
}
