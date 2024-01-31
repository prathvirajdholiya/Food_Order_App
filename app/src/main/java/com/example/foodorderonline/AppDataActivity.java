package com.example.foodorderonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AppDataActivity extends AppCompatActivity {
        FirebaseAuth auth;
        Button btn;
        TextView details;
        FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_data);

        // initialize
      auth = FirebaseAuth.getInstance();
      btn = findViewById(R.id.logout_btn);
      details = findViewById(R.id.user_details);
      user = auth.getCurrentUser();
      if (user == null){
          Intent intent = new Intent(getApplicationContext(),MainActivity.class);
          startActivity(intent);
          finish();
      }
      else {
          details.setText(user.getEmail());
      }


      // set log out button action
      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              FirebaseAuth.getInstance().signOut();
              Intent intent = new Intent(getApplicationContext(),MainActivity.class);
              startActivity(intent);
              finish();

          }
      });



    }
}