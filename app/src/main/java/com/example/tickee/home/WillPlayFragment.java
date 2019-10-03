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

public class WillPlayFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sapchieu, container, false);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            transaction.remove(fragment);
        }
        transaction.add(R.id.filmSCContainer,new WillPlayFilmFragment(R.drawable.hungthan,4.2f,"12/10","C17"));
        transaction.add(R.id.filmSCContainer,new WillPlayFilmFragment(R.drawable.minion,4.5f,"15/10", null));
        transaction.commit();
        return view;
    }
}
