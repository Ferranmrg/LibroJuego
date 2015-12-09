package com.example.enrique.mansiones_locura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartGame extends AppCompatActivity {
    Juego miJuego = new Juego(100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
    }

    public void startNewGame(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.IntroHistory");
            Intent i = new Intent(this,clase);
            i.putExtra("Juego", miJuego);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
