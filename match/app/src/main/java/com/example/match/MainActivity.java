package com.example.match;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Database myDb;
    EditText joueur;
    EditText nom;
    EditText joueur2;
    EditText nom2;
    Button btnaddData1;
    Button btnaddData2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new Database(this);

        joueur = (EditText)findViewById(R.id.joueur);
        nom = (EditText)findViewById(R.id.equipe1);
        joueur2 = (EditText)findViewById(R.id.joueur_2);
        nom2 = (EditText)findViewById(R.id.equipe2);
        btnaddData1 = (Button)findViewById(R.id.btn_equipe1);
        btnaddData2 = (Button)findViewById(R.id.btn_equipe2);
        addequipe1();
        addequipe2();
    }
    public void addequipe1(){
        btnaddData1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = myDb.insertequipe1(nom.getText().toString(),joueur.getText().toString());
                if (inserted == true){
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                    nom.setText(null);
                    joueur.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void addequipe2(){
        btnaddData2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = myDb.insertequipe2(nom2.getText().toString(),joueur2.getText().toString());
                if (inserted == true){
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                    nom2.setText(null);
                    joueur2.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
        });
    }
}
