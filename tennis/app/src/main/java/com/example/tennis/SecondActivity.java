package com.example.tennis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Button StartMatch;
    EditText Joueur1;
    EditText Joueur2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        myDb = new DatabaseHelper(this);

        Joueur1 = (EditText)findViewById(R.id.Joueur1);
        Joueur2 = (EditText)findViewById(R.id.Joueur2);
        StartMatch = (Button)findViewById(R.id.btn_match);
        Page3();
    }

    public void Page3(){
        StartMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = myDb.insertnomJoueur(Joueur1.getText().toString(),Joueur2.getText().toString());
                if (inserted == true){
                    Toast.makeText(SecondActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                    Joueur1.setText(null);
                    Joueur2.setText(null);
                    openActivityThird();
                }
                else
                    Toast.makeText(SecondActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void openActivityThird (){
        startActivity(new Intent(this, ThirdActivity.class));
    }


}
