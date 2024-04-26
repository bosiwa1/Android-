package com.example.welcome_activity;



import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import com.google.android.material.imageview.ShapeableImageView;




public class Myprofile extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    ActivityResultLauncher<Intent> resultlumch ;
    private ShapeableImageView shapeableImageView_profile;

   private ImageButton home_Profile;
  protected   FloatingActionButton map;
   protected FloatingActionButton  upload_picture;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        home_Profile = findViewById(R.id.back_home);
        home_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                intent = new Intent(Myprofile.this, HomePage.class);
                startActivity(intent);
            }
        });

        map= findViewById(R.id.map1);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Myprofile.this, MyMap.class);
                startActivity(intent);

            }
        });

        upload_picture= findViewById(R.id.upload1);

        upload_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();


            }
        });


    }

    private void openFileChooser() {
        // Set the starting directory for the file chooser to the emulator's image directory
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                //image.setImageBitmap(bitmap);


                shapeableImageView_profile.setImageBitmap(bitmap); //problem : change the shape to viewImage so you set it
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Error loading image", Toast.LENGTH_SHORT).show();
            }
        }
    }


}