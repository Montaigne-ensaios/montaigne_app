package com.montaigne.montaigneapp.data.usecase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.montaigne.montaigneapp.data.dao.spt.AmostraSptDao;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAmostraSpt {
    private static AmostraSptDao amostraSptDao = new AmostraSptDao();

    public static void getProjetoSpt() {

    }

    public static void getProjetosSpt(List<AmostraSpt> listaAmostras) {
        amostraSptDao.getAmostras().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    AmostraSpt amostra = dataSnapshot.getValue(AmostraSpt.class);
                    listaAmostras.add(amostra);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase", "Erro ao ler amostras");
            }
        });
    }
}
