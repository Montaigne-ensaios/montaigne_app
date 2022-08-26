package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;

public class DeleteFuroSpt {
    private static boolean result = false;
    private static FuroSptDao furoSptDao = new FuroSptDao();

    public static boolean deleteFuroSpt(String id) {
        result = false;

        furoSptDao.deleteFuroById(id).addOnCompleteListener(task -> {
            result = true;
        }).addOnFailureListener(exception ->  {
            Log.e("Erro ao salvar", "Erro ao deletar furo de SPT");
        });

        return result;
    }
}
