package com.montaigne.montaigneapp.data.dao;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.montaigne.montaigneapp.data.InsertListener;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executor;

public class ProjetoSptUsecaseTest implements InsertListener {
    private Task<Void> sucesso;
    private Task<Void> falha;
    private ProjetoSpt projetoSpt;
    @Mock
    private FirebaseDatabase firebaseDatabase;
    private ProjetoSptDao projetoSptDao;
    private ProjetoSptUseCase projetoSptUseCase;

    private static final int SUCESSO = 1;
    private static final int FALHA = -1;
    private static final int INDEFINIDO = 0;

    private int insertionResult = INDEFINIDO;

    @Before
    public void setUp() {
        firebaseDatabase = Mockito.mock(FirebaseDatabase.class);
        projetoSptUseCase = Mockito.mock(ProjetoSptUseCase.class);
        projetoSptDao = Mockito.mock(ProjetoSptDao.class);
        sucesso = new Task<Void>() {

            @Override
            public Task<Void> addOnCompleteListener(Executor executor, OnCompleteListener<Void> onCompleteListener) {
                onCompleteListener.onComplete(sucesso);
                return sucesso;
            }
            @NonNull
            @Override
            public Task<Void> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
                return null;
            }

            @NonNull
            @Override
            public Task<Void> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
                return null;
            }

            @NonNull
            @Override
            public Task<Void> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
                return null;
            }

            @NonNull
            @Override
            public Task<Void> addOnSuccessListener(@NonNull OnSuccessListener<? super Void> onSuccessListener) {
                return null;
            }

            @NonNull
            @Override
            public Task<Void> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super Void> onSuccessListener) {
                return null;
            }

            @NonNull
            @Override
            public Task<Void> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super Void> onSuccessListener) {
                return null;
            }

            @Nullable
            @Override
            public Exception getException() {
                return null;
            }

            @Override
            public Void getResult() {
                return null;
            }

            @Override
            public <X extends Throwable> Void getResult(@NonNull Class<X> aClass) throws X {
                return null;
            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public boolean isComplete() {
                return true;
            }

            @Override
            public boolean isSuccessful() {
                return true;
            }
        };

        falha = new Task<Void>() {

            @Override
            public Task<Void> addOnCompleteListener(Executor executor, OnCompleteListener<Void> onCompleteListener) {
                onCompleteListener.onComplete(falha);
                return falha;
            }
            @NonNull
            @Override
            public Task<Void> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
                return null;
            }

            @NonNull
            @Override
            public Task<Void> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
                return null;
            }

            @NonNull
            @Override
            public Task<Void> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
                return null;
            }

            @NonNull
            @Override
            public Task<Void> addOnSuccessListener(@NonNull OnSuccessListener<? super Void> onSuccessListener) {
                return null;
            }

            @NonNull
            @Override
            public Task<Void> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super Void> onSuccessListener) {
                return null;
            }

            @NonNull
            @Override
            public Task<Void> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super Void> onSuccessListener) {
                return null;
            }

            @Nullable
            @Override
            public Exception getException() {
                return null;
            }

            @Override
            public Void getResult() {
                return null;
            }

            @Override
            public <X extends Throwable> Void getResult(@NonNull Class<X> aClass) throws X {
                return null;
            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public boolean isComplete() {
                return false;
            }

            @Override
            public boolean isSuccessful() {
                return false;
            }
        };
    }

    @Test
    private void insercaoTeste() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        List<AmostraSpt> listaDeAmostras = new ArrayList<AmostraSpt>();
        listaDeAmostras.add(new AmostraSpt("1", "1", 1, 2, 3, 4));
        FuroSpt furoSpt = new FuroSpt("1", "1", "1", Float.parseFloat("1"), Float.parseFloat("1"), today.getTime(), today.getTime(), listaDeAmostras);

        List<FuroSpt> listaDeFuros = new ArrayList<FuroSpt>();
        listaDeFuros.add(furoSpt);
        Coordenada coordenada = new Coordenada();

        projetoSpt = new ProjetoSpt("1", "Marcelo", "Marcelo", "Marcelo", "Marcelo", "Marcelo", "Marcelo", coordenada, 1, listaDeFuros);

        Mockito.when(projetoSptDao.insertProjeto(projetoSpt)).thenReturn(sucesso);
        ProjetoSptUseCase.save(projetoSpt, this);
        assert(insertionResult == SUCESSO);
    }

    @Override
    public void onSuccess(ProjetoSpt projetoSpt) {
        insertionResult = SUCESSO;
    }

    @Override
    public void onFailure(Exception exception, ProjetoSpt projetoSpt) {
        insertionResult = FALHA;
    }
}
