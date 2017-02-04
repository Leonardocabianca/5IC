package com.swapnil.thequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Swapnil Paul.
 */
public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt = (EditText) findViewById(R.id.editTxt);


        ((Button) findViewById(R.id.button01)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edt.getText().length()!=0){
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                Bundle b = new Bundle();
                b.putString("user", edt.getText().toString());
                b.putInt("val",1);
                intent.putExtras(b);
                startActivityForResult(intent,1);
                    edt.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "inserire un username", Toast.LENGTH_SHORT).show();
                }



            }
        });

        ((Button) findViewById(R.id.button02)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edt.getText().length()!=0){
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                Bundle b = new Bundle();
                b.putString("user", edt.getText().toString());
                b.putInt("val",2);
                intent.putExtras(b);
                startActivityForResult(intent,1);
                    edt.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "inserire un username", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ((Button) findViewById(R.id.btnRank)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, RankActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // check if the request code is 1 (we came from 1 ... )
            if (resultCode == RESULT_OK) {
                // data passed in using getStringExtra() via Intent data
                String res = data.getStringExtra("res");
                String user = data.getStringExtra("user");
                if(res.equals("ok")) {
                    Toast.makeText(this, user  + " hai passato il quiz correttamente!!",
                            Toast.LENGTH_SHORT).show();
                }else if(res.equals("noOk")) {
                    Toast.makeText(this, user + " NON Hai passato il quiz correttamente!!",
                            Toast.LENGTH_SHORT).show();
                }

            }

    }
}
