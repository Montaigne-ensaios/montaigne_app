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
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.spt.carimboProjeto.CarimboProjetoFragment;
import com.montaigne.montaigneapp.ui.home.HomeActivity;
import com.montaigne.montaigneapp.ui.spt.carimboEnsaio.CarimboEnsaioFragment;
import com.montaigne.montaigneapp.ui.spt.ensaio.EnsaioFragment;
import com.montaigne.montaigneapp.ui.spt.furo.FuroFragment;
import com.montaigne.montaigneapp.ui.spt.projeto.ProjetoFragment;

import java.util.ArrayList;
import java.util.Objects;

public class SptVM extends ViewModel {
    private final String TAG = "SptActivity";

    private ProjetoSpt projeto;
    private boolean isProjetoNew = false;
    // variável que define se o projeto deve ser salvo ou deve-se criar um novo

    protected void handleNavigation(FragmentManager manager) {
        Fragment f = Objects.requireNonNull(
                manager.getPrimaryNavigationFragment()
        ).getChildFragmentManager().getFragments().get(0);  // fragmento exibido

//        f.onPause();  // garante que os fragmentos atualizam o projeto
//         fixme: isto está causando duplicação de furos e amostras,
        //  é preciso encontrar uma forma para que não crie furos e amostras duas vezes

        if (f instanceof ProjetoFragment) {
            navigateFragments(R.id.action_edit_Carimbo, manager);
            Log.v(TAG, "action_edit_Carimbo");
        } else if (f instanceof FuroFragment) {
            navigateFragments(R.id.action_edit_CarimboEnsaio, manager);
            Log.v(TAG, "action_edit_CarimboEnsaio");
        } else if (f instanceof CarimboProjetoFragment) {
            Bundle b = new Bundle();
            b.putInt("furoId", projeto.getListaDeFuros().size());
            navigateFragments(R.id.action_new_Ensaio, manager, b);
            Log.v(TAG, "action_new_Ensaio");
        } else if (f instanceof CarimboEnsaioFragment) {
            Log.v(TAG, "action_execute_Ensaio");
            Bundle b = new Bundle();
            int furoId = ((CarimboEnsaioFragment) f).getFuroId();
            b.putInt("furoId", furoId);
            b.putInt("amostraId", projeto.getListaDeFuros().get(furoId).getListaDeAmostras().size());
            navigateFragments(R.id.action_execute_Ensaio, manager, b);
        } else if (f instanceof EnsaioFragment) {
            navigateFragments(R.id.action_next_Amostra, manager);
            Log.v(TAG, "action_next_Amostra");
        } else {
            Log.v(TAG, "none action");
        }
    }

    private static void navigateFragments(int actionId, FragmentManager manager) {
        navigateFragments(actionId, manager, null);
    }

    private static void navigateFragments(int actionId, FragmentManager manager, Bundle args) {
        ((NavHostFragment) Objects.requireNonNull(manager.findFragmentById(R.id.containerSpt)))
                .getNavController().navigate(actionId, args);
    }

    protected void intentHome(View view) {
        Intent intent = new Intent(view.getContext(), HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }

    public void updateProjeto(ProjetoSpt projeto) {
        this.projeto = projeto;
        if (isProjetoNew) {
            ProjetoSptUseCase.save(projeto);
            isProjetoNew = false;
        } else {
            ProjetoSptUseCase.update(projeto);
        }
    }

    protected void setupViewModel(ProjetoSpt projeto, FragmentManager manager) {
        this.projeto = projeto;
        if (projeto.getNome() == null) {
            isProjetoNew = true;
            projeto.setListaDeFuros(new ArrayList<>());
            navigateFragments(R.id.action_edit_Carimbo, manager);
        }
    }

    public ProjetoSpt getProjeto() {
        return projeto;
    }
}
