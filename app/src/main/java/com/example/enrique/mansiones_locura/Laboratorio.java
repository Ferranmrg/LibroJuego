package com.example.enrique.mansiones_locura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Laboratorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio);
    }

    public void toJardin(View view){
        try{
            Class<?> clase = Class.forName("com.example.enrique.mansiones_locura.Jardin");
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
