package com.example.discador;

import android.app.ListActivity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.List;

public class ListaChamadas extends ListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Chamada_DAO chamadaDAO = new Chamada_DAO(this);
        List<Chamada> chamadas = chamadaDAO.obterChamadas();

        ChamadaAdapter adapter = new ChamadaAdapter(this, chamadas);
        setListAdapter(adapter);

    }

}
