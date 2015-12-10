package com.example.enrique.mansiones_locura;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Recibidor extends AppCompatActivity{
    Juego miJuego;
    TextView lblVida;
    TextView lblAccion;
    TextView lblTurno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibidor);
        miJuego = (Juego)getIntent().getExtras().getSerializable("Juego");
        lblVida = (TextView) findViewById(R.id.lblVidaRec);
        lblAccion = (TextView) findViewById(R.id.lblAccionRec);
        lblTurno = (TextView) findViewById(R.id.lblTurnoRec);
        setLabels();
        if (!miJuego.getMessage()) {
            miJuego.setMessage(true);
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(this);
            builder.setMessage("Abres la puerta de la antigua mansión y accedes al Recibidor, la casa está en silencio, como si contuviese la respiración a la espera de que algo terrible suceda, de repente, toda la casa se sacude y se escucha un grito desgarrador que parece proceder de tu derecha ");
            builder.show();
        }
    }

    private void setLabels() {
        lblAccion.setText(String.valueOf(miJuego.getAcciones()));
        lblTurno.setText(String.valueOf(miJuego.getTurnos()));
        lblVida.setText(String.valueOf(miJuego.getVida()));
    }

    public void toPasillo(View view) {
        try {
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Pasillo");
            Intent i = new Intent(this, clase);
            //Method to control the turn
            miJuego.setAcciones(miJuego.getAcciones()+1);
            if(miJuego.finPartida()){
                Class<?> claseFIn = Class.forName("com.example.enrique.mansiones_locura.FinPartida");
                Intent fin = new Intent(this, clase);
                startActivity(fin);
            }
            i.putExtra("Juego", miJuego);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void toSotano(View view) {
        try {
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Sotano");
            Intent i = new Intent(this, clase);
            //Method to control the turn
            miJuego.setAcciones(miJuego.getAcciones()+1);
            if(miJuego.finPartida()){
                Class<?> claseFIn = Class.forName("com.example.enrique.mansiones_locura.FinPartida");
                Intent fin = new Intent(this, claseFIn);
                startActivity(fin);
            }
            i.putExtra("Juego", miJuego);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void toLaboratorio(View view) {
        try {
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Laboratorio");
            Intent i = new Intent(this, clase);
            //Method to control the turn
            miJuego.setAcciones(miJuego.getAcciones()+1);
            if(miJuego.finPartida()){
                Class<?> claseFIn = Class.forName("com.example.enrique.mansiones_locura.FinPartida");
                Intent fin = new Intent(this, claseFIn);
                startActivity(fin);
            }
            i.putExtra("Juego", miJuego);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void toCocina(View view) {
        try {
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Cocina");
            Intent i = new Intent(this, clase);
            //Method to control the turn
            miJuego.setAcciones(miJuego.getAcciones()+1);
            if(miJuego.finPartida()){
                Class<?> clasefin = Class.forName("com.example.enrique.mansiones_locura.FinPartida");
                Intent fin = new Intent(this, clasefin);
                startActivity(fin);
            }
            i.putExtra("Juego", miJuego);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Creates spinner menu in actionbar
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Calls created items for spinner menu
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.map) {
            try{
                Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Mapa");
                Intent i = new Intent(this, clase);
                startActivity(i);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if(item.getItemId()==R.id.exit) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return(true);
    }
    public void explorar(View view) {
        miJuego.setAcciones(miJuego.getAcciones() + 1);
        lblAccion.setText(String.valueOf(miJuego.getAcciones()));
        lblTurno.setText(String.valueOf(miJuego.getTurnos()));
        Random r = new Random();
        int i1 = r.nextInt(100 - 1) + 1;
        if (miJuego.getTurnos() < 10) {
            if (i1 >= 30) {

                Toast t = Toast.makeText(this,"Nothing found here!",Toast.LENGTH_SHORT);
                t.show();
            }else{
                miJuego.setVida(miJuego.getVida() - 20);
                lblVida.setText(String.valueOf(miJuego.getVida()));
                Toast t = Toast.makeText(this,"ARGH!",Toast.LENGTH_SHORT);
                t.show();
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
