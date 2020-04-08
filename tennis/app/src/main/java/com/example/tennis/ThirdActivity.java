package com.example.tennis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    EditText score1;
    EditText score2;
    Button point1;
    Button faute1;
    Button fautepro1;
    Button point2;
    Button faute2;
    Button fautepro2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        score1 = (EditText) findViewById(R.id.score1);
        score2 = (EditText) findViewById(R.id.score2);
        point1 = (Button)findViewById(R.id.btn1_1);
        faute1 = (Button)findViewById(R.id.btn1_2);
        fautepro1 = (Button)findViewById(R.id.btn1_3);
        point2 = (Button)findViewById(R.id.btn2_1);
        faute2 = (Button)findViewById(R.id.btn2_2);
        fautepro2 = (Button)findViewById(R.id.btn2_3);




        point1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String score = score1.getText().toString();
                String score_2 = score2.getText().toString();
                Integer sc = Integer.valueOf(score);
                Integer sc2 = Integer.valueOf(score_2);

                if (sc == 0){
                    score1.setText("15");
                }
                if (sc == 15){
                    score1.setText("30");
                }
                if (sc == 30){
                    score1.setText("40");
                }
                if (sc == 40 && sc2 == 40){
                    score1.setText("AD");
                }
                else if (sc == 40 && sc2 == 30){
                    score1.setText("WIN");
                }
                else if (sc == 40 && sc2== 15){
                    score1.setText("WIN");
                }
                else if (sc == 40 && sc2 == 0){
                    score1.setText("WIN");
                }
                if (score == "AD"){
                    score1.setText("WIN");
                }
            }
        });
        point2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String score = score1.getText().toString();
                String score_2 = score2.getText().toString();
                Integer sc = Integer.valueOf(score);
                Integer sc2 = Integer.valueOf(score_2);

                if (sc2 == 0){
                    score2.setText("15");
                }
                if (sc2 == 15){
                    score2.setText("30");
                }
                if (sc2 == 30){
                    score2.setText("40");
                }
                if (sc2 == 40 && sc == 40){
                    score2.setText("AD");
                }
                else if (sc2 == 40 && sc == 30){
                    score2.setText("WIN");
                }
                else if (sc2 == 40 && sc == 15){
                    score2.setText("WIN");
                }
                else if (sc2 == 40 && sc == 0){
                    score2.setText("WIN");
                }
                if (score == "AD"){
                    score2.setText("WIN");
                }
            }
        });
    }
}
