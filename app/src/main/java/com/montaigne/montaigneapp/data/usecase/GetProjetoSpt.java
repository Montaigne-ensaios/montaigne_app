package com.montaigne.montaigneapp.data.usecase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;
import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.HashMap;
import java.util.Map;

public class GetProjetoSpt {
    public static ProjetoSptDao projetoSptDao = new ProjetoSptDao();

    public static void getProjetoSpt() {

    }

    public static Map<String, ProjetoSpt> getProjetosSpt() {
        Map<String, ProjetoSpt> projetos = new HashMap<>();
        Query projetoQuery = projetoSptDao.getProjects();

        projetoQuery.get().addOnCompleteListener(dataSnapshotTask -> {
            for (DataSnapshot child : dataSnapshotTask.getResult().getChildren()) {
                ProjetoSpt projetoSpt = child.getValue(ProjetoSpt.class);
                projetos.put(child.getKey(), projetoSpt);
            }
        });

        return projetos;
    }
}
