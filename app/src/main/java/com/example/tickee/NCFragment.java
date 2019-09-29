package com.example.tickee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class NCFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ngungchieu, container, false);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.filmNCContainer,new FilmNCFragment(R.drawable.faf));
        transaction.add(R.id.filmNCContainer,new FilmNCFragment(R.drawable.download));
        transaction.commit();
        return view;
    }
}
