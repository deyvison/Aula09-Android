package com.example.deyvison.aula09;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Deyvison on 15/03/2016.
 */
public class Helper extends SQLiteOpenHelper {

    public static String NOME = "ayty";
    public static int VERSAO = 1;

    public Helper(Context context) {
        super(context, NOME, null, VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE aluno (_id int autoincrement not null," +
                "nome text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE aluno");
        onCreate(db);
    }
}
