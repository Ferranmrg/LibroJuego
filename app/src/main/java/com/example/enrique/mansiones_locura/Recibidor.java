package com.example.enrique.mansiones_locura;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Recibidor extends AppCompatActivity {

    Juego miJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibidor);
        miJuego = new Juego(100);
    }

    public void toPasillo(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Pasillo");
            Intent i = new Intent(this,clase);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void toSotano(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Sotano");
            Intent i = new Intent(this,clase);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void toLaboratorio(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Laboratorio");
            Intent i = new Intent(this,clase);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void toCocina(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Cocina");
            Intent i = new Intent(this,clase);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
