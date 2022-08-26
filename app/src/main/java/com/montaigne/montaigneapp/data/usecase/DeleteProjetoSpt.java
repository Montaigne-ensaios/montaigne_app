package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;

public class DeleteProjetoSpt {
    private static boolean result = false;
    private static ProjetoSptDao projetoSptDao = new ProjetoSptDao();

    public static boolean deleteProjetoSpt(String id) {
        result = false;

        projetoSptDao.deleteProjetoById(id).addOnCompleteListener(task -> {
            result = true;
        }).addOnFailureListener(exception ->  {
            Log.e("Erro ao deletar", "Erro ao deletar projeto de SPT");
        });

        return result;
    }
}
