package com.montaigne.montaigneapp.activity.spt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.spt.carimboEnsaio.CarimboEnsaioFragment;
import com.montaigne.montaigneapp.databinding.ActivitySptBinding;

public class SptActivity extends AppCompatActivity {
    private ActivitySptBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySptBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerSpt, new CarimboEnsaioFragment())
                .commitNow();

    }

   }
