package com.example.lucabassanello.quiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.color.black;
import static android.R.color.holo_green_dark;

/**
 * Created by lucabassanello on 25/01/17.
 */

public class ActivityTwo  extends AppCompatActivity {
    private static boolean quiz1;
    private static boolean quiz2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        final int[] cont = {0};
        TextView t1= (TextView) findViewById(R.id.textView4);
        final Button b2a= (Button) findViewById(R.id.btn2a);
        final Button b1a= (Button) findViewById(R.id.btn1a);
        final Button b3a= (Button) findViewById(R.id.btn3a);
        final Button b1b= (Button) findViewById(R.id.btn1b);
        final Button b2b= (Button) findViewById(R.id.btn2b);
        final Button b3b= (Button) findViewById(R.id.btn3b);
        final Button bf= (Button) findViewById(R.id.button_last);

        b1a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b1a.setBackgroundColor(Color.RED);
                b2a.setBackgroundColor(Color.GRAY);
                b3a.setBackgroundColor(Color.GRAY);
                Toast.makeText(getBaseContext(),R.string.sbagliata,Toast.LENGTH_SHORT).show();
                quiz1=false;
            }
        });
        b2a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                b2a.setBackgroundColor(Color.GREEN);
                b1a.setBackgroundColor(Color.GRAY);
                b3a.setBackgroundColor(Color.GRAY);
                Toast.makeText(getBaseContext(),R.string.giusta,Toast.LENGTH_SHORT).show();
                quiz1=true;
            }
        });
        b3a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b3a.setBackgroundColor(Color.RED);
                b2a.setBackgroundColor(Color.GRAY);
                b1a.setBackgroundColor(Color.GRAY);
                Toast.makeText(getBaseContext(),R.string.sbagliata,Toast.LENGTH_SHORT).show();
                quiz1=false;
            }
        });
        b1b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b1b.setBackgroundColor(Color.RED);
                b2b.setBackgroundColor(Color.GRAY);
                b3b.setBackgroundColor(Color.GRAY);
                Toast.makeText(getBaseContext(),R.string.sbagliata,Toast.LENGTH_SHORT).show();
                quiz2=false;
            }
        });
        b2b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b2b.setBackgroundColor(Color.RED);
                b1b.setBackgroundColor(Color.GRAY);
                b3b.setBackgroundColor(Color.GRAY);
                Toast.makeText(getBaseContext(),R.string.sbagliata,Toast.LENGTH_SHORT).show();
                quiz2=false;
            }
        });
        b3b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b3b.setBackgroundColor(Color.GREEN);
                b1b.setBackgroundColor(Color.GRAY);
                b2b.setBackgroundColor(Color.GRAY);
                Toast.makeText(getBaseContext(),R.string.giusta,Toast.LENGTH_SHORT).show();
                quiz2=true;
            }
        });





    }
    public void closeQuiz(View nome ){
        Intent i = new Intent();

        if(quiz1==true && quiz2==true){
            i.putExtra("risultato", "hai completato correttamente il mio quiz" );
        }else{
            i.putExtra("risultato", "non hai completato correttamente il mio quiz" );
        }

        ActivityTwo.this.setResult(RESULT_OK, i);
        ActivityTwo.this.finish();
    }

}
