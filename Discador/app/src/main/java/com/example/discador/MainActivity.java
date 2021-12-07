package com.example.discador;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dialer.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnUm;
    Button btnDois;
    Button btnTres;
    Button btnQuatro;
    Button btnCinco;
    Button btnSeis;
    Button btnSete;
    Button btnOito;
    Button btnNove;
    Button btnZero;
    Button btnHash;
    Button btnEstrela;
    Button btnDelete;
    Button btnLigar;

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUm = findViewById(R.id.button1);
        btnDois = findViewById(R.id.button2);
        btnTres = findViewById(R.id.button3);
        btnQuatro = findViewById(R.id.button4);
        btnCinco = findViewById(R.id.button5);
        btnSeis = findViewById(R.id.button6);
        btnSete = findViewById(R.id.button7);
        btnOito = findViewById(R.id.button8);
        btnNove = findViewById(R.id.button9);
        btnZero = findViewById(R.id.button0);
        btnHash = findViewById(R.id.buttonHash);
        btnDelete = findViewById(R.id.buttonDelete);
        btnLigar = findViewById(R.id.buttonLigar);
        input = findViewById(R.id.editTextTextPersonName);

    }

    public void um(View v) {
        onButtonClick(btnUm, input, "1");
    }

    public void dois(View v) {
        onButtonClick(btnDois, input, "2");
    }

    public void tres(View v) {
        onButtonClick(btnTres, input, "3");

    }

    public void quatro(View v) {
        onButtonClick(btnQuatro, input, "4");

    }

    public void cinco(View v) {
        onButtonClick(btnCinco, input, "5");

    }

    public void seis(View v) {
        onButtonClick(btnSeis, input, "6");

    }

    public void sete(View v) {
        onButtonClick(btnSete, input, "7");

    }

    public void oito(View v) {
        onButtonClick(btnOito, input, "8");

    }

    public void nove(View v) {
        onButtonClick(btnNove, input, "9");

    }

    public void zero(View v) {
        onButtonClick(btnZero, input, "0");

    }

    public void estrela(View v) {
        onButtonClick(btnEstrela, input, "*");

    }

    public void hashTag(View v) {
        onButtonClick(btnHash, input, "#");

    }

    public void Delete(View v) {
        input.setText("");

    }

    public void ligar(View v) {



        if (input.getText().length() <= 3) {
            Toast.makeText(this, "Digite num numero valido", Toast.LENGTH_SHORT).show();
        } else {

            EditText telefoneChamada = findViewById(R.id.editTextTextPersonName);
            @SuppressLint("SimpleDateFormat") String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

            Chamada ch = new Chamada(0,telefoneChamada.getText().toString(), date);
            Chamada_DAO chamadaDAO = new Chamada_DAO(this);
            chamadaDAO.adicionar(ch);

            List<Chamada> chamadas = chamadaDAO.obterChamadas();

            for (Chamada chamada: chamadas){
                Log.d("App", "Id: " + chamada.getId() + " Telefone: "+ chamada.getTelefone() + " data: "+ chamada.getData_hora());
            }

            Uri numero = Uri.parse("tel:" + input.getText().toString());

            Intent call = new Intent(Intent.ACTION_DIAL, numero);
            startActivity(call);
        }
    }

    public void onButtonClick(Button button, EditText inputNumber, String number) {
        String cache = input.getText().toString();
        inputNumber.setText(cache + number);
    }

}