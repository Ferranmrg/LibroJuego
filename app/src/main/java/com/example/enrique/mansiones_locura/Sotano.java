package com.example.enrique.mansiones_locura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Sotano extends AppCompatActivity {
    Juego miJuego;
    TextView lblVida;
    TextView lblAccion;
    TextView lblTurno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sotano);
        miJuego = (Juego)getIntent().getExtras().getSerializable("Juego");
        lblVida = (TextView) findViewById(R.id.lblVidaRec);
        lblAccion = (TextView) findViewById(R.id.lblAccionRec);
        lblTurno = (TextView) findViewById(R.id.lblTurnoRec);
        setLabels();
    }

    private void setLabels() {
        lblAccion.setText(String.valueOf(miJuego.getAcciones()));
        lblTurno.setText(String.valueOf(miJuego.getTurnos()));
        lblVida.setText(String.valueOf(miJuego.getVida()));
    }

    public void toRecibidor(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Recibidor");
            Intent i = new Intent(this,clase);
            //Method to control the turn
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

    public void toSalaRitual(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.SalaRitual");
            Intent i = new Intent(this,clase);
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
