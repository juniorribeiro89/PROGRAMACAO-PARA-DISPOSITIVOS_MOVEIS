package com.example.discador;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;



public class TelaPrincipal extends ListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] opcoes = new String[]{"Ligação", "Historico de Chamadas", "Sair"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcoes);
        setListAdapter(adapter);
    }

    public void listar(View v){
        Intent it = new Intent(null, ListaChamadas.class);
        startActivity(it);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this, getListAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
        switch (position) {

            case 0:
                Toast.makeText(this, "Discador", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case 1:
                Toast.makeText(this, "Historico", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(), ListaChamadas.class);
                startActivity(it);

                break;
            case 2:
                finish();
                break;
        }
    }
}