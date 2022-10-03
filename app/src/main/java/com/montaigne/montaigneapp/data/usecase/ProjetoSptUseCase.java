package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class ProjetoSptUseCase {
    public static void save(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();

        projetoSptDao.insertProjeto(projetoSpt).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao salvar amostra");
        }).addOnFailureListener(exception -> {
            Log.e("Erro ao salvar", "Erro ao salvar projeto de SPT");
            Log.e("Firebase", "Falha ao salvar projeto");
        });
    }

    public static void update(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();

        projetoSptDao.updateProjeto(projetoSpt)
                .addOnSuccessListener(unused -> Log.i("Firebase", "Sucesso ao atualizar projeto"))
                .addOnFailureListener(e -> Log.e("Firebase", "Falha ao atualizar projeto"));
    }

    public static void delete(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();

        projetoSptDao.deleteProjetoById(projetoSpt.getId()).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar projeto");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Falha ao deletar projeto");
        });
    }
}
