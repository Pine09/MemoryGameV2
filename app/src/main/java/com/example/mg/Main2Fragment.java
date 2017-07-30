package com.example.mg;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Main2Fragment extends Fragment {
    public Button btnback, btnrelax, btnchallange;

    public Main2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main2, container, false);
        btnback = (Button) v.findViewById(R.id.btnback);
        btnrelax = (Button) v.findViewById(R.id.btnstart);
        btnchallange = (Button) v.findViewById(R.id.btnhighscore);

        setHasOptionsMenu(true);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnrelax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mode = "Relax";
                RelaxModeFragment relaxfg = new RelaxModeFragment();
//                TestingFragment relaxfg = new TestingFragment();
                Bundle data = new Bundle();
                data.putString("mode", mode);
                relaxfg.setArguments(data);

                getFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container_main, relaxfg, RelaxModeFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btnchallange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mode = "Challange";
                ChallangeModeFragment cfg = new ChallangeModeFragment();
//                Testing2Fragment cfg = new Testing2Fragment();
                Bundle data = new Bundle();
                data.putString("mode", mode);
                cfg.setArguments(data);

                getFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container_main, cfg, ChallangeModeFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
    }


}


