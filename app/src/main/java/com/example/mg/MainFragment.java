package com.example.mg;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainFragment extends Fragment {
    private Button btnstart, btnexit, btnhighscore;
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        btnstart = (Button) v.findViewById(R.id.btnstart);
        btnexit = (Button) v.findViewById(R.id.btnexit);
        btnhighscore = (Button) v.findViewById(R.id.btnhighscore);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container_main, new Main2Fragment(), Main2Fragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();

            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Thank you for playing", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        });

        btnhighscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HighScoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
