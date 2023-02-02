package com.montaigne.montaigneapp.ui.spt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.navigation.fragment.NavHostFragment;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.AbstractProjectViewModel;
import com.montaigne.montaigneapp.ui.spt.carimboProjeto.CarimboProjetoFragment;
import com.montaigne.montaigneapp.ui.home.HomeActivity;
import com.montaigne.montaigneapp.ui.spt.carimboEnsaio.CarimboEnsaioFragment;
import com.montaigne.montaigneapp.ui.spt.ensaio.EnsaioFragment;
import com.montaigne.montaigneapp.ui.spt.furo.FuroFragment;
import com.montaigne.montaigneapp.ui.spt.projeto.ProjetoFragment;

import java.util.ArrayList;
import java.util.Objects;

public class SptVM extends AbstractProjectViewModel <ProjetoSpt> {
    private final String TAG = "SptActivity";

    private ProjetoSpt projeto;
    private boolean isProjetoNew = false;
    // variável que define se o projeto deve ser salvo ou deve-se criar um novo

    @Override
    protected void handleNavigation(FragmentManager manager) {
        Fragment f = getCurrentFragment(manager);

        f.onPause();  // garante que os fragmentos atualizam o projeto

        if (f instanceof ProjetoFragment) {
            Log.v(TAG, "action_edit_Carimbo");
            navigateFragments(R.id.action_edit_Carimbo, manager); //

        } else if (f instanceof FuroFragment) {
            Log.v(TAG, "action_edit_CarimboEnsaio");
            navigateFragments(R.id.action_edit_CarimboEnsaio, manager);

        } else if (f instanceof CarimboProjetoFragment) {
            Log.v(TAG, "action_new_Ensaio");
            Bundle b = new Bundle();
            b.putInt("furoId", projeto.getListaDeFuros().size());
            navigateFragments(R.id.action_new_Ensaio, manager, b);

        } else if (f instanceof CarimboEnsaioFragment) {
            Log.v(TAG, "action_execute_Ensaio");
            Bundle b = new Bundle();
            int furoId = ((CarimboEnsaioFragment) f).getFuroId();
            b.putInt("furoId", furoId);
            b.putInt("amostraId", projeto.getListaDeFuros().get(furoId).getListaDeAmostras().size());
            navigateFragments(R.id.action_execute_Ensaio, manager, b);

        } else if (f instanceof EnsaioFragment) {
            Log.v(TAG, "action_next_Amostra");
            Bundle b = new Bundle();
            int furoId = ((EnsaioFragment) f).getFuroId();
            b.putInt("furoId", furoId);
            b.putInt("amostraId", projeto.getListaDeFuros().get(furoId).getListaDeAmostras().size());
            navigateFragments(R.id.action_next_Amostra, manager, b);

        } else {
            Log.v(TAG, "none action");
        }
    }

    @Override
    protected void setUp(Projeto projeto, FragmentManager manager) {
        this.projeto = (ProjetoSpt) projeto;
        if (projeto.getNome() == null) {
            isProjetoNew = true;
            ((ProjetoSpt) projeto).setListaDeFuros(new ArrayList<>());
            navigateFragments(R.id.action_edit_Carimbo, manager);
        }
    }

    @Override
    public void updateProjeto(ProjetoSpt projeto) {
        this.projeto = projeto;
        if (isProjetoNew) {
            ProjetoSptUseCase.save(projeto);
            isProjetoNew = false;
        } else {
            ProjetoSptUseCase.update(projeto);
        }
    }

    public ProjetoSpt getProjeto() {
        return projeto;
    }
}
