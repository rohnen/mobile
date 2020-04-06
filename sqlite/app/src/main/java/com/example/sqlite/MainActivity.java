package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Database myDb;
    EditText buteur;
    EditText passeur;
    Button btnaddData1;
    Button btnaddData2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new Database(this);

        buteur = (EditText)findViewById(R.id.buteur);
        passeur = (EditText)findViewById(R.id.passeurs);
        btnaddData1 = (Button)findViewById(R.id.btn_equipe1);
        btnaddData2 = (Button)findViewById(R.id.btn_equipe2);
        addequipe1();
    }
    public void addequipe1(){
        btnaddData1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = myDb.insertequipe1(buteur.getText().toString(),passeur.getText().toString());
                if (inserted == true){
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                    buteur.setText(null);
                    passeur.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
        });
    }
}
