package com.example.leonardo.quiz_sport;


import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioButton;


public class Activity3 extends AppCompatActivity {



    public class Activity_Three extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_3);

            final RadioButton vero1 = (RadioButton) findViewById(R.id.rtrue1);
            final RadioButton falso1 = (RadioButton) findViewById(R.id.rfalse1);
            final RadioButton vero2 = (RadioButton) findViewById(R.id.rtrue2);
            final RadioButton falso2 = (RadioButton) findViewById(R.id.rfalse2);
            final RadioButton vero3 = (RadioButton) findViewById(R.id.rtrue3);
            final RadioButton falso3 = (RadioButton) findViewById(R.id.rfalse3);
            final RadioButton vero4 = (RadioButton) findViewById(R.id.rtrue4);
            final RadioButton falso4 = (RadioButton) findViewById(R.id.rfalse4);

            Button fine = (Button)findViewById(R.id.buttonExit1);
            fine.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    if (vero1.isChecked() && vero2.isChecked() && falso3.isChecked() && vero4.isChecked()){
                        Intent i = new Intent();
                        i.putExtra("corretto", "2");
                        Activity_Three.this.setResult(RESULT_OK, i);
                        Activity_Three.this.finish();

                    } else{
                        Intent i = new Intent();
                        i.putExtra("corretto","3");
                        Activity_Three.this.setResult(RESULT_OK, i);
                        Activity_Three.this.finish();
                    }

                }
            });
        }
    }

}

