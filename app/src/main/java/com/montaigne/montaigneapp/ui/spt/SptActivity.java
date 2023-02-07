package com.montaigne.montaigneapp.ui.spt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.home.HomeVM;
import com.montaigne.montaigneapp.databinding.AcitivitySptBinding;
import com.montaigne.montaigneapp.utils.CreateXlsxSpt;
import com.montaigne.montaigneapp.utils.ExportFile;

import java.util.Objects;

public class SptActivity extends AppCompatActivity {
    private AcitivitySptBinding binding;
    private SptVM viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AcitivitySptBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(SptVM.class);
        viewModel.setupViewModel(
                (ProjetoSpt) getIntent().getExtras().getSerializable(HomeVM.PROJETO),
                getSupportFragmentManager()
        );
        setSupportActionBar(binding.toolbarSptInclude.toolbarSpt);
        getSupportActionBar().setIcon(R.drawable.icon_arrow_left);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        binding.imgButtonHome.setOnClickListener(viewModel::intentHome);
        binding.buttonNavigate.setOnClickListener(v -> viewModel.handleNavigation(getSupportFragmentManager()));

        binding.toolbarSptInclude.toolbarSpt.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.deletefuro) {
                // todo: implementar exportação de ensaio aqui
                return true;
            }
            if(item.getItemId() == R.id.exportar_xlsx){
                ProjetoSpt projetoSpt = viewModel.getProjeto();
                FuroSpt furoSpt = projetoSpt.getListaDeFuros().get(1);

                CreateXlsxSpt.createFileXlsx(projetoSpt, furoSpt, this);
                ExportFile.getUri(this);
                ExportFile.shareXlsx(this);
                return true;
            }
            return false;
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_spt, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void setNavigateButtonText(String string) {
        binding.buttonNavigate.setText(string);
    }

    public void setActionBarTitle(String string) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(string);
    }
}
