package com.example.gabriel.sqliteexample.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataBase {

    private SQLiteDatabase sqLiteDatabase = null;

    public SQLiteDatabase sqLiteDatabaseInstance(Context context) {
        if(sqLiteDatabase == null) {
            sqLiteDatabase = new ConnectionDataBase(context).getWritableDatabase();
            return sqLiteDatabase;
        }
        return sqLiteDatabase;
    }
}
