package com.example.hyeon.sejonglectureandroidprogramming;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by HYEON on 2017-12-12.
 */

public class MainFragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        Button button = (Button) rootView.findViewById(R.id.btn_mainFragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentActivity fragActivity = (FragmentActivity) getActivity();
                fragActivity.onFragmentChanged(0);
            }
        });

//        return super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }
}
