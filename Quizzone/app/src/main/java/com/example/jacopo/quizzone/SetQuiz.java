package com.example.jacopo.quizzone;


import android.support.v7.app.AppCompatActivity;


public class SetQuiz extends AppCompatActivity {
    private int ID;
    private String DOMANDA;
    private String OPZIONEA;
    private String OPZIONEB;
    private String OPZIONEC;
    private String RISPOSTA;

    public SetQuiz() {
        ID = 0;
        DOMANDA = "";
        OPZIONEA = "";
        OPZIONEB = "";
        OPZIONEC = "";
        RISPOSTA = "";
    }

    public SetQuiz(String Domanda, String OpzioneA, String OpzioneB, String OpzioneC, String Risposta) {
        DOMANDA = Domanda;
        OPZIONEA = OpzioneA;
        OPZIONEB = OpzioneB;
        OPZIONEC = OpzioneC;
        RISPOSTA = Risposta;
    }

    public int getID() {
        return ID;
    }

    public String getQUESTION() {
        return DOMANDA;
    }

    public String getOPTA() {
        return OPZIONEA;
    }

    public String getOPTB() {
        return OPZIONEB;
    }

    public String getOPTC() {
        return OPZIONEC;
    }

    public String getANSWER() {
        return RISPOSTA;
    }

    public void setID(int id) {
        ID = id;
    }

    public void setQUESTION(String Domanda) {
        DOMANDA = Domanda;
    }

    public void setOPTA(String OPTA) {
        OPZIONEA = OPTA;
    }

    public void setOPTB(String OPTB) {
        OPZIONEB = OPTB;
    }

    public void setOPTC(String OPTC) {
        OPZIONEC = OPTC;
    }

    public void setANSWER(String ANSWER) {
        RISPOSTA = ANSWER;
    }

}
