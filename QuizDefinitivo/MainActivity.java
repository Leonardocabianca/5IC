package com.example.tommaso.quizandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView re;
    TextView rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById((R.id.button2));

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActivityTwo.class);
                startActivityForResult(i, 1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActivityThree.class);
                startActivityForResult(i, 1);
            }
        });
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        re = (TextView) findViewById(R.id.re);
        rs = (TextView) findViewById(R.id.rs);

        int risposteEsatte = data.getExtras().getInt("a");
        int risposteSbagliate = data.getExtras().getInt("b");

        re.setText("Risposte esatte: "+ risposteEsatte);
        rs.setText("Risposte sbagliate: "+ risposteSbagliate);
        }
}
