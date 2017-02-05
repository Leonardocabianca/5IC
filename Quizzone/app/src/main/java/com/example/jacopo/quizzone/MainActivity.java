package com.example.jacopo.quizzone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by JACOPO on 27/01/2017.
 */

public class MainActivity extends AppCompatActivity {
    private Button quiz1;
    private Button quiz2;
    static final int REQUEST_ACTIVITY_TWO=2;
    static final int REQUEST_ACTIVITY_THREE=3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activiy);
        quiz1=(Button)findViewById(R.id.button1);
        quiz1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this, QuizActivity1.class);
                startActivity(intent);
            }
        });
        quiz2=(Button)findViewById(R.id.button2);
        quiz2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this, QuizActivity1.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_ACTIVITY_TWO){
            if(resultCode==RESULT_OK){
                String result=data.getStringExtra("Corretto");
                if (result.equals("10"))
                    Toast.makeText(this, "Hai risposto correttamente a tutte le domande del primo quiz!", Toast.LENGTH_LONG).show();
                if (result.equals(("9")))
                    Toast.makeText(this, "Ehi ehi ehi hai sbagliato qualcosa!", Toast.LENGTH_LONG).show();
            }
        }
        if(requestCode == REQUEST_ACTIVITY_THREE){
            if(resultCode==RESULT_OK){
                String result=data.getStringExtra("Corretto");
                if (result.equals("10"))
                    Toast.makeText(this, "Hai risposto correttamente a tutte le domande del primo quiz!", Toast.LENGTH_LONG).show();
                if (result.equals(("9")))
                    Toast.makeText(this, "Ehi ehi ehi hai sbagliato qualcosa!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
