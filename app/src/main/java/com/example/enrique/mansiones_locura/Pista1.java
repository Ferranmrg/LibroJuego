package com.example.enrique.mansiones_locura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Pista1 extends AppCompatActivity {
    Juego miJuego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista1);
        miJuego = (Juego)getIntent().getExtras().getSerializable("Juego");
    }
    public void toLaboratorio(View view) {
        try {
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Laboratorio");
            Intent i = new Intent(this, clase);
            i.putExtra("Juego", miJuego);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
