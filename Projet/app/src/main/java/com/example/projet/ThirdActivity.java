package com.example.projet;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    Database controller;
    TextView viewEquipe1;
    TextView viewEquipe2;
    TextView viewJoueur;
    LinearLayout linear;
    CheckBox checkBox;
    ArrayList<String> al;
    ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        viewEquipe1 = (TextView) findViewById(R.id.viewEquipe1);
        viewEquipe2 = (TextView) findViewById(R.id.viewEquipe2);
        viewJoueur = (TextView) findViewById(R.id.viewJoueur);
        controller = new Database(this);
        controller.list_equipe(viewEquipe1, 2);
        controller.list_equipe(viewEquipe2, 4);
        //controller.list_joueur(viewJoueur,2);
        linear = (LinearLayout)findViewById(R.id.linear);
        al = new ArrayList<String>();
        viewdata();

        for (int i =0; i < al.size(); i++){
            checkBox = new CheckBox(this);
            checkBox.setText(al.get(i));
            linear.addView(checkBox);
        }
    }

    public void viewdata() {
        Cursor cursor = controller.viewdata();
        if (cursor.getCount()==0){
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext())
                al.add(cursor.getString(1));
        }
    }
}
