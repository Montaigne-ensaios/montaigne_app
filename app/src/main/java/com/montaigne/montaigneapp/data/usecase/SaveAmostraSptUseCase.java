package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

public class SaveAmostraSptUseCase {
    public static void saveAmostraSpt(AmostraSpt amostraSpt, FuroSptDao furoSptDao) {
        AmostraSptDao amostraSptDao = new AmostraSptDao(furoSptDao.getDbReference());

        amostraSptDao.insertAmostra(amostraSpt).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao salvar amostra");
        }).addOnFailureListener(exception -> {
            Log.e("Erro ao salvar", "Erro ao salvar amostra de SPT");
            Log.e("Firebase", "Falha ao salvar amostra");
        });
    }
}
