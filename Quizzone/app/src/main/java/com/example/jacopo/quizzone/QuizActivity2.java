package com.example.jacopo.quizzone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by JACOPO on 27/01/2017.
 */

public class QuizActivity2 extends Activity {
    List<SetQuiz> questionList;
    int score = 0;
    int qid = 0;
    SetQuiz currentQuestion;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button button_To_Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_1);
        DatabaseHelper db = new DatabaseHelper(this);
        questionList = db.getAllQuestions2();
        currentQuestion = questionList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.textView1);
        rda = (RadioButton) findViewById(R.id.radio0);
        rdb = (RadioButton) findViewById(R.id.radio1);
        rdc = (RadioButton) findViewById(R.id.radio2);
        button_To_Next = (Button) findViewById(R.id.button1);
        setQuestionView();
        button_To_Next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                Log.d("Your answer", currentQuestion.getANSWER() + " " + answer.getText());
                if (currentQuestion.getANSWER().equals(answer.getText())) {
                    score++;
                    Log.d("Score", "Your score" + score);
                }
                if (qid < 5) {
                    currentQuestion = questionList.get(qid);
                    setQuestionView();
                } else {
                    if(score==5){
                        Intent intent = new Intent();
                        intent.putExtra("Corretto", "10");
                        QuizActivity2.this.setResult(RESULT_OK, intent);
                        QuizActivity2.this.finish();
                    }else{
                        Intent intent = new Intent();
                        intent.putExtra("Corretto", "9");
                        QuizActivity2.this.setResult(RESULT_OK, intent);
                        QuizActivity2.this.finish();
                    }
                }
            }
        });
    }

    private void setQuestionView() {
        txtQuestion.setText(currentQuestion.getQUESTION());
        rda.setText(currentQuestion.getOPTA());
        rdb.setText(currentQuestion.getOPTB());
        rdc.setText(currentQuestion.getOPTC());
        qid++;
    }
}
