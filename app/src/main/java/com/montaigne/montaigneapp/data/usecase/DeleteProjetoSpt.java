package com.montaigne.montaigneapp.data.usecase;

import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;

public class DeleteProjetoSpt {
    private static ProjetoSptDao projetoSptDao = new ProjetoSptDao();

    public static void deleteProjetoSpt(String id) {
        projetoSptDao.deleteProjetoById(id).addOnCompleteListener(event -> {

        }).addOnFailureListener(event ->  {

        });
    }
}
