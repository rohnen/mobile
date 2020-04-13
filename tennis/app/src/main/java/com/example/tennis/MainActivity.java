package com.example.tennis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera = (Button)findViewById(R.id.button3);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhotoActivity();
            }
        });

    }
    public void openActivity2 (View view){
        startActivity(new Intent(this, SecondActivity.class));
    }
    public void openPhotoActivity (){
        Intent intent = new Intent (this, PhotoActivity.class);
        startActivity(intent);
    }
}
