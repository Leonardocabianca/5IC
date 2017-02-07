package com.example.giorgio.quizinternet;

/**
 * Created by Giorgio on 26/01/2017.
 */
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper{

    private static final int database = 1;
    // Database Name
    private static final String database_name = "Quiz Duello";
    // tasks table name
    private static final String table_quest = "quest";
    // tasks Table Columns names
    private static final String key_id = "id";
    private static final String key_question = "question";
    private static final String key_answer = "answer"; //correct option
    private static final String key_opta= "opta"; //option a
    private static final String key_optb= "optb"; //option b
    private static final String key_optc= "optc"; //option c
    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, database_name, null, database);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + table_quest + " ( "
                + key_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + key_question
                + " TEXT, " + key_answer+ " TEXT, "+key_opta +" TEXT, "
                +key_optb +" TEXT, "+key_optc+" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("Quale compania è la più grande?","HP", "IBM", "CISCO", "CISCO");
        this.addQuestion(q1);

        Question q2=new Question("Quale dei seguenti non è un sistema operativo?", "SuSe", "BIOS", "DOS", "BIOS");
        this.addQuestion(q2);

        Question q3=new Question("Quali delle seguenti memorie è la più veloce?","RAM", "FLASH","Register","Register");
        this.addQuestion(q3);

        Question q4=new Question("Quale dei seguenti device regola il traffico internet?",	"Router", "Bridge", "Hub","Router");
        this.addQuestion(q4);

        Question q5=new Question("Quale dei seguenti non è un linguaggio interpretato?","Ruby","Python","BASIC","BASIC");
        this.addQuestion(q5);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + table_quest);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_question, quest.getQUESTION());
        values.put(key_answer, quest.getANSWER());
        values.put(key_opta, quest.getOPTA());
        values.put(key_optb, quest.getOPTB());
        values.put(key_optc, quest.getOPTC());
        // Inserting Row
        dbase.insert(table_quest, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + table_quest;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + table_quest;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}

