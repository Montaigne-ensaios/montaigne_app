package com.montaigne.montaigneapp.activity.spt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.carimboDefinitivo.CarimboDefinitivoActivity;
import com.montaigne.montaigneapp.activity.spt.carimboUnico.CarimboUnicoFragment;
import com.montaigne.montaigneapp.activity.spt.carimboUnico.CarimboUnicoVM;
import com.montaigne.montaigneapp.activity.spt.fragment.SptFragment;

public class SptActivity extends AppCompatActivity {
    private CarimboUnicoVM mCarimboUnicoVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spt);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CarimboUnicoFragment.newInstance())
                    .commitNow();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }
}