package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.montaigne.montaigneapp.data.ModelHolder;
import com.montaigne.montaigneapp.data.dao.spt.FuroSptDao;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.List;

public class FuroSptUseCase {
    public static void saveListaDeFuros(ProjetoSpt projetoSpt, List<FuroSpt> listaDeFuros) {
        FuroSptDao furoSptDao = new FuroSptDao(projetoSpt);

        furoSptDao.insertListaDeFuros(listaDeFuros).addOnSuccessListener(success -> {
            Log.i("Firebase", "Sucesso ao salvar lista de furos");
        }).addOnFailureListener(failure -> {
            Log.e("Firebase", "Falha ao salvar lista de furos");
        });
    }

    public static void updateListaDeFuros(ProjetoSpt projetoSpt, List<FuroSpt> listaDeFuros) {
        FuroSptDao furoSptDao = new FuroSptDao(projetoSpt);

        furoSptDao.updateListaDeFuros(listaDeFuros).addOnSuccessListener(success -> {
            Log.i("Firebase", "Sucesso ao atualizar lista de furos");
        }).addOnFailureListener(failure -> {
            Log.e("Firebase", "Falha ao atualizar lista de furos");
        });
    }

    public static void readListaDeFuros(ProjetoSpt projetoSpt, ModelHolder<FuroSpt> holder) {
        FuroSptDao furoSptDao = new FuroSptDao(projetoSpt);

        furoSptDao.readListaDeFuros().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshotFuro : snapshot.getChildren()) {
                    FuroSpt furoSpt = dataSnapshotFuro.getValue(FuroSpt.class);
                    holder.addModel(furoSpt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public static void deleteListaDeFuros(ProjetoSpt projetoSpt) {
        FuroSptDao furoSptDao = new FuroSptDao(projetoSpt);

        furoSptDao.deleteListaDeFuros().addOnSuccessListener(success -> {
            Log.i("Firebase", "Sucesso ao deletar lista de furos");
        }).addOnFailureListener(failure -> {
            Log.e("Firebase", "Falha ao deletar lista de furos");
        });
    }
}
