package com.montaigne.montaigneapp.data.usecase;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.montaigne.montaigneapp.data.dao.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class ProjetoSptUseCase {
    public static DatabaseReference getDatabase() {
        ProjetoSptDao projetoSptDao = ProjetoSptDao.getInstance();
        return projetoSptDao.getDbReference();
    }

    public static Task<Void> save(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = ProjetoSptDao.getInstance();
        return projetoSptDao.insertProjeto(projetoSpt);
    }

    public static Task<Void> update(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = ProjetoSptDao.getInstance();
        return projetoSptDao.updateProjeto(projetoSpt);
    }

    public static Task<Void> delete(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = ProjetoSptDao.getInstance();
        return  projetoSptDao.deleteProjetoById(projetoSpt.getId());
    }

    public static Task<DataSnapshot> read() {
        ProjetoSptDao projetoSptDao = ProjetoSptDao.getInstance();
        return projetoSptDao.getProjetos();
    }
}
