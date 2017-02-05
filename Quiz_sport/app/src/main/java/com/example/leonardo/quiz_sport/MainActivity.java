package com.example.leonardo.quiz_sport;


import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.content.Intent;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_ACTIVITY_TWO= 2;
    static final int REQUEST_ACTIVITY_THREE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.bottonequiz);
        Button b2 = (Button) findViewById(R.id.bottoneplayer);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q = new Intent(MainActivity.this, Activity2.class);
                startActivityForResult(q, REQUEST_ACTIVITY_TWO);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View m) {
                Intent q = new Intent(MainActivity.this, Activity3.class);
                startActivityForResult(q, REQUEST_ACTIVITY_THREE);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_ACTIVITY_TWO){
            if (resultCode==RESULT_OK){
                String result = data.getStringExtra("corretto");
                if(result.equals("2"))
                    Toast.makeText(this, "Hai completato correttamente il quiz", Toast.LENGTH_LONG).show();
                if (result.equals("3")){
                    Toast.makeText(this, "Non hai completato il quiz", Toast.LENGTH_LONG).show();
                }
            }


        }

        if (requestCode == REQUEST_ACTIVITY_THREE){
            if (resultCode==RESULT_OK){
                String result = data.getStringExtra("corretto");
                if(result.equals("2"))
                    Toast.makeText(this, "Hai completato correttamente il quiz", Toast.LENGTH_LONG).show();
                if (result.equals("3")){
                    Toast.makeText(this, "Non hai completato il quiz", Toast.LENGTH_LONG).show();
                }
            }

        }
    }
}
