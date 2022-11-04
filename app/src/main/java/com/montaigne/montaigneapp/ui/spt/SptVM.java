package com.montaigne.montaigneapp.ui.spt;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.carimboProjeto.CarimboProjetoFragment;
import com.montaigne.montaigneapp.ui.home.HomeActivity;
import com.montaigne.montaigneapp.ui.spt.carimboEnsaio.CarimboEnsaioFragment;
import com.montaigne.montaigneapp.ui.spt.projeto.ProjetoFragment;

public class SptVM extends ViewModel {
    private ProjetoSpt projeto;
    private boolean isProjetoNew = false;
    // variável que define se o projeto deve ser salvo ou deve-se criar um novo

    protected void navigateFragments(View view, FragmentManager manager) {
        // todo: implementar navegação dentro da activity
        ((Button) view).setText(R.string.TxtBotaoContinuar_novo_furo);
        CarimboEnsaioFragment carimboEnsaioFragment = new CarimboEnsaioFragment();
        manager.beginTransaction()
                .replace(R.id.containerSpt, carimboEnsaioFragment)
                .commitNow();

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
            CarimboProjetoFragment fragment = new CarimboProjetoFragment();
            manager.beginTransaction()
                    .replace(R.id.containerSpt, fragment)
                    .commitNow();
        } else {
            ProjetoFragment fragment = new ProjetoFragment();
            // todo: substituir fragmente por ProjetoFragment e revisar esta comunicação
            manager.beginTransaction()
                    .replace(R.id.containerSpt, fragment)
                    .commitNow();
        }
    }

    public ProjetoSpt getProjeto() {
        return projeto;
    }
}
