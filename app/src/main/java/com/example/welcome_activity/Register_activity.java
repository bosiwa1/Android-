package com.example.welcome_activity;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;




public class Register_activity extends AppCompatActivity {

    private EditText nameEmailEditText;
    private EditText passwordEditText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEmailEditText = findViewById(R.id.name_email);
        passwordEditText = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

        Button signUpButton = findViewById(R.id.sing_up_Up);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String email = nameEmailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Registration success, handle accordingly
                            // For example, you can navigate to the login activity
                            Toast.makeText(Register_activity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                             Intent intentProfile ;
                             intentProfile = new Intent(Register_activity. this, Welcome_activity.class);
                            startActivity(intentProfile);
                        } else {
                            // Registration failed, handle accordingly
                            Toast.makeText(Register_activity.this, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
