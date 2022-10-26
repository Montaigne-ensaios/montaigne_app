package com.montaigne.montaigneapp.activity.spt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.montaigne.montaigneapp.R;
import com.montaigne.montaigneapp.activity.spt.carimboEnsaio.CarimboEnsaioFragment;
import com.montaigne.montaigneapp.activity.spt.carimboEnsaio.CarimboEnsaioVM;
import com.montaigne.montaigneapp.activity.spt.fragment.SptFragment;

public class SptActivity extends AppCompatActivity {
    private CarimboEnsaioVM mCarimboUnicoVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spt);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CarimboEnsaioFragment.newInstance())
                    .commitNow();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }
}