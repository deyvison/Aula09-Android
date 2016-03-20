package com.example.deyvison.aula09;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Deyvison on 15/03/2016.
 */

public class GerenciadorDB{

    private SQLiteDatabase db;
    private Context context;
    private Helper helper = new Helper(this.context);

    public GerenciadorDB(Context context) {
        this.context = context;
        db = helper.getWritableDatabase();
    }

    public void create(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        db.insert("aluno", "aluno indefinido", values);
    }

    public Cursor read(Aluno aluno){
        String selection = (aluno == null)?null:"_id=?";
        String[] args = (aluno == null)?null: new String[]{aluno.getId()+""};
        Cursor cursor = db.query("aluno",null, selection, args, null,null,null);
        return cursor;
    }

    public void update(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome",aluno.getNome());
        db.update("aluno", values, "_id=?", new String[]{"" + aluno.getId()});
    }

    public void delete(Aluno aluno){
        db.delete("aluno", "_id=?",  new String[]{"" + aluno.getId()});
    }

}
