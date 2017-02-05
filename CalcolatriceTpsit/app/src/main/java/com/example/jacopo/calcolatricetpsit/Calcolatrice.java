package com.example.jacopo.calcolatricetpsit;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calcolatrice extends Activity {



    public class Calc extends Activity implements View.OnClickListener {
        //CAMBIARE IL NOME DELLE VARIABILI + COMMENTARE OPERAZIONI IMPORTANTI
        Button uno, due, tre, quattro, cinque, sei, sette, otto, nove, zero, addizione, sottrazione, moltiplicazione, divisione, cancella, uguale;
        EditText display;
        int operando1;
        int operando2;
        String operazione;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calcolatrice);

            uno = (Button) findViewById(R.id.uno);
            due = (Button) findViewById(R.id.due);
            tre = (Button) findViewById(R.id.tre);
            quattro = (Button) findViewById(R.id.quattro);
            cinque = (Button) findViewById(R.id.cinque);
            sei = (Button) findViewById(R.id.sei);
            sette = (Button) findViewById(R.id.sette);
            otto = (Button) findViewById(R.id.otto);
            nove = (Button) findViewById(R.id.nove);
            zero = (Button) findViewById(R.id.zero);
            addizione = (Button) findViewById(R.id.add);//Somma
            sottrazione = (Button) findViewById(R.id.sub);//sottrazione
            moltiplicazione = (Button) findViewById(R.id.mul);//Moltiplicazione
            divisione = (Button) findViewById(R.id.div);//Divisione
            cancella = (Button) findViewById(R.id.cancella);//Cancella numero
            uguale = (Button) findViewById(R.id.uguale);//Risultato
            display = (EditText) findViewById(R.id.display);

            try {
                uno.setOnClickListener(this);
                due.setOnClickListener(this);
                tre.setOnClickListener(this);
                quattro.setOnClickListener(this);
                cinque.setOnClickListener(this);
                sei.setOnClickListener(this);
                sette.setOnClickListener(this);
                otto.setOnClickListener(this);
                nove.setOnClickListener(this);
                zero.setOnClickListener(this);
                cancella.setOnClickListener(this);
                addizione.setOnClickListener(this);
                sottrazione.setOnClickListener(this);
                moltiplicazione.setOnClickListener(this);
                divisione.setOnClickListener(this);
                uguale.setOnClickListener(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void operatione() {
            if (operazione.equals("+")) {
                operando2 = Integer.parseInt(display.getText().toString());
                display.setText("");
                operando1 = operando1 + operando2;
                display.setText("Result : " + Integer.toString(operando1));
            } else if (operazione.equals("-")) {
                operando2 = Integer.parseInt(display.getText().toString());
                display.setText("");
                operando1 = operando1 - operando2;
                display.setText("Result : " + Integer.toString(operando1));
            } else if (operazione.equals("*")) {
                operando2 = Integer.parseInt(display.getText().toString());
                display.setText("");
                operando1 = operando1 * operando2;
                display.setText("Result : " + Integer.toString(operando1));
            } else if (operazione.equals("/")) {
                operando2 = Integer.parseInt(display.getText().toString());
                display.setText("");
                operando1 = operando1 / operando2;
                display.setText("Result : " + Integer.toString(operando1));
            }
        }

        @Override
        public void onClick(View arg0) {
            Editable str = display.getText();
            switch (arg0.getId()) {
                case R.id.uno:
                    if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    }
                    str = str.append(due.getText());
                    display.setText(str);
                    break;
                case R.id.due:
                    if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    }
                    str = str.append(due.getText());
                    display.setText(str);
                    break;
                case R.id.tre:
                    if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    }
                    str = str.append(tre.getText());
                    display.setText(str);
                    break;
                case R.id.quattro:
                    if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    }
                    str = str.append(quattro.getText());
                    display.setText(str);
                    break;
                case R.id.cinque:
                    if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    }
                    str = str.append(cinque.getText());
                    display.setText(str);
                    break;
                case R.id.sei:
                    if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    }
                    str = str.append(sei.getText());
                    display.setText(str);
                    break;
                case R.id.sette:
                    if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    }
                    str = str.append(otto.getText());
                    display.setText(str);
                    break;
                case R.id.otto:
                    if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    }
                    str = str.append(nove.getText());
                    display.setText(str);
                    break;
                case R.id.nove:
                    if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    }
                    str = str.append(zero.getText());
                    display.setText(str);
                    break;
                case R.id.cancella:
                    operando1 = 0;
                    operando2 = 0;
                    display.setText("");
                    display.setHint("Perform Operation :)");
                    break;
                case R.id.add:
                    operazione = "+";
                    if (operando1 == 0) {
                        operando1 = Integer.parseInt(display.getText().toString());
                        display.setText("");
                    } else if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    } else {
                        operando2 = Integer.parseInt(display.getText().toString());
                        display.setText("");
                        operando1 = operando1 + operando2;
                        display.setText("Result : " + Integer.toString(operando1));
                    }
                    break;
                case R.id.sub:
                    operazione = "-";
                    if (operando1 == 0) {
                        operando1 = Integer.parseInt(display.getText().toString());
                        display.setText("");
                    } else if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    } else {
                        operando2 = Integer.parseInt(display.getText().toString());
                        display.setText("");
                        operando1 = operando1 - operando2;
                        display.setText("Result : " + Integer.toString(operando1));
                    }
                    break;
                case R.id.mul:
                    operazione = "*";
                    if (operando1 == 0) {
                        operando1 = Integer.parseInt(display.getText().toString());
                        display.setText("");
                    } else if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    } else {
                        operando2 = Integer.parseInt(display.getText().toString());
                        display.setText("");
                        operando1 = operando1 * operando2;
                        display.setText("Result : " + Integer.toString(operando1));
                    }
                    break;
                case R.id.div:
                    operazione = "/";
                    if (operando1 == 0) {
                        operando1 = Integer.parseInt(display.getText().toString());
                        display.setText("");
                    } else if (operando2 != 0) {
                        operando2 = 0;
                        display.setText("");
                    } else {
                        operando2 = Integer.parseInt(display.getText().toString());
                        display.setText("");
                        operando1= operando1 / operando2;
                        display.setText("Result : " + Integer.toString(operando1));
                    }
                    break;
                case R.id.uguale:
                    if (!operazione.equals(null)) {
                        if (operando2 != 0) {
                            if (operazione.equals("+")) {
                                display.setText(""); /*op1 = op1 + op2;*/
                                display.setText("Result : " + Integer.toString(operando1));
                            } else if (operazione.equals("-")) {
                                display.setText("");/* op1 = op1 - op2;*/
                                display.setText("Result : " + Integer.toString(operando1));
                            } else if (operazione.equals("*")) {
                                display.setText("");/* op1 = op1 * op2;*/
                                display.setText("Result : " + Integer.toString(operando1));
                            } else if (operazione.equals("/")) {
                                display.setText("");/* op1 = op1 / op2;*/
                                display.setText("Result : " + Integer.toString(operando1));
                            }
                        } else {
                            operatione();
                        }
                    }
                    break;
            }
        }
    }
}
