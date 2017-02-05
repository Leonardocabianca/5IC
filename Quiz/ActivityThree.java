package com.example.andreamolena.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityThree extends AppCompatActivity {
    RadioGroup rg1;
    RadioButton rb;
    RadioButton rbtn2;
    RadioButton rbtn4;
    RadioButton rbtn5;
    RadioButton rbtn7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Button check = (Button) findViewById(R.id.score);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rbtn2 = (RadioButton) findViewById(R.id.radioButton2);
        rbtn4 = (RadioButton) findViewById(R.id.radioButton4);
        rbtn5 = (RadioButton) findViewById(R.id.radioButton5);
        rbtn7 = (RadioButton) findViewById(R.id.radioButton7);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rbtn2.isChecked() && rbtn4.isChecked() && rbtn5.isChecked() && rbtn7.isChecked()){
                    Intent i = new Intent();
                    i.putExtra("giusto","1");
                    ActivityThree.this.setResult(RESULT_OK,i);
                    ActivityThree.this.finish();
                }else{
                    Intent i = new Intent();
                    i.putExtra("giusto","2");
                    ActivityThree.this.setResult(RESULT_OK,i);
                    ActivityThree.this.finish();
                }

            }


        });


    }

    public void rbclick(View view) {
        int radioButtonId = rg1.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radioButtonId);
    }
}