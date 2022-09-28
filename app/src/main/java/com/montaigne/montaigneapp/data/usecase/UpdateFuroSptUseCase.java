package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

import java.util.HashMap;

public class UpdateFuroSptUseCase {

    public static void updateFuroSpt(FuroSpt furoSpt, ProjetoSptDao projetoSptDao) {
        FuroSptDao furoSptDao = new FuroSptDao(projetoSptDao.getDbReference());

        furoSptDao.updateFuro(furoSpt)
                .addOnSuccessListener(unused -> Log.i("Firebase", "Sucesso ao atualizar furo"))
                .addOnFailureListener(e -> Log.e("Firebase", "Falha ao atualizar furo"));
    }
}
