package com.example.discador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dialer.R;

import java.util.List;

public class ChamadaAdapter extends BaseAdapter {

    private Context context;
    private List<Chamada> chamadas;

    public  ChamadaAdapter(Context context, List<Chamada> chamadas){
        this.context = context;
        this.chamadas = chamadas;
    }

    @Override
    public int getCount() {
        return chamadas.size();
    }

    @Override
    public Object getItem(int i) {
        return chamadas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.lista_de_chamadas, null);

        Chamada chamada = chamadas.get(i);
        TextView idChamada = layout.findViewById(R.id.idChamada);
        TextView telefoneChamada = layout.findViewById(R.id.telefoneChamada);
        TextView dataChamada = layout.findViewById(R.id.dataChamada);

        idChamada.setText(String.valueOf(chamada.getId()));
        telefoneChamada.setText(chamada.getTelefone());
        dataChamada.setText(chamada.getData_hora());

        return layout;
    }
}
