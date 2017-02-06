package com.example.lucabassanello.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static int QUIZ_ONE=1;
    private final static int QUIZ_TWO=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.quiz1);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActivityTwo.class);
                startActivityForResult(i, QUIZ_ONE);
            }
        });
        Button b2 = (Button) findViewById(R.id.quiz2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActivityThree.class);
                startActivityForResult(i, QUIZ_TWO);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == QUIZ_ONE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getBaseContext(),data.getStringExtra("risultato"),Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == QUIZ_TWO) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getBaseContext(),data.getStringExtra("risultato"),Toast.LENGTH_SHORT).show();

            }
        }
    }
}
