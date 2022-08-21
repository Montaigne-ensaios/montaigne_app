package com.montaigne.montaigneapp.data.usecase;

import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;

public class DeleteFuroSpt {
    private static FuroSptDao furoSptDao = new FuroSptDao();

    public static void deleteFuroSpt(String id) {
        furoSptDao.deleteFuroById(id).addOnCompleteListener(task -> {

        }).addOnFailureListener(exception ->  {

        });
    }
}
