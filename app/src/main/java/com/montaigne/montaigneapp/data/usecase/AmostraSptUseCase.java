package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.List;

public class AmostraSptUseCase {
    public static void save(int idFuro, AmostraSpt amostraSpt, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        FuroSpt furoSpt = listaDeFuros.get(idFuro);

        List<AmostraSpt> listaDeAmostras = furoSpt.getListaDeAmostras();
        listaDeAmostras.add(amostraSpt);

        furoSpt.setListaDeAmostras(listaDeAmostras);
        listaDeFuros.set(idFuro, furoSpt);

        projetoSpt.setListaDeFuros(listaDeFuros);
        ProjetoSptUseCase.update(projetoSpt);
    }

    public static void update(int idAmostra, int idFuro, AmostraSpt amostraSpt, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        FuroSpt furoSpt = listaDeFuros.get(idFuro);

        List<AmostraSpt> listaDeAmostras = furoSpt.getListaDeAmostras();
        listaDeAmostras.set(idAmostra, amostraSpt);

        furoSpt.setListaDeAmostras(listaDeAmostras);
        listaDeFuros.set(idFuro, furoSpt);

        projetoSpt.setListaDeFuros(listaDeFuros);
        ProjetoSptUseCase.update(projetoSpt);
    }

    public static void delete(int idAmostra, int idFuro, ProjetoSpt projetoSpt) {
        List<FuroSpt> listaDeFuros = projetoSpt.getListaDeFuros();
        FuroSpt furoSpt = listaDeFuros.get(idFuro);

        List<AmostraSpt> listaDeAmostras = furoSpt.getListaDeAmostras();
        listaDeAmostras.remove(idAmostra);

        furoSpt.setListaDeAmostras(listaDeAmostras);
        listaDeFuros.set(idFuro, furoSpt);

        projetoSpt.setListaDeFuros(listaDeFuros);
        ProjetoSptUseCase.update(projetoSpt);
    }
}
