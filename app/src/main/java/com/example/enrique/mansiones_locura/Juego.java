package com.example.enrique.mansiones_locura;

/**
 * Created by Enrique on 01/12/2015.
 */

public class Juego {
    int vida;
    int acciones;
    int turnos;

    final int MAX_TURNOS = 15;

    Juego(int vida){
        this.vida = vida;
        acciones = 0;
        turnos = 0;
    }
    public void setVida(int vida){
        this.vida = vida;
    }

    public void setAcciones(int acciones){
        this.acciones = acciones;
    }

    public void setTurnos(int turnos){
        this.turnos = turnos;
    }

    public int getVida(){
        return vida;
    }

    public int getAcciones(){
        return acciones;
    }

    public int getTurnos(){
        return turnos;
    }

}
