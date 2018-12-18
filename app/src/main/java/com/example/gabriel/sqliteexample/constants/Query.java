package com.example.gabriel.sqliteexample.constants;

public class Query {
    public static String tableSqlite() {
        return "create table sqlite_example (" +
                "id integer primary key autoincrement, " +
                "nome text not null, " +
                "idade int not null, " +
                "email text not null)";
    }

    public static String dropTableSqlite() {
        return "drop table sqlite_example";
    }
}
