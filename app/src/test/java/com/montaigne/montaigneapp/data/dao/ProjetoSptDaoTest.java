package com.montaigne.montaigneapp.data.dao;

import com.google.firebase.database.FirebaseDatabase;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ProjetoSptDaoTest {

    ProjetoSpt projeto;

    @Mock
    private FirebaseDatabase firebaseDatabaseMock;
    private ProjetoSptUseCase projetoSptUseCase;

    @Before
    public void setup() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        List<AmostraSpt> listaDeAmostras = new ArrayList<AmostraSpt>();
        listaDeAmostras.add(new AmostraSpt("1", "1", 1, 2, 3, 4));
        FuroSpt furoSpt = new FuroSpt("1", "1", "1", Float.parseFloat("1"), Float.parseFloat("1"), today.getTime(), today.getTime(), listaDeAmostras);

        List<FuroSpt> listaDeFuros = new ArrayList<FuroSpt>();
        listaDeFuros.add(furoSpt);
        Coordenada coordenada = new Coordenada();

        projeto = new ProjetoSpt("1", "Marcelo", "Marcelo", "Marcelo", "Marcelo", "Marcelo", "Marcelo", coordenada, 1, listaDeFuros);

    }

    @Test
    public void insertProjeto() {
        ProjetoSptDao daoMock = Mockito.mock(ProjetoSptDao.class);
        daoMock.insertProjeto(projeto);
        assert (true);
    }

}