package com.example.andreamolena.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityTwo extends AppCompatActivity {
    RadioGroup rg1;
    RadioButton rb;
    RadioButton rbtn1;
    RadioButton rbtn4;
    RadioButton rbtn6;
    RadioButton rbtn8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Button check = (Button) findViewById(R.id.score);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rbtn1 = (RadioButton) findViewById(R.id.radioButton1);
        rbtn4 = (RadioButton) findViewById(R.id.radioButton4);
        rbtn6 = (RadioButton) findViewById(R.id.radioButton6);
        rbtn8 = (RadioButton) findViewById(R.id.radioButton8);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbtn1.isChecked() && rbtn4.isChecked() && rbtn6.isChecked() && rbtn8.isChecked()){
                    Intent i = new Intent();
                    i.putExtra("giusto","1");
                    ActivityTwo.this.setResult(RESULT_OK,i);
                    ActivityTwo.this.finish();
                }else{
                    Intent i= new Intent();
                    i.putExtra("giusto","2");
                    ActivityTwo.this.setResult(RESULT_OK,i);
                    ActivityTwo.this.finish();
                }

            }


        });


    }
    public void rbclick(View view) {
        int radioButtonId = rg1.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radioButtonId);
    }
}