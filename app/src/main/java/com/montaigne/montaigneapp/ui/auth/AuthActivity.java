package com.montaigne.montaigneapp.ui.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.montaigne.montaigneapp.BuildConfig;
import com.montaigne.montaigneapp.databinding.ActivityAuthBinding;

import java.util.Objects;

public class AuthActivity extends AppCompatActivity {
    private ActivityAuthBinding binding;
    private AuthVM viewModel;

    private GoogleSignInClient client;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(AuthVM.class);
        firebaseAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(BuildConfig.DEFAULT_WEB_CLIENT_ID)
                .requestEmail()
                .build();

        client = GoogleSignIn.getClient(this,options);

        binding.buttonSignInGoogle.setOnClickListener(view -> {
            Intent signInIntent = client.getSignInIntent();
            activityResultLauncher.launch(signInIntent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user!= null){
            viewModel.toHome(getApplicationContext());
            finish();
        }
    }

    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intentResult = result.getData();
                    Task<GoogleSignInAccount> task = GoogleSignIn
                            .getSignedInAccountFromIntent(intentResult);

                    try {
                        GoogleSignInAccount account = task.getResult(ApiException.class);
                        loginGoogleWithCredentials(account.getIdToken());

                    } catch (ApiException e) {
                        Toast.makeText(
                                getApplicationContext(),
                                "Erro ao logar",
                                Toast.LENGTH_LONG).show();

                        Log.e("Login error", e.getMessage());
                    }
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            "Login cancelado",
                            Toast.LENGTH_LONG).show();

                    Log.e("Login cancelado", "Verifique a compilação, verifique as impressões digitais do App e demais configurações");
                }
            });

    private void loginGoogleWithCredentials(String idTolken) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(idTolken, null);
        firebaseAuth.signInWithCredential(authCredential)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        viewModel.toHome(getApplicationContext());
                        finish();

                    }else {
                        Toast.makeText(getApplicationContext(), "Falha ao logar",
                                Toast.LENGTH_SHORT).show();

                        Log.e("Login error",
                                Objects.requireNonNull(task.getException()).getMessage());
                    }
                });
    }
}