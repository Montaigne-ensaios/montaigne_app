package com.montaigne.montaigneapp.ui;

import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.ui.home.HomeVM;

import java.util.Objects;

public abstract class AbstracProjectActivity <
        ProjectViewModel extends AbstractProjectViewModel<Project>,
        Project extends Projeto
        > extends AppCompatActivity {
    public static final String PROJETO = "projeto";  // key intent extra bundle do projeto

    private ProjectViewModel viewModel;
    private Button buttonNavigate;

    protected void setViewModel(@NonNull ProjectViewModel viewModel) {
        this.viewModel = viewModel;
        viewModel.setUp((Projeto) getIntent()
                .getExtras()
                .getSerializable(AbstracProjectActivity.PROJETO),
                getSupportFragmentManager());
    }

    protected void setButtonNavigate(Button buttonNavigate) {
        this.buttonNavigate = buttonNavigate;
        this.buttonNavigate.setOnClickListener(v -> viewModel.handleNavigation(getSupportFragmentManager()));
    }

    protected void setButtonHome(@NonNull ImageButton buttonHome) {
        buttonHome.setOnClickListener(AbstractProjectViewModel::intentHome);
    }

    public void setButtonNavigateText(String text) {
        buttonNavigate.setText(text);
    }

    public void setActionBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    @Override
    public void onBackPressed() {
        if (AbstractProjectViewModel.isLocked())
            super.onBackPressed();
        else
            AbstractProjectViewModel.notifyLocking(getCurrentFocus());
    }
}
