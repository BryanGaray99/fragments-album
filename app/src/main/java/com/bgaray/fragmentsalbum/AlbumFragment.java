package com.bgaray.fragmentsalbum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import models.Album;
public class AlbumFragment extends Fragment {

    private ImageView albumCover;
    private TextView albumTitle, albumArtist, albumGenre;
    private Album album;

    private AlbumFragment(Album album){
        this.album = album;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.album_item, container, false);
        albumTitle =view.findViewById(R.id.albumTitle);
        albumArtist = view.findViewById(R.id.albumArtist);
        albumGenre = view.findViewById(R.id.albumGenre);
        albumCover = view.findViewById(R.id.albumCover);

        // Usamos Glide para traer imágenes de internet y devolverlas a albumCover
        Glide.with(this).load(album.getImageUrl()).into(albumCover);

        albumTitle.setText(this.album.getTitle());
        albumArtist.setText(this.album.getArtist());
        albumGenre.setText(this.album.getGenre());

        return view;

    }
}
