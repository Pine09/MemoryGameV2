package com.example.mg;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChallangeModeFragment extends Fragment {
    private CountDownTimer timer;
    ProgressWheel progressWheel;
    private TextView txtMode, txtTime, txtTurn, txtScore;
    private ImageButton btn1, btn2, btn3, btn4, btn5,
            btn6, btn7, btn8, btn9, btn10,
            btn11, btn12, btn13, btn14, btn15,
            btn16, btn17, btn18, btn19, btn20;

    private ImageButton btnOne, btnTwo;
    private Button btnRefill;
    private String msg;

    private MediaPlayer cardflip = new MediaPlayer();
    private MediaPlayer bg_music = new MediaPlayer();

    private float scale = 0.5f;
    private List<Integer> arContent;


    private Boolean klik = true;
    private Boolean multi = false;

    private int stage = 1;
    private int turn = 40;
    private int score = 0;
    private int point = 5;

    private String mode = "Challange";

    private int default_bg_pic = R.drawable.bird_48px;

    private Integer[] data = {
            R.drawable.chicken_48px, R.drawable.butterfly_48px,
            R.drawable.cat_48px, R.drawable.dog_48px,
            R.drawable.dolphin_48px, R.drawable.elephant_48px,
            R.drawable.fish_48px, R.drawable.frog_48px,
            R.drawable.owl_48px, R.drawable.parrot_48px,
//           R.drawable.pig_48px, R.drawable.rabbit_48px,
            R.drawable.chicken_48px, R.drawable.butterfly_48px,
            R.drawable.cat_48px, R.drawable.dog_48px,
            R.drawable.dolphin_48px, R.drawable.elephant_48px,
            R.drawable.fish_48px, R.drawable.frog_48px,
            R.drawable.owl_48px, R.drawable.parrot_48px,
//           R.drawable.pig_48px, R.drawable.rabbit_48px
    };

    public ChallangeModeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game, container, false);
        txtTime = (TextView) v.findViewById(R.id.txtTime);
        txtTurn = (TextView) v.findViewById(R.id.txtTurn);
        txtScore = (TextView) v.findViewById(R.id.txtScore);
        txtMode = (TextView) v.findViewById(R.id.txtMode);
        txtMode.setText(mode + " Mode");
        txtTurn.setText(turn + "");

        progressWheel = (ProgressWheel) v.findViewById(R.id.progress_wheel_game);

        btn1 = (ImageButton) v.findViewById(R.id.btn1);
        btn2 = (ImageButton) v.findViewById(R.id.btn2);
        btn3 = (ImageButton) v.findViewById(R.id.btn3);
        btn4 = (ImageButton) v.findViewById(R.id.btn4);
        btn5 = (ImageButton) v.findViewById(R.id.btn5);

        btn6 = (ImageButton) v.findViewById(R.id.btn6);
        btn7 = (ImageButton) v.findViewById(R.id.btn7);
        btn8 = (ImageButton) v.findViewById(R.id.btn8);
        btn9 = (ImageButton) v.findViewById(R.id.btn9);
        btn10 = (ImageButton) v.findViewById(R.id.btn10);

        btn11 = (ImageButton) v.findViewById(R.id.btn11);
        btn12 = (ImageButton) v.findViewById(R.id.btn12);
        btn13 = (ImageButton) v.findViewById(R.id.btn13);
        btn14 = (ImageButton) v.findViewById(R.id.btn14);
        btn15 = (ImageButton) v.findViewById(R.id.btn15);

        btn16 = (ImageButton) v.findViewById(R.id.btn16);
        btn17 = (ImageButton) v.findViewById(R.id.btn17);
        btn18 = (ImageButton) v.findViewById(R.id.btn18);
        btn19 = (ImageButton) v.findViewById(R.id.btn19);
        btn20 = (ImageButton) v.findViewById(R.id.btn20);

        btnRefill = (Button) v.findViewById(R.id.btnRefill);

        cardflip = MediaPlayer.create(getActivity(), R.raw.cardflip);
        bg_music = MediaPlayer.create(getActivity(), R.raw.hangoverblues);
        bg_music.start();
        bg_music.setLooping(true);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        shuffle();

        // begin timer countdown
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timer=new TimerMundur(100000,100,txtTime){
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        unclickable();
                        message();
                        progressWheel.stopSpinning();
//                        Toast.makeText(getContext(), "TIME's UP!", Toast.LENGTH_SHORT).show();
                        ((MainActivity)getActivity()).popDialog(mode, score, msg);
                    }// untuk kalau 0 finish
                };
                timer.start();
            }
        }, 1000);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(1, btn1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(2, btn2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(3, btn3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(4, btn4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(5, btn5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(6, btn6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(7, btn7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(8, btn8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(9, btn9);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(10, btn10);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(11, btn11);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(12, btn12);
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(13, btn13);
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(14, btn14);
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(15, btn15);
            }
        });

        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(16, btn16);
            }
        });
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(17, btn17);
            }
        });
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(18, btn18);
            }
        });
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(19, btn19);
            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(20, btn20);
            }
        });

        btnRefill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn += 20;
                txtTurn.setText(turn + "");
                timer.cancel();
                long sisa;
                sisa = TimerMundur.getSisawaktu();
                timer.cancel();
                timer = new TimerMundur(sisa + 20000, 1000, txtTime);
                timer.start();
            }
        });

        //set buttons tag
        btn1.setTag("Closed");  btn2.setTag("Closed");
        btn3.setTag("Closed");  btn4.setTag("Closed");
        btn5.setTag("Closed");  btn6.setTag("Closed");
        btn7.setTag("Closed");  btn8.setTag("Closed");
        btn9.setTag("Closed");  btn10.setTag("Closed");

        btn11.setTag("Closed"); btn12.setTag("Closed");
        btn13.setTag("Closed"); btn14.setTag("Closed");
        btn15.setTag("Closed"); btn16.setTag("Closed");
        btn17.setTag("Closed"); btn18.setTag("Closed");
        btn19.setTag("Closed"); btn20.setTag("Closed");
    }

    protected void check(int no, ImageButton btncheck) {
        if (klik) {
            btnOne = btncheck;
            btnOne.setClickable(false);
            btnOne.setBackgroundResource(R.drawable.card_open);
            btnOne.setImageResource(arContent.get(no - 1));
            btnOne.setScaleX(scale);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnOne.setScaleX(scale * 2);
                }
            }, 50);

            if (cardflip.isPlaying()){
                cardflip.pause();
                cardflip.seekTo(0);
                cardflip.start();
            }
            else {
                cardflip.start();
            }

            klik = false;
        } else {
            btnTwo = btncheck;
            btnTwo.setClickable(false);
            btnTwo.setBackgroundResource(R.drawable.card_open);
            btnTwo.setImageResource(arContent.get(no - 1));
            btnTwo.setScaleX(scale);

            if (cardflip.isPlaying()){
                cardflip.pause();
                cardflip.seekTo(0);
                cardflip.start();
            }
            else {
                cardflip.start();
            }

            turn--;
            txtTurn.setText(turn + "");

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnTwo.setScaleX(scale * 2);
                }
            }, 50);

            //disabled touch
            getActivity().getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            );

            // to check card value - same or not
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // same
                    if (btnOne.getDrawable().getConstantState() == btnTwo.getDrawable().getConstantState()) {
                        btnOne.setBackgroundResource(R.drawable.card_disabled);
                        btnTwo.setBackgroundResource(R.drawable.card_disabled);

                        btnOne.setTag("Open"); btnTwo.setTag("Open");
                        btnOne = null; btnTwo = null;
                        klik = true;
                        multiplier();
                        checkwin();

                        // not same
                    } else {
                        btnOne.setBackgroundResource(R.drawable.card);
                        btnTwo.setBackgroundResource(R.drawable.card);
                        btnOne.setScaleX(scale);
                        btnTwo.setScaleX(scale);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                btnOne.setScaleX(scale * 2);
                                btnTwo.setScaleX(scale * 2);
                                btnOne.setImageResource(default_bg_pic);
                                btnTwo.setImageResource(default_bg_pic);
                                btnOne.setClickable(true); btnTwo.setClickable(true);
                                btnOne = null; btnTwo = null;
                                klik = true;
                                multi = false;
                                checkwin();
                            }
                        }, 50);
                    } //else closing
                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE); //enable touch
                }
            }, 500);
        }
    } // end of check()

    //shuffle card data
    protected void shuffle() {
        arContent = Arrays.asList(data);
        Collections.shuffle(arContent);
    }

    //check win
    protected void checkwin() {
        if (turn == 0) {
            Toast.makeText(getContext(), "GAME ENDED", Toast.LENGTH_SHORT).show();
            unclickable();
            message();
            progressWheel.stopSpinning();
            ((MainActivity) getActivity()).popDialog(mode, score, msg);
        }

        if (btn1.getTag().equals("Open") && btn2.getTag().equals("Open") && btn3.getTag().equals("Open")
                && btn4.getTag().equals("Open") && btn5.getTag().equals("Open") && btn6.getTag().equals("Open")
                && btn7.getTag().equals("Open") && btn8.getTag().equals("Open") && btn9.getTag().equals("Open")
                && btn10.getTag().equals("Open") && btn11.getTag().equals("Open") && btn12.getTag().equals("Open")
                && btn13.getTag().equals("Open") && btn14.getTag().equals("Open") && btn15.getTag().equals("Open")
                && btn16.getTag().equals("Open") && btn17.getTag().equals("Open") && btn18.getTag().equals("Open")
                && btn19.getTag().equals("Open") && btn20.getTag().equals("Open")) {

            stage++;
            Toast.makeText(getContext(), "STAGE-" + stage, Toast.LENGTH_SHORT).show();

            reset();
        }

    } // end of checkwin

    protected void reset() {
        shuffle();
        ImageButton[] tombols = new ImageButton[] {
                btn1, btn2, btn3, btn4, btn5,
                btn6, btn7, btn8, btn9, btn10,
                btn11, btn12, btn13, btn14, btn15,
                btn16, btn17, btn18, btn19, btn20};
        turn += 20;
        txtTurn.setText(turn + "");
        //set buttons tag
        btn1.setTag("Closed");  btn2.setTag("Closed");
        btn3.setTag("Closed");  btn4.setTag("Closed");
        btn5.setTag("Closed");  btn6.setTag("Closed");
        btn7.setTag("Closed");  btn8.setTag("Closed");
        btn9.setTag("Closed");  btn10.setTag("Closed");

        btn11.setTag("Closed"); btn12.setTag("Closed");
        btn13.setTag("Closed"); btn14.setTag("Closed");
        btn15.setTag("Closed"); btn16.setTag("Closed");
        btn17.setTag("Closed"); btn18.setTag("Closed");
        btn19.setTag("Closed"); btn20.setTag("Closed");

        for (final ImageButton tombol : tombols) {
            tombol.setBackgroundResource(R.drawable.card);
            tombol.setImageResource(default_bg_pic);
            tombol.setClickable(true);

            tombol.setScaleX(scale);
            final Handler handlerreset = new Handler();
            handlerreset.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tombol.setScaleX(scale * 2);
                }
            }, 50);
        }
        long sisa;
        sisa = TimerMundur.getSisawaktu();
        timer.cancel();
        timer = new TimerMundur(sisa + 20000, 1000, txtTime) {
            @Override
            public void onFinish() {
                super.onFinish();
                unclickable();
                message();
                progressWheel.stopSpinning();
                Toast.makeText(getContext(), "TIME's UP!", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).popDialog(mode, score, msg);
            }
        };
        timer.start();

    }

    // result message
    protected void message() {
        if (score == 1275)
            msg = "PERFECT!";
        else if (score < 1275 && score >= 600)
            msg = "AWESOME";
        else if (score < 600 && score >= 100)
            msg = "GREAT JOB";
        else
            msg = "GOOD GAME";
    } //end of message

    // score multiplier
    protected void multiplier() {
        if (multi == true) {
            point *= 2;
            score += point;
            txtScore.setText(score + "");
        } else {
            point = 5;
            score += point;
            txtScore.setText(score + "");
            multi = true;
        }
    }

    protected void unclickable() {
        btn1.setClickable(false);        btn2.setClickable(false);
        btn3.setClickable(false);        btn4.setClickable(false);
        btn5.setClickable(false);        btn6.setClickable(false);
        btn7.setClickable(false);        btn8.setClickable(false);
        btn9.setClickable(false);        btn10.setClickable(false);

        btn11.setClickable(false);        btn12.setClickable(false);
        btn13.setClickable(false);        btn14.setClickable(false);
        btn15.setClickable(false);        btn16.setClickable(false);
        btn17.setClickable(false);        btn18.setClickable(false);
        btn19.setClickable(false);        btn20.setClickable(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        bg_music.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        bg_music.start();
    }
}
