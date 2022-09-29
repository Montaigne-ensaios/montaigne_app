package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

public class SaveFuroSptUseCase {
    public static void saveFuroSpt(FuroSpt furoSpt, ProjetoSptDao projetoSptDao) {
        FuroSptDao furoSptDao = new FuroSptDao(projetoSptDao.getDbReference());

        furoSptDao.insertFuro(furoSpt).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao salvar furo");
        }).addOnFailureListener(exception -> {
            Log.e("Erro ao salvar", "Erro ao salvar furo de SPT");
            Log.e("Firebase", "Falha ao salvar furo");
        });
    }
}
