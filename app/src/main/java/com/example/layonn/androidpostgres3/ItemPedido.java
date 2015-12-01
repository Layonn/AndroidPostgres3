package com.example.layonn.androidpostgres3;

import java.util.ArrayList;

public class ItemPedido {
    private int id;
    private ArrayList<Produto> itens;

    public void ItemPedido(ArrayList<Produto> itens){
        this.itens = itens;
    }

    public void salvar(int idUsuario){
        String comando;
        DB db;

        for(int i=0; i<itens.size(); i++){
            comando = String.format("INSERT INTO itens_pedido " +
                            "(id_produto, id_usuario) VALUES ('%d','%d');",
                            itens.get(i).getId(), idUsuario);
            db = new DB();
            db.execute(comando);

            comando = null;
            db = null;
        }

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }

}
