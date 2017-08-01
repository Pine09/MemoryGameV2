package com.example.mg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mg.Model.score;

import org.w3c.dom.Text;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;

public class HighScoreActivity extends AppCompatActivity {
    private Realm realm;
    private TextView txtscorecm1,txtscorecm2,txtscorecm3,txtscorecm4,txtscorecm5;
    private TextView txtscorerm1,txtscorerm2,txtscorerm3,txtscorerm4,txtscorerm5;
    private TextView txtnamecm1,txtnamecm2,txtnamecm3,txtnamecm4,txtnamecm5;
    private TextView txtnamerm1,txtnamerm2,txtnamerm3,txtnamerm4,txtnamerm5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        realm=realm.getDefaultInstance();

        // Score ChallangeMode
        txtscorecm1=(TextView)findViewById(R.id.scoreCM1);
        txtscorecm2=(TextView)findViewById(R.id.scoreCM2);
        txtscorecm3=(TextView)findViewById(R.id.scoreCM3);
        txtscorecm4=(TextView)findViewById(R.id.scoreCM4);
        txtscorecm5=(TextView)findViewById(R.id.scoreCM5);
        // Name ChallangeMode
        txtnamecm1=(TextView)findViewById(R.id.nameCM1);
        txtnamecm2=(TextView)findViewById(R.id.nameCM2);
        txtnamecm3=(TextView)findViewById(R.id.nameCM3);
        txtnamecm4=(TextView)findViewById(R.id.nameCM4);
        txtnamecm5=(TextView)findViewById(R.id.nameCM5);
        // Score RelaxMode
        txtscorerm1=(TextView)findViewById(R.id.scoreRM1);
        txtscorerm2=(TextView)findViewById(R.id.scoreRM2);
        txtscorerm3=(TextView)findViewById(R.id.scoreRM3);
        txtscorerm4=(TextView)findViewById(R.id.scoreRM4);
        txtscorerm5=(TextView)findViewById(R.id.scoreRM5);
        // Name RelaxMode
        txtnamerm1=(TextView)findViewById(R.id.nameRM1);
        txtnamerm2=(TextView)findViewById(R.id.nameRM2);
        txtnamerm3=(TextView)findViewById(R.id.nameRM3);
        txtnamerm4=(TextView)findViewById(R.id.nameRM4);
        txtnamerm5=(TextView)findViewById(R.id.nameRM5);

        addsampledata();
        loadscore();
    }

    // untuk load higscore
    private void loadscore(){
        TextView[] scorerm=new TextView[]{txtscorerm1,txtscorerm2,txtscorerm3,txtscorerm4,txtscorerm5};
        TextView[] scorecm=new TextView[]{txtscorecm1,txtscorecm2,txtscorecm3,txtscorecm4,txtscorecm5};
        TextView[] namecm=new TextView[]{txtnamecm1,txtnamecm2,txtnamecm3,txtnamecm4,txtnamecm5};
        TextView[] namerm=new TextView[]{txtnamerm1,txtnamerm2,txtnamerm3,txtnamerm4,txtnamerm5};
        RealmResults<score> challenge=realm.where(score.class).contains("mode","Challange").findAllSorted("score", Sort.DESCENDING);
        RealmResults<score> relax=realm.where(score.class).contains("mode","Relax").findAllSorted("score",Sort.DESCENDING);
        int relaxsize=relax.size();
        int cmsize=challenge.size();
        if(cmsize>5){
            cmsize=5;
        }
        if (relaxsize>5){
            relaxsize=5;
        }
        if(cmsize!=0){
            for (int i=1;i<=cmsize;i++){
                String nama=challenge.get(i-1).getName();
                int nilai=challenge.get(i-1).getScore();
                scorecm[i-1].setText(nilai+"");
                namecm[i-1].setText(nama+"");
            }
        }
       if(relaxsize!=0){
           for (int i=1;i<=relaxsize;i++){
               String nama=relax.get(i-1).getName();
               int nilai=relax.get(i-1).getScore();
               scorerm[i-1].setText(nilai+"");
               namerm[i-1].setText(nama+"");
           }
       }



    }
    public void addsampledata(){
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                score sample=realm.createObject(score.class,1);
//                sample.setName("ALX");
//                sample.setMode("Challange");
//                sample.setScore(25000);
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
