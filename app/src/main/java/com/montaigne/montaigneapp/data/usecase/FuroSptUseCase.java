package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class FuroSptUseCase {
    public static void save(FuroSpt furoSpt, ProjetoSpt projetoSpt) {
        FuroSptDao furoSptDao = new FuroSptDao(projetoSpt);

        furoSptDao.insertFuro(furoSpt).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao salvar furo");
        }).addOnFailureListener(exception -> {
            Log.e("Erro ao salvar", "Erro ao salvar furo de SPT");
            Log.e("Firebase", "Falha ao salvar furo");
        });
    }

    public static void update(FuroSpt furoSpt, ProjetoSpt projetoSpt) {
        FuroSptDao furoSptDao = new FuroSptDao(projetoSpt);

        furoSptDao.updateFuro(furoSpt)
                .addOnSuccessListener(unused -> Log.i("Firebase", "Sucesso ao atualizar furo"))
                .addOnFailureListener(e -> Log.e("Firebase", "Falha ao atualizar furo"));
    }

    public static void delete(FuroSpt furoSpt, ProjetoSpt projetoSpt) {
        FuroSptDao furoSptDao = new FuroSptDao(projetoSpt);

        furoSptDao.deleteFuroById(furoSpt.getId()).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar furo");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Falha ao deletar furo");
        });
    }


}
