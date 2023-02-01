package com.montaigne.montaigneapp.data.usecase;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;

public class CheckAmostraSptUseCase {
    public static boolean canBeSave(AmostraSpt amostraSpt) {
        boolean result = true;

        result &= amostraSpt.getProfundidade() != 0;
//        result &= amostraSpt.getGolpe1() > 0;
//        result &= amostraSpt.getGolpe2() >= 0;
//        result &= amostraSpt.getGolpe3() >= 0;
//        result &= amostraSpt.getNspt() > 0;

        return result;
    }


    public static AmostraSpt standardize(AmostraSpt amostraSpt) {
        if (canBeSave(amostraSpt)) {
            return amostraSpt;
        }

        if (amostraSpt.getGolpe2() < 0) {
            amostraSpt.setGolpe2(0);
        }

        if (amostraSpt.getGolpe3() < 0) {
            amostraSpt.setGolpe3(0);
        }

        return amostraSpt;
    }
}
