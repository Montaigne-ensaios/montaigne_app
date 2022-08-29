package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;

public class DeleteFuroSpt {
    private static FuroSptDao furoSptDao = new FuroSptDao();

    public static void deleteFuroSpt(String id) {
        furoSptDao.deleteFuroById(id).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar furo");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Erro ao deletar furo");
        });
    }
}
