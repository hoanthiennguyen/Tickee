package com.example.tickee.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.tickee.R;

public class PlayedFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ngungchieu, container, false);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            transaction.remove(fragment);
        }
        transaction.add(R.id.filmNCContainer,new PlayedFilmFragment(R.drawable.hoavangcoxanh,4.7f));
        transaction.add(R.id.filmNCContainer,new PlayedFilmFragment(R.drawable.thor2, 4.1f));
        transaction.commit();
        return view;
    }

}
