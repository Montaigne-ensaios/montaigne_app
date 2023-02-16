package com.montaigne.montaigneapp.ui;

import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.utils.FragmentNavigator;

import java.util.Objects;

public abstract class AbstractProjectActivity<
        ProjectViewModel extends AbstractProjectViewModel<Project>,
        Project extends Projeto
        > extends AppCompatActivity {
    public static final String PROJETO = "projeto";  // key intent extra bundle do projeto

    protected ProjectViewModel viewModel;
    private Button buttonNavigate;

    protected void setViewModel(@NonNull ProjectViewModel viewModel) {
        this.viewModel = viewModel;
        viewModel.setUp((Projeto) getIntent()
                .getExtras()
                .getSerializable(AbstractProjectActivity.PROJETO),
                getSupportFragmentManager());
    }

    protected void setButtonNavigate(Button buttonNavigate) {
        this.buttonNavigate = buttonNavigate;
        this.buttonNavigate.setOnClickListener(v -> viewModel.handleNavigation(getSupportFragmentManager()));
    }

    protected void setButtonHome(@NonNull ImageButton buttonHome) {
        buttonHome.setOnClickListener(FragmentNavigator::intentHome);
    }

    public void setButtonNavigateText(String text) {
        buttonNavigate.setText(text);
    }

    @Override
    public void onBackPressed() {
        if (!FragmentNavigator.hasEmptyFields())
            super.onBackPressed();
        else
            FragmentNavigator.notifyEmptyFields(getCurrentFocus());
    }
}
