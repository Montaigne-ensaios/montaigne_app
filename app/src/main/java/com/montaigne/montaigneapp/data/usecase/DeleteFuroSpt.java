package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

public class DeleteFuroSpt {

    public static void deleteFuroSpt(FuroSpt furoSpt) {
        FuroSptDao furoSptDao = new FuroSptDao(furoSpt.getIdProjeto());
        furoSptDao.deleteFuroById(furoSpt.getId()).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar furo");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Falha ao deletar furo");
        });
    }
}
