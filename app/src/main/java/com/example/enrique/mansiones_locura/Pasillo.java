package com.example.enrique.mansiones_locura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Pasillo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasillo);
    }

    public void toHabPrincipal(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.HabPrincipal");
            Intent i = new Intent(this,clase);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void toHabInvitados(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.HabInvitados");
            Intent i = new Intent(this,clase);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void toRecibidor(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Recibidor");
            Intent i = new Intent(this,clase);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
