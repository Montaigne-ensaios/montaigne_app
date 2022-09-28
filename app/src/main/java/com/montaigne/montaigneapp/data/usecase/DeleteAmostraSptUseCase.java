package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

public class DeleteAmostraSptUseCase {

    public static void deleteAmostraSpt(AmostraSpt amostraSpt, FuroSptDao furoSptDao) {
        AmostraSptDao amostraSptDao = new AmostraSptDao(furoSptDao.getDbReference());

        amostraSptDao.deleteAmostraById(amostraSpt.getId()).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar amostra");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Falha ao deletar amostra");
        });
    }
}
