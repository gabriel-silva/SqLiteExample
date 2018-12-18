package com.example.gabriel.sqliteexample.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.gabriel.sqliteexample.model.Pessoa;

public class ConnectionDataBase extends SQLiteOpenHelper {

    private static int VERSION_DB = 1;
    private static String NAME_DB = "SqLiteExample";

    public ConnectionDataBase(Context context) {
        super(context, NAME_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Pessoa.CREATE_TABLE_PESSOA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Pessoa.DROP_TABLE_PESSOA);
        onCreate(sqLiteDatabase);
    }

}
