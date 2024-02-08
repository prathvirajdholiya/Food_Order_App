package com.example.foodorderonline;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignInActivity extends AppCompatActivity {




    TextView registr,forgetTxt;
    EditText editTextTextPassword, EmailEditText;
    Button Log_in_btn;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), AppDataActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();
        registr = findViewById(R.id.loginalready);
        EmailEditText = findViewById(R.id.EmailEditText);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        Log_in_btn = findViewById(R.id.Log_in_btn);
        forgetTxt = findViewById(R.id.forgetTxt);



        registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUp_Activity.class);
                startActivity(intent);
            }

        });

        forgetTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,forgetPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Log_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email,password;
               email = EmailEditText.getText().toString();
                //set condition
                if (email.trim().equals("")) {
                    EmailEditText.setError("Email is Required!!");
                }
                password = editTextTextPassword.getText().toString();
                if (password.trim().equals("")) {
                    editTextTextPassword.setError("Password is Compulsory !!!");
                }
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignInActivity.this, "Login Successful.",
                                            Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(SignInActivity.this, AppDataActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(SignInActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });




                                           }
                                       }


