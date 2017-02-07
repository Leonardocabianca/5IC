package com.example.michael.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Quiz1 extends AppCompatActivity {

    ArrayList<question> question = new ArrayList<>();
    int questN = 0;
    TextView t;
    int wrongAnswers = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        question.add(new question("Domanda1",false));
        question.add(new question("Domanda2",true));
        question.add(new question("Domanda3",true));
        question.add(new question("Domanda4",false));
        question.add(new question("Domanda5",true));
        question.add(new question("Domanda6",true));
        t = (TextView)findViewById(R.id.question);
        t.setText(question.get(questN).question);
    }



    private void endTest() {
        Intent i = new Intent();
        if(wrongAnswers/2 > question.size())
            i.putExtra("passed",false);
        else
            i.putExtra("passed",true);
        this.setResult(RESULT_OK, i);
        this.finish();

    }

    public void onAnswerTrue(View view) {
        if(questN<question.size()) {
            if(!question.get(questN).answer)
                wrongAnswers++;
            questN++;
            t.setText(question.get(questN).question);
        }
        else
        {
            endTest();
        }
    }

    public void onAnswerFalse(View view) {
        if(questN<question.size()) {
            if(question.get(questN).answer)
                wrongAnswers++;
            questN++;
            t.setText(question.get(questN).question);
        }
        else
        {
            endTest();
        }
    }
}
