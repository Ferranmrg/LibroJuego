package com.example.enrique.mansiones_locura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HabPrincipal extends AppCompatActivity {
    Juego miJuego;
    TextView lblVida;
    TextView lblAccion;
    TextView lblTurno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hab_principal);
        miJuego = (Juego)getIntent().getExtras().getSerializable("Juego");
        lblVida = (TextView) findViewById(R.id.lblVideoHabPrin);
        lblAccion = (TextView) findViewById(R.id.lblAccionHabPrin);
        lblTurno = (TextView) findViewById(R.id.lblturnoHabPrin);
        setLabels();
    }

    private void setLabels() {
        lblAccion.setText(String.valueOf(miJuego.getAcciones()));
        lblTurno.setText(String.valueOf(miJuego.getTurnos()));
        lblVida.setText(String.valueOf(miJuego.getVida()));
    }
    /**
     * Method to move to the method name room
     * @param view
     */
    public void toPasillo(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Pasillo");
            //Method to control the turn
            miJuego.setAcciones(miJuego.getAcciones()+1);
            if(miJuego.finPartida()){
                Class<?> claseFIn = Class.forName("com.example.enrique.mansiones_locura.FinPartida");
                Intent fin = new Intent(this, clase);
                startActivity(fin);
            }
            Intent i = new Intent(this,clase);
            i.putExtra("Juego", miJuego);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void explorar(View view) {
        miJuego.setAcciones(miJuego.getAcciones() + 1);
        Random r = new Random();
        int i1 = r.nextInt(100 - 1) + 1;
        if (miJuego.getTurnos() < 10) {
            if (i1 >= 20) {

                Toast t = Toast.makeText(this,"Nothing found here!",Toast.LENGTH_SHORT);
                t.show();
            }else{
                miJuego.setVida(miJuego.getVida() - 20);
                if(miJuego.getVida()<=0){
                    try {
                        Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.FinPartida");
                        Intent i = new Intent(this, clase);
                        i.putExtra("Juego", miJuego);
                        startActivity(i);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
