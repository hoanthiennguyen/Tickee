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

public class DCFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dangchieu, container, false);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            transaction.remove(fragment);
        }
        transaction.add(R.id.filmContainer,new FilmDCFragment(R.drawable.matbiecbg));
        transaction.add(R.id.filmContainer,new FilmDCFragment(R.drawable.sheep));
        transaction.commit();
        return view;
    }
}
