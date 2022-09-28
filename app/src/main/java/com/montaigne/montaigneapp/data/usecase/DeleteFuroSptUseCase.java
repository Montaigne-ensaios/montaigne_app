package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

public class DeleteFuroSptUseCase {
    public static void deleteFuroSpt(FuroSpt furoSpt, ProjetoSptDao projetoSptDao) {
        FuroSptDao furoSptDao = new FuroSptDao(projetoSptDao.getDbReference());

        furoSptDao.deleteFuroById(furoSpt.getId()).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar furo");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Falha ao deletar furo");
        });
    }
}
