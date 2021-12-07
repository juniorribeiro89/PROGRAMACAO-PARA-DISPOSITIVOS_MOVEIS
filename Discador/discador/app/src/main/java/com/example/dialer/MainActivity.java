package com.example.dialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
            Toast.makeText(this, "Por Favor coloque numero valido", Toast.LENGTH_SHORT).show();
        } else {
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