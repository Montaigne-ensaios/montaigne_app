package com.montaigne.montaigneapp.ui.spt;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.navigation.fragment.NavHostFragment;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.data.usecase.ProjetoSptUseCase;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.home.HomeActivity;

import java.util.Objects;

public class SptVM extends ViewModel {
    private final String TAG = "SptActivity";

    private ProjetoSpt projeto;
    private boolean isProjetoNew = false;
    // variável que define se o projeto deve ser salvo ou deve-se criar um novo

    protected void handleNavigation(Button button, FragmentManager manager) {
        // todo: substituir strings
        // todo: refatorar actions
        if (SptVM.fragmentIsVisible(R.id.projetoFragment, manager)) {
            navigateFragments(R.id.action_edit_Carimbo, manager);
            button.setText(R.string.TxtBotaoContinuar_novo_furo);
            Log.v(TAG, "action_edit_Carimbo");
        } else if (SptVM.fragmentIsVisible(R.id.furoFragment, manager)) {
            navigateFragments(R.id.action_edit_CarimboEnsaio, manager);
            button.setText("String Editar carimbo do furo");
            Log.v(TAG, "action_edit_CarimboEnsaio");
        } else if (SptVM.fragmentIsVisible(R.id.carimboProjetoFragment, manager)) {
            navigateFragments(R.id.action_new_Ensaio, manager);
            button.setText("String Iniciar ensaio");
            Log.v(TAG, "action_new_Ensaio");
        } else if (SptVM.fragmentIsVisible(R.id.carimboEnsaioFragment, manager)) {
            navigateFragments(R.id.action_execute_Ensaio, manager);
            button.setText("String Proxima amostra");
            Log.v(TAG, "action_execute_Ensaio");
        } else if (SptVM.fragmentIsVisible(R.id.ensaioFragment, manager)) {
            navigateFragments(R.id.action_next_Amostra, manager);
            button.setText("String Próxima amostra");
            Log.v(TAG, "action_next_Amostra");
        } else {
            Log.v(TAG, "none action");
        }
    }

    private static void navigateFragments(int actionId, FragmentManager manager) {
        ((NavHostFragment) Objects.requireNonNull(manager.findFragmentById(R.id.containerSpt)))
                .getNavController().navigate(actionId);
    }

    private static boolean fragmentIsVisible(int id, FragmentManager manager) {
        Fragment fragment = manager.findFragmentById(id);
        if (fragment != null) return fragment.isVisible();
        else return false;  // fixme: none visble fragment. See: https://stackoverflow.com/questions/62297866/fragments-id-and-tag-are-not-set-when-using-navigation-component
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

    protected void setupViewModel(ProjetoSpt projeto, Button button, FragmentManager manager) {
        this.projeto = projeto;
        if (projeto.getNome() == null) {
            isProjetoNew = true;
            navigateFragments(R.id.action_edit_Carimbo, manager);
            button.setText(R.string.TxtBotaoContinuar_novo_furo);  // tod verificar se esta é a string certa
        } else {
//            navigateFragments(R.id.action_edit_Carimbo, manager);  // checar se o fragmento home é já é adicionado
            button.setText("String editar carimbo");
        }
    }

    public ProjetoSpt getProjeto() {
        return projeto;
    }
}
