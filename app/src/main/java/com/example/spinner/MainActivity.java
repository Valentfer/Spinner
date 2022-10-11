package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

   //Declaramos las variables que vamos a usar en los métodos
    private TextView num1, num2, txtResul;
    private float resultado;
    private Spinner spin;
    String[] opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //indicamos a las variables cuales son sus textbox
        num1 = findViewById(R.id.txtnum1);
        num2 = findViewById(R.id.txtnum2);
        txtResul = findViewById(R.id.txtResul);

        //instanciamos el Spinner
        spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //creamos las opciones del Spinner
        opciones = new String[]{"", "Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spin.setAdapter(adapter);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //hacemos uso de switch case par las diferentes opciones que proporciona el spinner
        String opcion = opciones[position];
        switch(opcion) {
            case "Sumar":
                resultado = Integer.parseInt((num1.getText().toString())) + Integer.parseInt((num2.getText().toString()));
                txtResul.setText(String.valueOf(resultado));
                break;
            case "Restar":
                resultado = Integer.parseInt((num1.getText().toString())) - Integer.parseInt((num2.getText().toString()));
                txtResul.setText(String.valueOf(resultado));
                break;
            case "Multiplicar":
                resultado = Integer.parseInt((num1.getText().toString())) * Integer.parseInt((num2.getText().toString()));
                txtResul.setText(String.valueOf(resultado));
                break;
            case "Dividir":
                if (Integer.parseInt((num2.getText().toString())) == 0) {
                    Toast.makeText(this, "no se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                }
                resultado = Integer.parseInt((num1.getText().toString())) / Integer.parseInt((num2.getText().toString()));
                txtResul.setText(String.valueOf(resultado));
                break;
        }
    }

    //Estamos obligados a implementar el siguiente método aunque no se use
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}