package com.example.welcome_activity;


import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

//

import android.graphics.Bitmap;

import android.widget.Button;


public class HomePage extends AppCompatActivity {


    ImageButton profile ;
    ImageButton add1 ;
    ImageView imageView ;


    private static final int IMAGE_REQUEST = 1;


    Uri imageLocationPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

       // imageView.findViewById(R.id.new10);

        ImageButton home = findViewById(R.id.back_home);
        profile = findViewById(R.id.profiles1);
       add1= findViewById(R.id.add);




        profile.setOnClickListener(v -> {
            Intent intent;

            intent = new Intent(HomePage.this, Myprofile.class);
            startActivity(intent);
        });

     //
    }
    public void setSelectImage (View View) {

        try {
            Intent objectIntent = new Intent();
            objectIntent.setType("image/*");
            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent,IMAGE_REQUEST);
        }catch (Exception e){
            Toast.makeText(HomePage.this, "No image selected", Toast.LENGTH_SHORT).show();

        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        try {


            if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                imageLocationPath = data.getData();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageLocationPath);
             //   imageView.setImageBitmap(bitmap);


            } else {
                // Show a toast message if no image is selected
                Toast.makeText(HomePage.this, "No image selected", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e) {
            Toast.makeText(HomePage.this, "problem", Toast.LENGTH_SHORT).show();

        }
    }




}