package com.montaigne.montaigneapp.data.usecase;

import com.montaigne.montaigneapp.model.spt.FuroSpt;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckFuroSptUseCase {
    public static boolean canBeSave(FuroSpt furoSpt) {
        boolean result = true;

        result &= !(furoSpt.getCodigo().isEmpty());
        result &= !(furoSpt.getDataInicio() == null);

        return result;
    }

    public static FuroSpt standardize(FuroSpt furoSpt) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

        if (canBeSave(furoSpt)) {
            return furoSpt;
        }

        if (furoSpt.getDataInicio() == null) {
            furoSpt.setDataInicio(new Date());
        }

        if (furoSpt.getCodigo().isEmpty()) {
            String code = sdf.format(furoSpt.getDataInicio());
            furoSpt.setCodigo(code);
        }

        return furoSpt;
    }
}
