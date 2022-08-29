package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class SaveProjetoSpt {
    private static ProjetoSptDao projetoSptDao = new ProjetoSptDao();

    public void saveProjetoSpt(ProjetoSpt projetoSpt) {
        projetoSptDao.insertProjeto(projetoSpt).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao salvar projeto");
        }).addOnFailureListener(exception -> {
            Log.e("Firebase", "Erro ao salvar projeto");
        });
    }
}
