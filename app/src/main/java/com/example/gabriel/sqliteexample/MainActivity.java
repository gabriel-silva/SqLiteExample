package com.example.gabriel.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gabriel.sqliteexample.model.Pessoa;
import com.example.gabriel.sqliteexample.util.DataBase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DataBase dataBase = new DataBase();
        Pessoa pessoa = new Pessoa();
        pessoa.insertPessoa(dataBase.sqLiteDatabaseInstance(this),
                new Pessoa("Gabriel Silva", 21, "gabriel-silva_2011@hotmail.com"));
        pessoa.insertPessoa(dataBase.sqLiteDatabaseInstance(this),
                new Pessoa("Maria Luiza", 22, "maria_luiza@gmail.com"));

        //listar todas as pessoas
        try {
            List<Pessoa> pessoaList = pessoa.getAllPessoa(dataBase.sqLiteDatabaseInstance(this));
            for (int i = 0; i < pessoaList.size(); i++) {
                Log.i("Id", " " + pessoaList.get(i).getId());
                Log.i("Nome", " " + pessoaList.get(i).getNome());
                Log.i("Idade"," " + pessoaList.get(i).getIdade());
                Log.i("Email"," " + pessoaList.get(i).getEmail());
            }
        }catch (Exception e){
            Log.i("Erro: ", " " + e);
        }

    }
}
