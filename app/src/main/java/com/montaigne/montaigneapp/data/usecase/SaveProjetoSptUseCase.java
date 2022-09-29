package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class SaveProjetoSptUseCase {
    public static void saveProjetoSpt(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();

        projetoSptDao.insertProjeto(projetoSpt).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao salvar amostra");
        }).addOnFailureListener(exception -> {
            Log.e("Erro ao salvar", "Erro ao salvar projeto de SPT");
            Log.e("Firebase", "Falha ao salvar projeto");
        });
    }
}
