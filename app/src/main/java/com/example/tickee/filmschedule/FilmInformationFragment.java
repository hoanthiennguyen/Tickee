package com.example.tickee.filmschedule;


import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.tickee.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmInformationFragment extends Fragment {
    VideoView videoView;

    public FilmInformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film_information, container, false);
        videoView = view.findViewById(R.id.trailerFilm);
        MediaController m = new MediaController(getActivity());
        videoView.setMediaController(m);

        String path = "android.resource://com.example.tickee/"+R.raw.matbiec;
        Uri u = Uri.parse(path);

        videoView.setVideoURI(u);
        videoView.seekTo( 8000 );
        return view;
    }

}
