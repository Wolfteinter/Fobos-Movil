package com.example.wolfteinter.fobosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //btnQuejas.setOnClickListener(this);


        Intent i = new
                Intent(MainActivity.this,dashboard.class);
        startActivity(i);
    }

   /* @Override
    public void onClick(View view) {
        if(view.getId()==R.id.quejas){
            Intent i = new
                    Intent(MainActivity.this,queja.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.sug){

            Intent i = new
                    Intent(MainActivity.this,dashboard.class);
            startActivity(i);
        }
    }*/
}
