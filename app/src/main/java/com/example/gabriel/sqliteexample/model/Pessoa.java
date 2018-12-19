package com.example.gabriel.sqliteexample.model;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private int id;
    private String nome;
    private int idade;
    private String email;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, int idade, String email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
            "CREATE TABLE " + NOME_TABLE + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOME + " TEXT NOT NULL, " +
                    IDADE + " INTEGER NOT NULL, " +
                    EMAIL + " TEXT NOT NULL);";
    public static String DROP_TABLE_PESSOA = "DROP TABLE " + NOME_TABLE;
    public static String INSERT_PESSOA = "INSERT INTO " + NOME_TABLE
            + " (" + NOME + ", " + IDADE + ", " + EMAIL + ") VALUES (?, ?, ?)";
    public static String UPDATE_PESSOA =
            "UPDATE " + NOME_TABLE + " SET " + NOME + "=?, "
                    + IDADE + "=?, " + EMAIL + "=? " + " WHERE " + ID + "=?";
    public static String DELETE_PESSOA = "DELETE FROM " + NOME_TABLE + " WHERE " + ID + "=?";
    public static String ALL_PESSOA = "SELECT * FROM " + NOME_TABLE;

    public void dropTablePessoa(SQLiteDatabase sqLiteDatabase, String name) {
        try {
            sqLiteDatabase.execSQL("drop table " + NOME_TABLE);
            sqLiteDatabase.close();
        } catch (SQLException e) {
            Log.i("DROP_TABLE", " " + e);
        }
    }

    public void insertPessoa(SQLiteDatabase sqLiteDatabase, Pessoa pessoa) {
        try {
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(INSERT_PESSOA);
            sqLiteStatement.bindString(1, pessoa.getNome());
            sqLiteStatement.bindLong(2, pessoa.getIdade());
            sqLiteStatement.bindString(3, pessoa.getEmail());
            sqLiteStatement.executeInsert();
            sqLiteStatement.close();
        } catch (SQLException e) {
            Log.i("INSERT_PESSOA", " " + e);
        }
    }

    public void updatePessoa(SQLiteDatabase sqLiteDatabase, Pessoa pessoa, int id) {
        try {
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(UPDATE_PESSOA);
            sqLiteStatement.bindString(1, pessoa.getNome());
            sqLiteStatement.bindLong(2, pessoa.getIdade());
            sqLiteStatement.bindString(3, pessoa.getEmail());
            sqLiteStatement.bindLong(4, id);
            sqLiteStatement.execute();
            sqLiteDatabase.close();
        } catch (SQLException e) {
            Log.i("UPDATE_PESSOA", " " + e);
        }
    }

    public void deletePessoa(SQLiteDatabase sqLiteDatabase, int id) {
        try {
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(DELETE_PESSOA);
            sqLiteStatement.bindLong(1, id);
            sqLiteStatement.execute();
            sqLiteDatabase.close();
        } catch (SQLException e) {
            Log.i("DELETE_PESSOA", " " + e);
        }
    }

    public List<Pessoa> getAllPessoa(SQLiteDatabase sqLiteDatabase) {
        Cursor cursor = sqLiteDatabase.rawQuery(ALL_PESSOA, null);
        List<Pessoa> pessoaList = new ArrayList<Pessoa>();

        while (cursor.moveToNext()) {
            int id = cursor.getColumnIndex(ID);
            int name = cursor.getColumnIndex(NOME);
            int idade = cursor.getColumnIndex(IDADE);
            int email = cursor.getColumnIndex(EMAIL);

            Pessoa pessoa = new Pessoa(
                    Integer.parseInt(cursor.getString(id)),
                    cursor.getString(name),
                    Integer.parseInt(cursor.getString(idade)),
                    cursor.getString(email));
            pessoaList.add(pessoa);
        }
        return pessoaList;
    }

}
