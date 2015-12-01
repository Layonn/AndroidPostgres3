package com.example.layonn.androidpostgres3;

import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB implements Runnable{
    private String filtro = "POSTGRES";
    private String driver = "org.postgresql.Driver";
    private String user = "postgres";
    private String senha = "123456";
    private String url = "jdbc:postgresql://192.168.1.34:5432/android";
    private Connection conn;

    public DB() {
        this.conecta();
        this.desconecta();
    }

    @Override
    public void run() {
        try {
            Class.forName(driver);
            this.conn = null;
            this.conn = (Connection) DriverManager.getConnection(this.url, this.user, this.senha);

        }catch (ClassNotFoundException ex) {
            Log.e(filtro, ex.getMessage());
        }
        catch (SQLException e){
            Log.e(filtro, e.getMessage());
        }
    }


    private void conecta(){
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch (Exception e){
            Log.e(filtro, e.getMessage());
        }
    }

    private void desconecta(){
        if(this.conn!=null){
            try{
                this.conn.close();
            }catch (Exception e){
                Log.e(filtro, e.getMessage());
            }
            finally {
                this.conn = null;
            }
        }
    }

    public ResultSet select(String query){
        this.conecta();
        ResultSet resultSet = null;

        try{
            resultSet = new ExecuteDB(this.conn, query).execute().get();

        }catch (Exception e){
            Log.e(filtro, e.getMessage());
        }

        return resultSet;
    }

    public ResultSet execute(String query){
        this.conecta();
        ResultSet resultSet = null;

        try{
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        }catch (Exception e){
            Log.e(filtro, e.getMessage());
        }

        return resultSet;
    }

}
