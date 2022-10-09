package com.montaigne.montaigneapp.activity.home;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.AbstractActivity;
import com.montaigne.montaigneapp.data.usecase.AmostraSptUseCase;
import com.montaigne.montaigneapp.data.usecase.FuroSptUseCase;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.Coordenada;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeActivity extends AbstractActivity {
    protected FloatingActionButton newProjectFab;
    protected RecyclerView recyclerProjetoCategorias, recyclerProjetosSalvos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeViews();

        HomeVM viewModel = new ViewModelProvider(this).get(HomeVM.class);

        viewModel.initializeProjetosSalvosAdapter(recyclerProjetosSalvos);
        viewModel.initializeProjetoCategoriaAdapter(recyclerProjetoCategorias);
        newProjectFab.setOnClickListener(viewModel::newProjectFabListener);
        viewModel.refreshProjetosSalvos();

        // --------- Amostras ----------
        List<AmostraSpt> samplesList = new ArrayList();
        AmostraSpt sample = new AmostraSpt();
        sample.setGolpe1(10);
        sample.setGolpe2(20);
        sample.setGolpe3(15);
        sample.setNspt(sample.getGolpe2(), sample.getGolpe3());
        samplesList.add(sample);

        AmostraSpt otherSample = new AmostraSpt();
        otherSample.setGolpe1(10);
        otherSample.setGolpe2(24);
        otherSample.setGolpe3(23);
        otherSample.setNspt(otherSample.getGolpe2(), otherSample.getGolpe3());
        samplesList.add(otherSample);

        AmostraSpt oS1 = new AmostraSpt();
        oS1.setGolpe1(7);
        oS1.setGolpe2(7);
        oS1.setGolpe3(7);
        oS1.setNspt(oS1.getGolpe2(), oS1.getGolpe3());

        // --------- Furos ----------
        List<FuroSpt> holesList = new ArrayList();
        FuroSpt hole = new FuroSpt();
        hole.setCodigo("SP-01");
        hole.setNivelDAgua(20);
        hole.setNivelDoFuro(20);
        hole.setDataInicio(new Date());
        hole.setDataFim(new Date());
        hole.setListaDeAmostras(samplesList);

        FuroSpt otherHole = new FuroSpt();
        otherHole.setCodigo("SP-02");
        otherHole.setNivelDAgua(40);
        otherHole.setNivelDoFuro(40);
        otherHole.setDataInicio(new Date());
        otherHole.setDataFim(new Date());
        otherHole.setListaDeAmostras(samplesList);

        FuroSpt oHole1 = new FuroSpt();
        oHole1.setCodigo("SP-55");
        oHole1.setNivelDAgua(10);
        oHole1.setNivelDoFuro(40);
        oHole1.setDataInicio(new Date());
        oHole1.setDataFim(new Date());
        oHole1.setListaDeAmostras(samplesList);

        holesList.add(hole);
        holesList.add(otherHole);
        holesList.add(oHole1);

        // --------- Projeto ----------
        ProjetoSpt projeto = new ProjetoSpt();
        projeto.setNome("Meu projeto");
        projeto.setCliente("Rodrigus");
        projeto.setEmpresa("Construtora ABCD");
        projeto.setTecnico("Icarus");
        projeto.setNumeroDeTelefone("12345-6789");
        projeto.setDataInicio(new Date().toString());
        projeto.setCoordenadas(new Coordenada(10, 10));
        projeto.setListaDeFuros(holesList);

        // projeto.setId("");
        ProjetoSptUseCase.save(projeto);
    }

    @Override
    protected void initializeViews() {
        newProjectFab = findViewById(R.id.fabNewProjeto);
        recyclerProjetoCategorias = findViewById(R.id.recyclerCategorias);
        recyclerProjetosSalvos = findViewById(R.id.recyclerProjetosSalvos);
    }
}