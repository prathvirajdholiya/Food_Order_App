package com.example.foodorderonline;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button login_btn,sign_up_btn;
    TextView skiptext;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find id
        login_btn = findViewById(R.id.login_btn);
        sign_up_btn = findViewById(R.id.Log_in_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(MainActivity.this, "clicked on Log In", Toast.LENGTH_SHORT).show();
           // create intent
                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });

        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, SignUp_Activity.class);
                startActivity(intent2);
            }
        });

        // find id
        skiptext = findViewById(R.id.skiptext);

        // set listner
        skiptext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this,SplashScreenActivity.class);
                startActivity(intent3);
            }
        });


    }
}