package com.montaigne.montaigneapp.ui.spt;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;
import com.montaigne.montaigneapp.ui.AbstracProjectActivity;
import com.montaigne.montaigneapp.databinding.AcitivitySptBinding;
import com.montaigne.montaigneapp.ui.AbstractProjectViewModel;
import com.montaigne.montaigneapp.utils.CreateXlsxSpt;
import com.montaigne.montaigneapp.utils.ExportFile;

import java.util.Objects;

public class SptActivity extends AbstracProjectActivity<SptVM, ProjetoSpt> {
    private AcitivitySptBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AcitivitySptBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setViewModel(new ViewModelProvider(this).get(SptVM.class));

        setSupportActionBar(binding.toolbarSptInclude.toolbarSpt);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setButtonHome(binding.imgButtonHome);
        setButtonNavigate(binding.buttonNavigate);

//        binding.toolbarSptInclude.toolbarSpt.setOnMenuItemClickListener(item -> {
//            if(item.getItemId() == R.id.exportar_xlsx){
//                ProjetoSpt projetoSpt = viewModel.getProjeto();
//                FuroSpt furoSpt = projetoSpt.getListaDeFuros().get(0);
//
//                CreateXlsxSpt.createFileXlsx(projetoSpt, furoSpt, this);
//                ExportFile.getUri(this);
//                ExportFile.shareXlsx(this);
//                return true;
//            }
//            return false;
//        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu_spt, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    public void setNavigateButtonText(String string) {
        binding.buttonNavigate.setText(string);
    }

    public void setActionBarTitle(String string) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(string);
    }
}
