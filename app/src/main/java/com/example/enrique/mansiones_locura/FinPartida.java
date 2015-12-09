package com.example.enrique.mansiones_locura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinPartida extends AppCompatActivity {
    Juego miJuego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_partida);
        miJuego = (Juego)getIntent().getExtras().getSerializable("Juego");
        TextView textResult = (TextView) findViewById(R.id.txtEndGame);
        if(miJuego.getVida() <= 0 || miJuego.getTurnos() >= 10){
            textResult.setText("DEFEAT");
        }else{
            textResult.setText("VICTORY!!");
        }
    }
}
