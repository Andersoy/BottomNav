package com.example.bottomnav;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    static String TABLE_MOETER = "Møter";
    static String KEY_ID = "_ID";
    static int DATABASE_VERSION = 1;
    static String DATABASE_NAME = "MeetingManager";
    public DBHandler(Context context) {super(context, DATABASE_NAME, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String LAG_TABELL = "CREATE TABLE " + TABLE_MOETER + "(" + KEY_ID + " INTEGER PRIMARY KEY" + ")";
        Log.d("SQL", LAG_TABELL);
        db.execSQL(LAG_TABELL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOETER);
        onCreate(db);
    }

    public void leggTilMoete(int ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(KEY_ID, ID);
        db.insert(TABLE_MOETER, null, values);
        db.close();
    }

    public List<Integer> finnAlleMoeter() {
        List<Integer> MoeteListe= new ArrayList<Integer>();
        String selectQuery= "SELECT * FROM " + TABLE_MOETER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor= db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                MoeteListe.add(id);
            }   while(cursor.moveToNext());
            cursor.close();
            db.close();
        }
        return MoeteListe;
    }
}
