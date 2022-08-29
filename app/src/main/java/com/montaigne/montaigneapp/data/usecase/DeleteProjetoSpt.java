package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;

public class DeleteProjetoSpt {
    private static ProjetoSptDao projetoSptDao = new ProjetoSptDao();

    public static void deleteProjetoSpt(String id) {
        projetoSptDao.deleteProjetoById(id).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar projeto");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Erro ao deletar projeto");
        });
    }
}
