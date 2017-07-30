package com.example.mg;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static android.R.id.input;


public class MainActivity extends AppCompatActivity {
    protected ImageButton btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_container_main, new MainFragment(), MainFragment.class.getSimpleName())
                    .commit();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            Toast.makeText(getApplicationContext(),"Back button clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



    // show pop up dialog after end game
    protected void popDialog(final String mode, final int resultscore, final String msg) {

        MaterialDialog dialog = new MaterialDialog.Builder(this) // Build in this activity
                .title("Congratulation!")
                .content("Please enter your nickname")
                .inputRangeRes(3, 3, R.color.colorAccent)
                .theme(Theme.DARK)
                .buttonRippleColorRes(R.color.colorTeal2)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input(null, "ABC", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        String name = input.toString();
                        toResult(name, mode, resultscore, msg);
                    }
                }).dismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            Toast.makeText(getApplicationContext(), "WOW", Toast.LENGTH_SHORT).show();
                        }
                }).show();

    }

    // with data to resultfragment
    protected void toResult(String name, String mode, int resultscore, String msg) {
        // passing data w/ fragment manager
        String username = name.toUpperCase();
        ResultFragment fg = new ResultFragment();
        Bundle data = new Bundle();

        data.putString("username", username);
        data.putString("mode", mode);
        data.putInt("resultscore", resultscore);
        data.putString("msg", msg);
        fg.setArguments(data);

        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.frame_container_main, fg, ResultFragment.class.getSimpleName())
                .commit();

    }

}
