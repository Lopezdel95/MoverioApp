package com.example.moverioapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String IpAddr = "192.168.0.253";
    private int dBNumber = 10;
    private int length = 40;
    private int rack = 0;
    private int slot = 0;
    PlcConnection p;
    ActualizarTexto A;
    public static Datos[] d = new Datos[21];
    TextView [] textos = new TextView[10];
    


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    public void botonIniciar(View view){
        final Button botonInicio = (Button) findViewById(R.id.button2);
        final Button botonAjustes = (Button) findViewById(R.id.button);

        final EditText textIP = (EditText) findViewById(R.id.textIP);
        IpAddr = textIP.getText().toString();
        cargaDatos();
        textIP.setVisibility(View.GONE);
        botonAjustes.setVisibility(View.VISIBLE);
        while(!p.leido);
        botonInicio.setVisibility(View.GONE);
        final TextView textoDato1 = (TextView) findViewById(R.id.Dato1);
        for(int i = 1;i<10;i++) {
            textos[i] = (TextView) findViewById(getResources().getIdentifier("Dato" + i, "id", this.getPackageName()));
        }

        for(int i=1;i<=20;i++){
            d[i]=new Datos();
        }
        A = new ActualizarTexto(textos, p, d);
        new Thread(A).start();
    }

    //Cambio de a pantalla de ajustes
    public void botonAjustes(View view) {
        Intent intent = new Intent(this, Ajustes.class);
        startActivity(intent);
    }

    //Funcion de inicio de Tread de actualización de los datos de PLC
    public void cargaDatos() {
        p = new PlcConnection(IpAddr, dBNumber, length, rack, slot);
        new Thread(p).start();


        }

    /*    //TODO: Refrescar pantalla continuamente con un thread
    public void textoEnPantalla() {
            final TextView textoDato1 = (TextView) findViewById(R.id.Dato1);
            int[] Datos;
            Datos = p.getDatos();
            for (int a : Datos) {
                textoDato1.append(a + " ");
            }
    }*/

//======================================================================================================================
}

