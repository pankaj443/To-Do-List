package com.py.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Databasehelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "todo.db";
    public static final String TABLE_NAME = "todo_table";
    public static final String COL_0 = "ID";
    public static final String COL_1 = "TITLE";
    public static final String COL_2 = "DESCR";
    public static final String COL_3 = "DATE";

    public Databasehelper( Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT , TITLE TEXT , DESCR TEXT , DATE TEXT) " );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
       // onCreate(db);
    }
    public boolean insertdata(String title, String descr , String date ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,title);
        contentValues.put(COL_2,descr);
        contentValues.put(COL_3,date);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }


    public Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME, null);
        return res;
    }
    public boolean update(String id, String title, String descr , String date ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0,id);
        contentValues.put(COL_1,title);
        contentValues.put(COL_2,descr);
        contentValues.put(COL_3,date);
        db.update(TABLE_NAME, contentValues,"ID = ?",new String[]{id});

        return true;
    }

    public Integer delete(String id ){
        SQLiteDatabase db = this.getWritableDatabase();


        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }

}
