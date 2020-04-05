package com.example.sql;

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
        btnaddData1 = (Button)findViewById(R.id.but_buteur);
        btnaddData2 = (Button)findViewById(R.id.btn_passeur);
        add();
    }
    public void add(){
        btnaddData1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = myDb.insertbuteur(buteur.getText().toString());
                if (inserted == true){
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                    buteur.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
        });
        btnaddData2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = myDb.insertpasseur(passeur.getText().toString());
                if (inserted == true){
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                    passeur.setText(null);
                }
                else
                    Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();

            }
        });
    }
}
