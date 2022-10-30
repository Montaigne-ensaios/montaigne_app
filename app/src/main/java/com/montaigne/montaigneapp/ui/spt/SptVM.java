package com.montaigne.montaigneapp.ui.spt;

import android.content.Intent;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.carimboProjeto.CarimboProjetoFragment;
import com.montaigne.montaigneapp.ui.home.HomeActivity;
import com.montaigne.montaigneapp.ui.spt.carimboEnsaio.CarimboEnsaioFragment;

public class SptVM extends ViewModel {
    private ProjetoSpt projeto;

    protected void navigateFragments(View view) {
        // todo: implementar navegação dentro da activity
        // este método deve ser responsável por decidir de onde para onde navegar os fragments
    }

    protected void intentHome(View view) {
        Intent intent = new Intent(view.getContext(), HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }

    protected void moreActions(View view, Fragment fragment) {
        // todo: implementar botão de mais ações relativo ao fragment
    }

    public void setProjeto(ProjetoSpt projeto, FragmentManager manager) {
        this.projeto = projeto;
        if (projeto.getNome() == null) {
            manager.beginTransaction()
                    .replace(R.id.containerSpt, new CarimboProjetoFragment())
                    .commitNow();
        } else {
            manager.beginTransaction()
                    .replace(R.id.containerSpt, new CarimboEnsaioFragment())
                    // todo: substituir fragmente por ProjetoFragment
                    .commitNow();
        }
    }

    public ProjetoSpt getProjeto() {
        return projeto;
    }
}
