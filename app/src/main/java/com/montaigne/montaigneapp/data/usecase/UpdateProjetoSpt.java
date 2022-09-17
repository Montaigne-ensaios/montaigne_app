package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.HashMap;

public class UpdateProjetoSpt {
    public UpdateProjetoSpt() {
    }

    public void updateProjetoSpt(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();
        HashMap<String, Object> hashMapProjeto = new HashMap<>();
        hashMapProjeto.put("nome", projetoSpt.getNome());
        hashMapProjeto.put("cliente", projetoSpt.getCliente());
        hashMapProjeto.put("empresa", projetoSpt.getEmpresa());
        hashMapProjeto.put("tecnico", projetoSpt.getTecnico());
        hashMapProjeto.put("numeroDeTelefone", projetoSpt.getNumeroDeTelefone());
        hashMapProjeto.put("numeroDoFuro", projetoSpt.getNumeroDoFuro());
        hashMapProjeto.put("listaDeFuros", projetoSpt.getListaDeFuros());
        projetoSptDao.updateProjeto(projetoSpt.getId(), hashMapProjeto)
                .addOnSuccessListener(unused -> Log.i("Firebase", "Sucesso ao atualizar projeto"))
                .addOnFailureListener(e -> Log.e("Firebase", "Falha ao atualizar projeto"));
    }
}
