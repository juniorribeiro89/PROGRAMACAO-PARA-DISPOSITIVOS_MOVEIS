package com.example.discador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Chamada_DAO extends SQLiteOpenHelper {

    public static final String BANCO_DADOS  = "db_chamadas";
    public static final String TABELA_CHAMADA = "chamada";
    public static final int VERSAO = 1;
    public static final  String SCRIPT_TABELA_CHAMADA = " create table chamada (_id integer primary key autoincrement, telefone text, data text )";

    private Context context;


    public Chamada_DAO(@Nullable Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT_TABELA_CHAMADA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int versaoNova) {

    }

    public boolean adicionar(Chamada c){
        try{
            SQLiteDatabase db = getWritableDatabase();


            ContentValues cv = new ContentValues();
            cv.put("telefone", c.getTelefone());
            cv.put("data", c.getData_hora());

            db.insert(TABELA_CHAMADA, null, cv);

        }catch (Exception e){
            return false;
        }

        return true;
    }

    public List<Chamada> obterChamadas(){
        List<Chamada> chamadas = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor resultado = db.query(TABELA_CHAMADA, null,  null, null, null, null, null);
        if(resultado.getCount() > 0){
            resultado.moveToFirst();
            do {
                Chamada ch = new Chamada(resultado.getInt(0), resultado.getString(1), resultado.getString(2));
                chamadas.add(ch);
            }while (resultado.moveToNext());
        }

        return chamadas;

    }

    public boolean excluir(Chamada chamada){
        try{
            SQLiteDatabase db = getWritableDatabase();

            db.delete(TABELA_CHAMADA, "_id = ?", new String[]{String.valueOf(chamada.getId())});

        }catch (Exception e){
            return false;
        }

        return true;

    }

}
