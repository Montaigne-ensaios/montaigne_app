package com.montaigne.montaigneapp.data.usecase;

import com.google.android.gms.tasks.Task;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.List;

public class FuroSptUseCase {
    public static Task<Void> save(FuroSpt furoSpt, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        listaDeFuros.add(furoSpt);

        projetoSpt.setListaDeFuros(listaDeFuros);
        return ProjetoSptUseCase.update(projetoSpt);
    }

    public static Task<Void> update(int idFuro, FuroSpt furoSpt, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        listaDeFuros.set(idFuro, furoSpt);

        projetoSpt.setListaDeFuros(listaDeFuros);
        return ProjetoSptUseCase.update(projetoSpt);
    }

    public static Task<Void> delete(int idFuro, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        listaDeFuros.remove(idFuro);

        projetoSpt.setListaDeFuros(listaDeFuros);
        return ProjetoSptUseCase.update(projetoSpt);
    }


}
