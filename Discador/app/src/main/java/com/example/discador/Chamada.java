package com.example.discador;

public class Chamada {
    private int id;
    private String telefone;
    private String data_hora;

    public Chamada(int id, String telefone, String data_hora) {
        this.id = id;
        this.telefone = telefone;
        this.data_hora = data_hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }
}
