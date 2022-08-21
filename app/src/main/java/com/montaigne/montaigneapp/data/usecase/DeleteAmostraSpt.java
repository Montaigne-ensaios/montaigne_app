package com.montaigne.montaigneapp.data.usecase;

import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;

public class DeleteAmostraSpt {
    private static AmostraSptDao amostraSptDao = new AmostraSptDao();

    public static void deleteAmostraSpt(String id) {
        amostraSptDao.deleteAmostraById(id).addOnCompleteListener(event -> {

        }).addOnFailureListener(event ->  {

        });
    }
}
