package com.example.gabriel.sqliteexample.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBase extends ConnectionDataBase {

    private SQLiteDatabase sqLiteDatabase = null;
    private Cursor cursor = null;

    public DataBase(Context context) {
        super(context);
        ConnectionDataBase connectionDataBase = new ConnectionDataBase(context);
        sqLiteDatabase = connectionDataBase.getWritableDatabase();
    }

    public SQLiteDatabase sqLiteDatabaseInstance() {
        return sqLiteDatabase;
    }
}
