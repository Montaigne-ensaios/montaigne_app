package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

public class SaveAmostraSpt {
    private static boolean result = false;
    private static AmostraSptDao amostraSptDao = new AmostraSptDao();

    public static boolean saveAmostraSpt(AmostraSpt amostraSpt) {
        result = false;

        amostraSptDao.insertAmostra(amostraSpt).addOnCompleteListener(task -> {
            result = true;
        }).addOnFailureListener(exception -> {
            Log.e("Erro ao salvar", "Erro ao salvar amostra de SPT");
        });

        return result;
    }

    public static void updateAmostraSpt() {
        
    }
}
