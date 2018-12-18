package com.example.gabriel.sqliteexample.model;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class Pessoa {

    private String nome;
    private int idade;
    private String email;

    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static String NOME_TABLE = "PESSOA";
    public static String ID = "ID";
    public static String NOME = "NOME";
    public static String IDADE = "IDADE";
    public static String EMAIL = "EMAIL";
    public static String CREATE_TABLE_PESSOA =
            "CREATE TABLE " + NOME_TABLE +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOME + " TEXT NOT NULL, " +
                    IDADE + " INTEGER NOT NULL, " +
                    EMAIL + " TEXT NOT NULL)";
    public static String DROP_TABLE_PESSOA = "DROP TABLE " + NOME_TABLE;
    public static String INSERT_PESSOA = "INSERT INTO " + NOME_TABLE
            + " (" + NOME + ", " + IDADE + ", " + EMAIL + ") VALUES (?, ?, ?)";
    public static String UPDATE_PESSOA =
            "UPDATE " + NOME_TABLE + " SET " + NOME + "=?, "
                    + IDADE + "=?, " + EMAIL + "=? " + " WHERE " + ID + "=?";
    public static String DELETE_PESSOA = "DELETE FROM " + NOME_TABLE + " WHERE " + ID + "=?";

    public void dropTablePessoa(SQLiteDatabase sqLiteDatabase, String name) {
        try {
            sqLiteDatabase.execSQL("drop table " + NOME_TABLE);
        } catch (SQLException e) {
            Log.i("DROP_TABLE", " " + e);
        }
    }

    public void insertPessoa(SQLiteDatabase sqLiteDatabase, Pessoa pessoa) {
        try {
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(INSERT_PESSOA);
            sqLiteStatement.bindString(1, pessoa.getNome());
            sqLiteStatement.bindString(2, pessoa.getEmail());
            sqLiteStatement.bindLong(3, pessoa.getIdade());
            sqLiteStatement.executeInsert();
        } catch (SQLException e) {
            Log.i("INSERT_PESSOA", " " + e);
        }
    }

    public void updatePessoa(SQLiteDatabase sqLiteDatabase, Pessoa pessoa) {
        try {
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(UPDATE_PESSOA);
            sqLiteStatement.bindString(1, pessoa.getNome());
            sqLiteStatement.bindString(2, pessoa.getEmail());
            sqLiteStatement.bindLong(3, pessoa.getIdade());
            sqLiteStatement.execute();
        } catch (SQLException e) {
            Log.i("UPDATE_PESSOA", " " + e);
        }
    }

    public void deletePessoa(SQLiteDatabase sqLiteDatabase, int id) {
        try {
            SQLiteStatement stmt = sqLiteDatabase.compileStatement(DELETE_PESSOA);
            stmt.bindLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            Log.i("DELETE_PESSOA", " " + e);
        }
    }

}
