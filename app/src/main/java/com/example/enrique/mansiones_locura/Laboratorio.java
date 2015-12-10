package com.example.enrique.mansiones_locura;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Laboratorio extends AppCompatActivity {
    Juego miJuego;
    TextView lblVida;
    TextView lblAccion;
    TextView lblTurno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio);
        miJuego = (Juego) getIntent().getExtras().getSerializable("Juego");
        lblVida = (TextView) findViewById(R.id.lblVIdaLab);
        lblAccion = (TextView) findViewById(R.id.lblAccionLab);
        lblTurno = (TextView) findViewById(R.id.lblTurnoLab);
        setLabels();
    }

    private void setLabels() {
        lblAccion.setText(String.valueOf(miJuego.getAcciones()));
        lblTurno.setText(String.valueOf(miJuego.getTurnos()));
        lblVida.setText(String.valueOf(miJuego.getVida()));
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
    /**
     * Method to move to the method name room
     * @param view
     */
    public void toJardin(View view) {
        try {
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Jardin");
            Intent i = new Intent(this, clase);
            //Method to control the turn
            miJuego.setAcciones(miJuego.getAcciones() + 1);
            if (miJuego.finPartida()) {
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

    public void toRecibidor(View view) {
        try {
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Recibidor");
            Intent i = new Intent(this, clase);
            //Method to control the turn
            miJuego.setAcciones(miJuego.getAcciones() + 1);
            if (miJuego.finPartida()) {
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
     * Method to explore the room, here we have
     * the first hint, so we have some checks
     * @param view
     */
    public void explorar(View view) {
        miJuego.setAcciones(miJuego.getAcciones() + 1);
        lblAccion.setText(String.valueOf(miJuego.getAcciones()));
        lblTurno.setText(String.valueOf(miJuego.getTurnos()));
        Random r = new Random();
        int i1 = r.nextInt(100 - 1) + 1;
        if (miJuego.getTurnos() < 10 && miJuego.getPista1() == false) {
            if (i1 >= 30) {
                miJuego.setPista1(true);
                try {
                    // NOTIFICATION
                    NotificationCompat.Builder mBuilder =
                            new NotificationCompat.Builder(this)
                                    .setSmallIcon(android.R.drawable.ic_dialog_alert)
                                    .setContentTitle("HOMBRE DESHOYADO:")
                                    .setContentText("-Dios mio... quería mi carne...");
                    //Vibración
                    mBuilder.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000
                    });
                    //LED
                    mBuilder.setLights(Color.BLUE, 3000, 3000);
                    //Tono
                    Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    mBuilder.setSound(uri);
                    /*
                    standard room navigation by intent, giving game as info to the next room
                     */
                    Intent intent= new Intent(this, Laboratorio.class);
                    intent.putExtra("Juego", miJuego);
                    TaskStackBuilder stackBuilder = TaskStackBuilder.create
                            (this); stackBuilder.addParentStack(Laboratorio.class);
                    stackBuilder.addNextIntent(intent);

                    PendingIntent pendingIntent =
                            stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                    mBuilder.setContentIntent(pendingIntent);
                    NotificationManager mNotificationManager =
                            (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    mNotificationManager.notify(0, mBuilder.build());

                      /*
                    standard room navigation by intent, giving game as info to the next room
                     */
                    Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Pista1");
                    Intent i = new Intent(this, clase);
                    i.putExtra("Juego", miJuego);
                    startActivity(i);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }else{
                miJuego.setVida(miJuego.getVida() - 20);
                lblVida.setText(String.valueOf(miJuego.getVida()));
                Toast t = Toast.makeText(this,"ARGH!",Toast.LENGTH_SHORT);
                t.show();
            }
        }

    }
}
