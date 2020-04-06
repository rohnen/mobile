package com.example.match;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Foot.db";
    public static final String TABLE_NAME = "equipe1_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME1";
    public static final String COL_3 = "JOUEUR1";
    public static final String COL_4 = "NAME2";
    public static final String COL_5 = "JOUEUR2";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME1 TEXT, JOUEUR1 TEXT, NAME2 TEXT, JOUEUR2 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public  boolean insertequipe1 (String name1, String joueur1){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name1);
        contentValues.put(COL_3,joueur1);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public  boolean insertequipe2 (String name2, String joueur2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4,name2);
        contentValues.put(COL_5,joueur2);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
