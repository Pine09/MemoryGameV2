package com.example.mg;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {
    private ImageButton btnHome, btnRe;
    private TextView txtName, txtResultScore, txtMode, txtMsg;
    private String name, mode, msg;
    private int resultscore;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_result, container, false);
        btnHome = (ImageButton) v.findViewById(R.id.btnHome);
        btnRe = (ImageButton) v.findViewById(R.id.btnRe);
        txtMsg = (TextView) v.findViewById(R.id.txtMsg);
        txtName = (TextView) v.findViewById(R.id.txtName);
        txtMode = (TextView) v.findViewById(R.id.txtMode);
        txtResultScore = (TextView) v.findViewById(R.id.txtResultScore);

        msg = getArguments().getString("msg");
        name = getArguments().getString("username");
        mode = getArguments().getString("mode");
        resultscore = getArguments().getInt("resultscore");
        System.out.println(name);
        System.out.println(mode);
        System.out.println(msg);
        txtMsg.setText(msg);
        txtName.setText(name);
        txtMode.setText(mode + " Mode");
        txtResultScore.setText(resultscore + "");
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //play again command here.
                if (mode.equals("Relax")) {
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_container_main, new RelaxModeFragment(), RelaxModeFragment.class.getSimpleName())
                            .commit();
                } else  if (mode.equals("Challange")) {
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_container_main, new ChallangeModeFragment(), ChallangeModeFragment.class.getSimpleName())
                            .commit();
                }

            }
        });
    }
}
