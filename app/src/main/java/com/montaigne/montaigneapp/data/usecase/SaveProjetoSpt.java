package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class SaveProjetoSpt {
    private static boolean result = false;
    private static ProjetoSptDao projetoSptDao = new ProjetoSptDao();

    public static boolean saveProjetoSpt(ProjetoSpt projetoSpt) {
        result = false;

        projetoSptDao.insertProjeto(projetoSpt).addOnCompleteListener(task -> {
            result = true;
        }).addOnFailureListener(exception -> {
            Log.e("Erro ao salvar", "Erro ao salvar projeto de SPT");
        });

        return result;
    }

    public static void updateProjetoSpt() {

    }
}
