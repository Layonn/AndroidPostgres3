package com.example.layonn.androidpostgres3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ProdutosAdapter extends ArrayAdapter<Produto>{
    private Context context;
    private ArrayList<Produto> lista;

    public ProdutosAdapter(Context context, ArrayList<Produto> lista){
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final Produto itemPosicao = this.lista.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.item_cardapio, null);
        final View layout = convertView;

        TextView textViewNome = (TextView) convertView.findViewById(R.id.textViewNome);
        textViewNome.setText(itemPosicao.getNome());

        TextView textViewPreco = (TextView) convertView.findViewById(R.id.textViewPreco);
        //textViewPreco.setText(itemPosicao.getPreco());

        Button button = (Button)convertView.findViewById(R.id.buttonPedir);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, ItemPedido.class);
                intent.putExtra("id_produto", itemPosicao.getId());
            }
        });

        return convertView;
    }
}
