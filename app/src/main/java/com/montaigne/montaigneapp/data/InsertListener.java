package com.montaigne.montaigneapp.data;

import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public interface InsertListener {
    public void onSuccess(ProjetoSpt projetoSpt);
    public void onFailure(Exception exception, ProjetoSpt projetoSpt);
}
