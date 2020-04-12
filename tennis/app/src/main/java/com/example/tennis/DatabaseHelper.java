package com.example.tennis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Tennis.db";
    public static final String TABLE_NAME = "table_joueur";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NOM1";
    public static final String COL_3 = "NOM2";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOM1 TEXT, NOM2 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public  boolean insertnomJoueur (String nom1, String nom2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,nom1);
        contentValues.put(COL_3,nom2);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public void nom_equipe (EditText editText, int col) {

        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM table_joueur", null);
        cursor.moveToLast();
        editText.append(cursor.getString(col) + " ");
    }

}

