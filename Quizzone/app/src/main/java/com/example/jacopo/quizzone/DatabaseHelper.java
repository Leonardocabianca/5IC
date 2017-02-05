package com.example.jacopo.quizzone;

/**
 * Created by JACOPO on 24/01/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSIONE_DATABASE = 1;//Versione database
    private static final String NOME_DATABASE = "triviaQuiz";//Nome database
    private static final String TABLE_SET_DOMANDE1 = "Quest1";//Tabella per la prima MainActivity
    private static final String TABLE_SET_DOMANDE2 = "Quest2";//Tabella per la secondas MainActivity
    private static final String CHIAVE_ID = "id";//Utunte che si collega al database

    //Metto l'id come auto-incrementante
    private static final String CHIAVE_DOMANDA = "Domanda";//Domanda della
    private static final String CHIAVE_RISPOSTA = "Risposta";//opzione corretts
    private static final String CHIAVE_OPZIONEA = "OpzioneA"; //Opzione a
    private static final String CHIAVE_OPZIONEB = "OpzioneB"; //Opzione b
    private static final String CHIAVE_OPZIONEC = "OpzioneC"; //Opzione c

    private SQLiteDatabase dbase;

    public DatabaseHelper(Context context) {
        super(context, NOME_DATABASE, null, VERSIONE_DATABASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Con il comando CREATE TABLE IF NOT EXIST si crea il database solo se non esiste, in caso contrario non verrà restituito alcun errore
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_SET_DOMANDE1 + " ( " + CHIAVE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CHIAVE_DOMANDA + " TEXT, " + CHIAVE_RISPOSTA + " TEXT, " + CHIAVE_OPZIONEA + " TEXT, " + CHIAVE_OPZIONEB + " TEXT, " + CHIAVE_OPZIONEC + " TEXT)";
        db.execSQL(sql);
        String sql2 = "CREATE TABLE" + TABLE_SET_DOMANDE2 + "(" + CHIAVE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CHIAVE_DOMANDA + " TEXT, " + CHIAVE_RISPOSTA + " TEXT, " + CHIAVE_OPZIONEA + " TEXT, " + CHIAVE_OPZIONEB + " TEXT, " + CHIAVE_OPZIONEC + " TEXT)";
        db.execSQL(sql2);

        //Qui popolo il database
        SetQuiz q1 = new SetQuiz("Quale azienda è il più grande produttore di apparecchiature di rete?", "HP", "IBM", "CISCO", "C");
        this.addQuestion1(q1);
        SetQuiz q2 = new SetQuiz("Quale dei seguenti non è un sistema operativo?", "SuSe", "BIOS", "DOS", "B");
        this.addQuestion1(q2);
        SetQuiz q3 = new SetQuiz("Quale dei seguenti è la memoria scrivibile più veloce?", "RAM", "FLASH", "Register", "C");
        this.addQuestion1(q3);
        SetQuiz q4 = new SetQuiz("Quale dei seguenti dispositivo regola il traffico internet?", "Router", "Bridge", "Hub", "A");
        this.addQuestion1(q4);
        SetQuiz q5 = new SetQuiz("Quale dei seguenti NON è un linguaggio interpretato?", "Ruby", "Python", "BASIC", "C");
        this.addQuestion1(q5);

        q1 = new SetQuiz("Chi è il principe dei Sayan?", "Vegeta", "Goku", "Il DigiPrescelto", "A");
        this.addQuestion2(q1);
        q2 = new SetQuiz("Chi fu il primo Gran maestro del ordine degli assassini in 'Assassin's creed'?", "Ezio Auditore", "Altair", "Non so..", "B");
        this.addQuestion1(q2);
        q3 = new SetQuiz("La bicicletta ha due ruote?", "Si", "No", "Non ci ho mai fatto caso", "A");
        this.addQuestion1(q3);
        q4 = new SetQuiz("Nella famosa collana di libri 'A Game of throne' quali di queste casate è attualmente al potere?", "Stark", "Lannister", "Tully", "B");
        this.addQuestion1(q4);
        q5 = new SetQuiz("Quanto fa 15 + 18?", "36", "33", "11", "B");
        this.addQuestion1(q5);

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SET_DOMANDE1);//Droppo la tabella TABLE_QUEST1 se esiste dentro al database
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SET_DOMANDE2);//Droppo la tabella TABLE_QUEST2 se esiste dentro al database
        onCreate(db);
    }

    //Inserimento di una nuova tupla(domanda, ripsota) nel database
    public void addQuestion1(SetQuiz quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //Questa classe viene utilizzata per memorizzare un insieme di valori che la ContentResolver può elaborare.
        //Un ContentResolver viene usato per gestire un ContentProvider
        /*I ContentProvider possono aiutare a un'applicazione di gestire l'accesso ai dati memorizzati da sola, memorizzati da altre applicazioni, e fornire un modo per condividere i dati con altre applicazioni.
          Essi racchiudono i dati, e forniscono meccanismi per la definizione di sicurezza dei dati.
          I fornitori di contenuti sono l'interfaccia standard che collega i dati in un unico processo con codice in esecuzione in un altro processo.
          L'implementazione di un fornitore di contenuti ha molti vantaggi.
          La cosa più importante è possibile configurare un fornitore di contenuti per permettere ad altre applicazioni di accedere e modificare i dati delle applicazioni in modo sicuro come illustrato in figura
        */

        //Qui riempio il ContentValue, facendolo passare come un "INSIEME DI TUPLE"
        values.put(CHIAVE_DOMANDA, quest.getQUESTION());
        values.put(CHIAVE_ID, quest.getANSWER());
        values.put(CHIAVE_OPZIONEA, quest.getOPTA());
        values.put(CHIAVE_OPZIONEB, quest.getOPTB());
        values.put(CHIAVE_OPZIONEB, quest.getOPTC());

        //Della tabella nel database con relative tuple
        dbase.insert(TABLE_SET_DOMANDE1, null, values);
    }

    public void addQuestion2(SetQuiz quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //Qui riempio il ContentValue, facendolo passare come un "INSIEME DI TUPLE"
        values.put(CHIAVE_DOMANDA, quest.getQUESTION());
        values.put(CHIAVE_RISPOSTA, quest.getANSWER());
        values.put(CHIAVE_OPZIONEA, quest.getOPTA());
        values.put(CHIAVE_OPZIONEB, quest.getOPTB());
        values.put(CHIAVE_OPZIONEC, quest.getOPTC());

        //Della tabella nel database con relative tuple
        dbase.insert(TABLE_SET_DOMANDE2, null, values);
    }

    public List<SetQuiz> getAllQuestions1() {
        List<SetQuiz> questList = new ArrayList<SetQuiz>();
        // Seleziono tutte le Query
        String selectQuery = "SELECT  * FROM " + TABLE_SET_DOMANDE1;
        dbase = this.getReadableDatabase();//In questo modo posso o aprire il database in modalità di lettura, o lo creo e lo apro
        Cursor cursor = dbase.rawQuery(selectQuery, null);//Esegue l'SQL fornito per argomento e ritorna un puntatore a un tipo Cursor

        //Attuo il set delle domande, le risposte e le opzioni della classe SetQuiz.java
        //E le aggiunalla lista delle domande
        if (cursor.moveToFirst()) {
            do {
                SetQuiz quest = new SetQuiz();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                questList.add(quest);
            }
            while (cursor.moveToNext());//Faccio muovere il cursore fino alla prossima riga del database
        }
        return questList;
    }

    public List<SetQuiz> getAllQuestions2() {
        List<SetQuiz> questList = new ArrayList<SetQuiz>();
        String selectQuery;
        selectQuery = "SELECT  * FROM " + TABLE_SET_DOMANDE2;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        cursor = dbase.rawQuery(selectQuery, null);//Esegue l'SQL fornito per argomento e ritorna un puntatore a un tipo Cursor

        //Attuo il set delle domande, le risposte e le opzioni della classe SetQuiz.java
        //E le aggiunalla lista delle domande
        if (cursor.moveToFirst()) {
            do {
                SetQuiz quest = new SetQuiz();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                questList.add(quest);
            }
            while (cursor.moveToNext());//Faccio muovere il cursore fino alla prossima riga del database
        }
        return questList;
    }

    public int rowcount() {
        int row = 0;
        String selectQuery = "SELECT  * FROM " + TABLE_SET_DOMANDE1;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }
}
