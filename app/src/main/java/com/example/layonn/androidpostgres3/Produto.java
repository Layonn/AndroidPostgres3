package com.example.layonn.androidpostgres3;

import android.util.Log;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private float preco;

    public Produto(){
        this.id = -1;
        this.nome = "";
        this.descricao = "";
        this.preco = 0;
    }

    public ArrayList<Produto> getLista(){
        DB db = new DB();
        ArrayList<Produto> lista = new ArrayList<>();
        try{
            ResultSet resultSet = db.select("SELECT * FROM produto");
            if(resultSet != null){
                while (resultSet.next()){
                    Produto prod = new Produto();
                    prod.setId(resultSet.getInt("id"));
                    prod.setNome(resultSet.getString("nome"));
                    prod.setPreco(resultSet.getFloat("preco"));
                    prod.setDescricao(resultSet.getString("descricao"));

                    lista.add(prod);
                    prod = null;
                }
            }
        }catch (Exception ex){
            Log.e("Erro no select", ex.getMessage());
        }

        return lista;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
