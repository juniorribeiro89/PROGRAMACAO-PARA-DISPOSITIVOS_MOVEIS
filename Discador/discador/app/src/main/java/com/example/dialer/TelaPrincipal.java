package com.example.dialer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TelaPrincipal extends ListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] opcoes = new String[]{"Efetuar Ligação", "Historico de Ligação", "Sair"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcoes);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this, getListAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
        switch (position) {

            case 0:
                Toast.makeText(this, "Abrindo Discador", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case 1:
                Toast.makeText(this, "Abrindo Historico", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent();
                startActivity(intent2);
                break;
            case 2:
                finish();
                break;
        }
    }
}