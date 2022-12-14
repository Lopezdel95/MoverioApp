package com.example.moverioapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Ajustes extends AppCompatActivity {
    /*---------------------------------------------------------------------
    Clase de menú de ajustes. En ella se selecciona donde ubicar cada dato en pantalla.
    -----------------------------------------------------------------------*/

    public static boolean Boleano=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        //Spinners de selección de posición.
        final Spinner[] spinnerDato = new Spinner[21];

        for(int i = 1;i<=20;i++){
            spinnerDato[i] = (Spinner) findViewById(getResources().getIdentifier("spinnerDato" + i, "id", this.getPackageName()));
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.Spinner_ubicacion, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerDato[i].setAdapter(adapter);
        }

    }
        // Al salir de la pantalla de ajustes, se transfiere a cada dato la posición seleccionada
    protected void onStop(){
        super.onStop();
        final Spinner[] spinnerDato = new Spinner[21];

        for(int i = 1;i<=20;i++) {
            spinnerDato[i] = (Spinner) findViewById(getResources().getIdentifier("spinnerDato" + i, "id", this.getPackageName()));
            String posicion;
            posicion = spinnerDato[i].getSelectedItem().toString();
            switch (posicion) {
                case "No mostrar":
                    MainActivity.d[i].setPosicion(0);
                    break;
                case "Arriba Izquierda":
                    MainActivity.d[i].setPosicion(1);
                    break;
                case "Arriba Centro":
                    MainActivity.d[i].setPosicion(2);
                    break;
                case "Arriba Derecha":
                    MainActivity.d[i].setPosicion(3);
                    break;
                case "Centro Izquierda":
                    MainActivity.d[i].setPosicion(4);
                    break;
                case "Centro":
                    MainActivity.d[i].setPosicion(5);
                    break;
                case "Centro Derecha":
                    MainActivity.d[i].setPosicion(6);
                    break;
                case "Abajo Izquierda":
                    MainActivity.d[i].setPosicion(7);
                    break;
                case "Abajo Centro":
                    MainActivity.d[i].setPosicion(8);
                    break;
                case "Abajo Derecha":
                    MainActivity.d[i].setPosicion(9);
                    break;
            }
        }
        Boleano = true;
    }

}