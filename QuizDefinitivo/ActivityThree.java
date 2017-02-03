package com.example.tommaso.quizandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityThree extends AppCompatActivity {
    RadioGroup rg;

    RadioButton rb;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb6;

    int risposteEsatte=0;
    int risposteSbagliate=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        rg = (RadioGroup) findViewById(R.id.rgroup);

        rb2 = (RadioButton) findViewById((R.id.rb2));
        rb3 = (RadioButton) findViewById((R.id.rb3));
        rb6 = (RadioButton) findViewById((R.id.rb6));

        Button finish = (Button) findViewById(R.id.finish);
        Button correggi = (Button) findViewById(R.id.correggi);


            finish.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent i = new Intent(ActivityThree.this, MainActivity.class);
                    startActivity(i);
                }
            });


        correggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rb2.isChecked()==true)
                    risposteEsatte++;
                else
                    risposteSbagliate++;

                if (rb3.isChecked()==true)
                    risposteEsatte++;
                else
                    risposteSbagliate++;

                if (rb6.isChecked()==true)
                    risposteEsatte++;
                else
                    risposteSbagliate++;

                Intent i = new Intent(ActivityThree.this, MainActivity.class);
                Bundle extras = new Bundle();
                extras.putInt("a", risposteEsatte);
                extras.putInt("b", risposteSbagliate);
                i.putExtras(extras);
                ActivityThree.this.setResult(2, i);
                ActivityThree.this.finish();
            }

        });
    }

    public void rbclick (View view) {
        int radioButtonId = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radioButtonId);
    }
}
