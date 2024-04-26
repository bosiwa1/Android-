package com.example.welcome_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MyMap extends AppCompatActivity implements OnMapReadyCallback{
    private  GoogleMap map;
    private ImageButton backHome;
    private ImageButton MyProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_map);

        if (!isNetworkConnected()) {
            // Display a Toast message notifying the user about the lack of internet connection
            Toast.makeText(this, "No internet connection. Please check your network settings.", Toast.LENGTH_LONG).show();
            // Handle the case when there's no internet connection
            // For example, display a message to the user or try again later
            return;
        }

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // go back homw page
        backHome=findViewById(R.id.back_home);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                intent = new Intent(MyMap.this, HomePage.class);
                startActivity(intent);

            }
        });

        MyProfile = findViewById(R.id.profiles1);


        MyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                intent = new Intent(MyMap.this, Myprofile.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {


        map=googleMap;
        LatLng Limerick = new LatLng(52.663157,
                -8.619842);
        map.addMarker(new MarkerOptions().position(Limerick).title("Limerick"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Limerick,12f));

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }









}