package com.example.andreamolena.quiz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    static final int REQUEST_TWO=1;
    static final int REQUEST_THREE=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button primoQuiz = (Button) findViewById(R.id.primoQuiz);
        Button secondoQuiz = (Button) findViewById(R.id.secondoQuiz);


        primoQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivityTwo.class);
                startActivityForResult(i, REQUEST_TWO);
            }
        });

        secondoQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivityThree.class);
                startActivityForResult(i, REQUEST_THREE);
            }

        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUEST_TWO){
            if(resultCode == RESULT_OK){
                String fine = data.getStringExtra("giusto");
                if(fine.equals("1"))
                    Toast.makeText(this, "Hai risposto correttamente al primo QUIZ", Toast.LENGTH_LONG).show();
                if(fine.equals("2"))
                    Toast.makeText(this, "Non hai risposto correttamente al primo QUIZ", Toast.LENGTH_LONG).show();

            }

        }

        if(requestCode == REQUEST_THREE){
            if(resultCode == RESULT_OK){
                String fine = data.getStringExtra("giusto");
                if(fine.equals("1"))
                    Toast.makeText(this, "Hai risposto correttamente al secondo QUIZ", Toast.LENGTH_LONG).show();
                    if(fine.equals("2"))
                        Toast.makeText(this, "Non hai risposto correttamente al secondo QUIZ", Toast.LENGTH_LONG).show();

            }

        }

    }
}









