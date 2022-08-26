package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;

public class DeleteAmostraSpt {
    private static boolean result = false;
    private static AmostraSptDao amostraSptDao = new AmostraSptDao();

    public static boolean deleteAmostraSpt(String id) {
        result = false;

        amostraSptDao.deleteAmostraById(id).addOnCompleteListener(task -> {
            result = true;
        }).addOnFailureListener(exception ->  {
            Log.e("Erro ao salvar", "Erro ao deletar amostra de SPT");
        });

        return result;
    }
}
