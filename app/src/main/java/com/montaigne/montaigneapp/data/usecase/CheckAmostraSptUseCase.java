package com.montaigne.montaigneapp.data.usecase;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class CheckAmostraSptUseCase {
    public static boolean canBeSave(AmostraSpt amostraSpt) {
        boolean result = true;

        result &= amostraSpt.getGolpe1() > 0;
        result &= amostraSpt.getGolpe2() >= 0;
        result &= amostraSpt.getGolpe3() >= 0;
        result &= amostraSpt.getNspt() > 0;

        return result;
    }

    public static AmostraSpt standardize(AmostraSpt amostraSpt) {
        if (canBeSave(amostraSpt)) {
            return amostraSpt;
        }

        amostraSpt.setNspt(amostraSpt.getGolpe1());

        if (amostraSpt.getGolpe2() < 0) {
            amostraSpt.setGolpe2(0);
        } else {
            amostraSpt.setNspt(amostraSpt.getGolpe1() + amostraSpt.getGolpe2());
        }

        if (amostraSpt.getGolpe3() < 0) {
            amostraSpt.setGolpe3(0);
        } else {
            amostraSpt.setNspt(amostraSpt.getGolpe2() + amostraSpt.getGolpe3());
        }

        return amostraSpt;
    }
}
