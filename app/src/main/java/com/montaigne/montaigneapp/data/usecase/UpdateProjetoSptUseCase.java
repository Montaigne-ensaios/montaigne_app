package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.HashMap;

public class UpdateProjetoSptUseCase {

    public static void updateProjetoSpt(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();

        projetoSptDao.updateProjeto(projetoSpt)
                .addOnSuccessListener(unused -> Log.i("Firebase", "Sucesso ao atualizar projeto"))
                .addOnFailureListener(e -> Log.e("Firebase", "Falha ao atualizar projeto"));
    }
}
