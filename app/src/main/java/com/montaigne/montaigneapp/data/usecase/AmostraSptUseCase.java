package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class AmostraSptUseCase {
    public static void save(AmostraSpt amostraSpt, FuroSpt furoSpt, ProjetoSpt projetoSpt) {
        AmostraSptDao amostraSptDao = new AmostraSptDao(furoSpt, projetoSpt);

        amostraSptDao.insertAmostra(amostraSpt).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao salvar amostra");
        }).addOnFailureListener(exception -> {
            Log.e("Erro ao salvar", "Erro ao salvar amostra de SPT");
            Log.e("Firebase", "Falha ao salvar amostra");
        });
    }

    public static void update(AmostraSpt amostraSpt, FuroSpt furoSpt, ProjetoSpt projetoSpt) {
        AmostraSptDao amostraSptDao = new AmostraSptDao(furoSpt, projetoSpt);

        amostraSptDao.updateAmostra(amostraSpt)
                .addOnSuccessListener(unused -> Log.i("Firebase", "Sucesso ao atualizar amostra"))
                .addOnFailureListener(e -> Log.e("Firebase", "Falha ao atualizar amostra"));
    }

    public static void delete(AmostraSpt amostraSpt, FuroSpt furoSpt, ProjetoSpt projetoSpt) {
        AmostraSptDao amostraSptDao = new AmostraSptDao(furoSpt, projetoSpt);

        amostraSptDao.deleteAmostraById(amostraSpt.getId()).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar amostra");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Falha ao deletar amostra");
        });
    }
}
