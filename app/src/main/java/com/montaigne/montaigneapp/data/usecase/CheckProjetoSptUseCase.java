package com.montaigne.montaigneapp.data.usecase;

import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class CheckProjetoSptUseCase {
    public static boolean canBeSave(ProjetoSpt projetoSpt) {
        boolean result = true;

        result &= !(projetoSpt.getNome().isEmpty());
        result &= !(projetoSpt.getCliente().isEmpty());
        result &= !(projetoSpt.getEmpresa().isEmpty());
        result &= !(projetoSpt.getTecnico().isEmpty());
        // result &= !(projetoSpt.getPhoneNumber().isEmpty());

        return result;
    }
}
