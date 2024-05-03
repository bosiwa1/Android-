package com.example.welcome_activity;


import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;


import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;





import com.google.firebase.auth.FirebaseAuth;




//


import android.net.Uri;

import android.provider.MediaStore;
import android.view.View;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

import androidx.activity.result.contract.ActivityResultContracts;




public class Welcome_Istagran_Main extends AppCompatActivity {


    private FirebaseAuth mAuth;


    private EditText name_email ;
            private EditText password;
    Button sing_up;
    Button login ;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_istagran_main);

        name_email = findViewById(R.id.name_email);
        password = findViewById(R.id.password);
        //@SuppressLint({"MissingInflatedId", "LocalSuppress"}) ShapeableImageView ah = findViewById(R.id.shapeableImageView2);


        sing_up = findViewById(R.id.sing_up_Up);

        sing_up.setOnClickListener(v -> {
            Intent intent;

            intent = new Intent(Welcome_Istagran_Main.this, Register_activity.class);
            startActivity(intent);
        });


        Button login = findViewById(R.id.login);
        // check user name and password use firebase data
        login.setOnClickListener(v -> {
            // if task success go the profile, if name or email and password are equal
            // Intent intentProfile ;
            // intentProfile = new Intent(Welcome_user_activity. this, profile.class);
            // startActivity(intentProfile);
            loginUser();

        });
//       ///

    }


    private void loginUser() {
        mAuth = FirebaseAuth.getInstance();

        String email = name_email.getText().toString();  // Use toString() instead of String.valueOf()
        String password2 = password.getText().toString(); // Use toString() instead of String.valueOf()

        mAuth.signInWithEmailAndPassword(email, password2).addOnCompleteListener
                (this, task -> {
                    if (task.isSuccessful()) {
                        // Login success, handle accordingly
                        Toast.makeText(Welcome_Istagran_Main.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intentProfile = new Intent(Welcome_Istagran_Main.this,
                                HomePage.class);
                        startActivity(intentProfile);
                        finish(); // Close the current activity
                    } else {
                        // Login failed, handle accordingly
                        Toast.makeText(Welcome_Istagran_Main.this,
                                "Login failed. Check your credentials.", Toast.LENGTH_SHORT).show();
                    }
                });




      //try


    }


}












