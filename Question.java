package com.example.giorgio.quizinternet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }
    private int ID;
    private String QUESTION;
    private String OPTIONA;
    private String OPTIONB;
    private String OPTIONC;
    private String ANSWER;
    public Question()
    {
        ID=0;
        QUESTION="";
        OPTIONA="";
        OPTIONB="";
        OPTIONC="";
        ANSWER="";
    }
    public Question(String qUESTION, String oPTA, String oPTB, String oPTC,
                    String aNSWER) {

        QUESTION = qUESTION;
        OPTIONA = oPTA;
        OPTIONB = oPTB;
        OPTIONC = oPTC;
        ANSWER = aNSWER;
    }
    public int getID() {
        return ID;
    }
    public String getQUESTION() {
        return QUESTION;
    }
    public String getOPTA() {
        return OPTIONA;
    }
    public String getOPTB() {
        return OPTIONB;
    }
    public String getOPTC() {
        return OPTIONC;
    }
    public String getANSWER() {
        return ANSWER;
    }
    public void setID(int id) {
        ID=id;
    }
    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }
    public void setOPTA(String oPTA) {
        OPTIONA = oPTA;
    }
    public void setOPTB(String oPTB) {
        OPTIONB = oPTB;
    }
    public void setOPTC(String oPTC) {
        OPTIONC = oPTC;
    }
    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }
}

