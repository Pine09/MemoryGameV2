package com.example.mg;

import android.os.CountDownTimer;
import android.widget.TextView;

public class TimerMundur extends CountDownTimer {
    public static int second = 1000;
    TextView txt1;
    public static long sisawaktu;

    public TimerMundur(long millisInFuture, long countDownInterval, TextView txt1) {
        super(millisInFuture, countDownInterval);
        this.txt1 = txt1;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        txt1.setText(String.valueOf(millisUntilFinished / second));
        this.sisawaktu = millisUntilFinished;
    }

    @Override
    public void onFinish() {

    }

    public static long getSisawaktu() {
        return sisawaktu;
    }
}
