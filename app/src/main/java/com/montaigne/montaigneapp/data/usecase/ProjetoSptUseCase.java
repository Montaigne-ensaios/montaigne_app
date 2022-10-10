package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.montaigne.montaigneapp.data.ModelHolder;
import com.montaigne.montaigneapp.data.dao.spt.ProjetoSptDao;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

public class ProjetoSptUseCase {
    public static void save(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();

        projetoSptDao.insertProjeto(projetoSpt).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao salvar projeto de SPT");
        }).addOnFailureListener(exception -> {
            Log.e("Erro ao salvar", "Erro ao salvar projeto de SPT");
            Log.e("Firebase", "Falha ao salvar projeto");
        });
    }

    public static void update(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();

        projetoSptDao.updateProjeto(projetoSpt)
                .addOnSuccessListener(unused -> Log.i("Firebase", "Sucesso ao atualizar projeto"))
                .addOnFailureListener(e -> Log.e("Firebase", "Falha ao atualizar projeto"));
    }

    public static void delete(ProjetoSpt projetoSpt) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();

        projetoSptDao.deleteProjetoById(projetoSpt.getId()).addOnCompleteListener(task -> {
            Log.i("Firebase", "Sucesso ao deletar projeto");
        }).addOnFailureListener(exception ->  {
            Log.e("Firebase", "Falha ao deletar projeto");
        });
    }

    public static void read(ModelHolder<Projeto> holder) {
        ProjetoSptDao projetoSptDao = new ProjetoSptDao();

        try {
            projetoSptDao
                    .getDbReference()
                    .getDatabase()
                    .setPersistenceEnabled(true);
        } catch (Exception e) {
            Log.e("Firebase", "Falha ao configurar persistência de projetos");
        }

        projetoSptDao.getProjetos().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ProjetoSpt projetoSpt = dataSnapshot.getValue(ProjetoSpt.class);
                    holder.addModel(projetoSpt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
