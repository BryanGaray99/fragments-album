package com.bgaray.fragmentsalbum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import adapters.AlbumAdapter;
import models.Album;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumAdapter albumAdapter;
    private List<Album> albums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recyclerView);

        albums = new ArrayList<>();
        albums.add(new Album("Electricidad","Jesse & Joy","Pop", R.drawable.electricidad));
        albums.add(new Album("Awake","Skillet","Rock", R.drawable.awake));
        albums.add(new Album("Rise","Skillet","Rock", R.drawable.rise));
        albums.add(new Album("Gaia II: La voz dormida","Mago de Oz","Rock", R.drawable.gaia2));
        albums.add(new Album("Gaia III: Atlantia","Mago de Oz","Rock", R.drawable.gaia3));
        albums.add(new Album("Ride the Lightning","Metallica","Rock", R.drawable.ride));
        albums.add(new Album("Back in Black","ACDC","Rock", R.drawable.black));
        albums.add(new Album("Viaje","Ricardo Arjona","Pop", R.drawable.viaje));
        albums.add(new Album("Primera fila","La Oreja de Van Gogh","Pop", R.drawable.vida));
        albums.add(new Album("Un susurro en la tormenta","La Oreja de Van Gogh","Pop", R.drawable.tormenta));

        albumAdapter = new AlbumAdapter(albums, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(albumAdapter);

    }
}