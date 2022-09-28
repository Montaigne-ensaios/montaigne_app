package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class DeleteProjetoSptUseCase {

    public static void deleteProjetoSpt(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();
        projetoSptDao.deleteProjetoById(projetoSpt.getId()).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar projeto");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Falha ao deletar projeto");
        });
    }
}
