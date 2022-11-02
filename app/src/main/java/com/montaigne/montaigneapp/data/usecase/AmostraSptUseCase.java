package com.montaigne.montaigneapp.data.usecase;

import com.google.android.gms.tasks.Task;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.List;

public class AmostraSptUseCase {
    public static Task<Void> save(int idFuro, AmostraSpt amostraSpt, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        FuroSpt furoSpt = listaDeFuros.get(idFuro);

        List<AmostraSpt> listaDeAmostras = furoSpt.getListaDeAmostras();
        listaDeAmostras.add(amostraSpt);

        furoSpt.setListaDeAmostras(listaDeAmostras);
        listaDeFuros.set(idFuro, furoSpt);

        projetoSpt.setListaDeFuros(listaDeFuros);
        return ProjetoSptUseCase.update(projetoSpt);
    }

    public static Task<Void> update(int idAmostra, int idFuro, AmostraSpt amostraSpt, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        FuroSpt furoSpt = listaDeFuros.get(idFuro);

        List<AmostraSpt> listaDeAmostras = furoSpt.getListaDeAmostras();
        listaDeAmostras.set(idAmostra, amostraSpt);

        furoSpt.setListaDeAmostras(listaDeAmostras);
        listaDeFuros.set(idFuro, furoSpt);

        projetoSpt.setListaDeFuros(listaDeFuros);
        return ProjetoSptUseCase.update(projetoSpt);
    }

    public static Task<Void> delete(int idAmostra, int idFuro, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        FuroSpt furoSpt = listaDeFuros.get(idFuro);

        List<AmostraSpt> listaDeAmostras = furoSpt.getListaDeAmostras();
        listaDeAmostras.remove(idAmostra);

        furoSpt.setListaDeAmostras(listaDeAmostras);
        listaDeFuros.set(idFuro, furoSpt);

        projetoSpt.setListaDeFuros(listaDeFuros);
        return ProjetoSptUseCase.update(projetoSpt);
    }
}
