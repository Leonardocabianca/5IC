package com.example.michael.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Button1OnClick(View view) {
        Intent i = new Intent(this,Quiz1.class);
        startActivityForResult(i,0);
    }

    public void Button2OnClick(View view) {
        Intent i = new Intent(this,Quiz2.class);
        startActivityForResult(i,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        boolean QuizPassed = (boolean) data.getExtras().get("passed");
        if(QuizPassed)
            Toast.makeText(this,"Hai passato il quiz, complimenti", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Non hai passato il quiz, mi dispiace", Toast.LENGTH_SHORT).show();
    }
}
