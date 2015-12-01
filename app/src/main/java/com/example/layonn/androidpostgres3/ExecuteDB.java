package com.example.layonn.androidpostgres3;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;

public class ExecuteDB extends AsyncTask<String, Void, ResultSet>{
    private String filtro = "POSTGRES";
    private Connection connection;
    private String query;

    public ExecuteDB(Connection connection, String query){
        this.connection = connection;
        this.query = query;
    }

    @Override
    protected ResultSet doInBackground(String... params){
        ResultSet resultSet = null;
        try{
            resultSet = connection.prepareStatement(query).executeQuery();
        }catch (Exception e){
            Log.e(filtro, e.getMessage());
        }
        finally {
            try {
                connection.close();
            }catch (Exception ex){
                Log.e(filtro, ex.getMessage());
            }
        }

        return resultSet;
    }
}
