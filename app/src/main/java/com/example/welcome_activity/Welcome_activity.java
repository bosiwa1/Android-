package com.example.welcome_activity;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import androidx.annotation.NonNull;

import java.util.Currency;


public class Welcome_activity extends AppCompatActivity {
    private EditText name_email ;
            private EditText password;
    Button sing_up;
    Button login ;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       name_email = findViewById(R.id.name_email);
       password = findViewById(R.id.password);

        sing_up = findViewById(R.id.sing_up_Up);

        sing_up.setOnClickListener(v -> {
            Intent intent;

            intent = new Intent(Welcome_activity.this, Register_activity.class);
            startActivity(intent);
        });


        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            // check user name and password use firebase data
            @Override
            public void onClick(View v) {
                // if task success go the profile, if name or email and password are equal
                // Intent intentProfile ;
                // intentProfile = new Intent(Welcome_user_activity. this, profile.class);
                // startActivity(intentProfile);
                loginUser();

            }
        });
    }


    private void loginUser() {
        mAuth = FirebaseAuth.getInstance();

        String email = name_email.getText().toString();  // Use toString() instead of String.valueOf()
        String password2 = password.getText().toString(); // Use toString() instead of String.valueOf()

        mAuth.signInWithEmailAndPassword(email, password2).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Login success, handle accordingly
                    Toast.makeText(Welcome_activity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intentProfile = new Intent(Welcome_activity.this, profile.class);
                    startActivity(intentProfile);
                    finish(); // Close the current activity
                } else {
                    // Login failed, handle accordingly
                    Toast.makeText(Welcome_activity.this, "Login failed. Check your credentials.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}






