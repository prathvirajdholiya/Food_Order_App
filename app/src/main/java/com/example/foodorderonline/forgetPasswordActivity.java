package com.example.foodorderonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class forgetPasswordActivity extends AppCompatActivity {
    Button reset, btnBack;
    EditText editemail;
    ProgressBar progressBar;
    FirebaseAuth mAuth;
    String strEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        // initialization
        btnBack = findViewById(R.id.btnBack);
        reset = findViewById(R.id.BtnReset);
        editemail = findViewById(R.id.editTextTextEmailAddress4);
        progressBar = findViewById(R.id.forgetPasswordprogressBar);
        mAuth = FirebaseAuth.getInstance();

        //Reset Button Listner(forget password)
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail = editemail.getText().toString().trim();
                if (!TextUtils.isEmpty(strEmail)) {
                    ResetPassword();
                } else {
                    editemail.setError("Email field can't be Blank !!");
                }
            }


        });
        // Back btn code
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forgetPasswordActivity.this, SplashScreenActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private void ResetPassword() {
        mAuth.sendPasswordResetEmail(strEmail).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(forgetPasswordActivity.this,
                        "Reset Password link Has been sent to your registered Email", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(forgetPasswordActivity.this, SplashScreenActivity.class);
                startActivity(intent);
                finish();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(forgetPasswordActivity.this, "Error!!", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.VISIBLE);
                        reset.setVisibility(View.INVISIBLE);
                    }
                });
    }
}