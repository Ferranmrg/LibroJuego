package com.example.enrique.mansiones_locura;

import android.content.Intent;

import java.io.Serializable;

/**
 * Created by Enrique,Manuel and Ferran on 01/12/2015.
 */

public class Juego implements Serializable {
    private int vida;
    private int acciones;
    private int turnos;
    private boolean finJuego;
    private boolean message;

    private boolean pista1,pista2,pista3;

    final int MAX_TURNOS = 10;

    Juego(int vida) {
        this.vida = vida;
        acciones = 0;
        turnos = 0;
        finJuego = false;
        pista1 = false;
        pista2 = false;
        pista3 = false;
        message = false;
    }

    public void setVida(int vida) {
        this.vida = vida;
        if (vida <= 0)
            finJuego = true;
    }

    public void setAcciones(int acciones) {

        this.acciones = acciones;
        if (acciones == 3) {
            turnos++;
            this.acciones = 0;
        }
    }

    public void setTurnos(int turnos) {

        this.turnos = turnos;
        if (this.turnos <= MAX_TURNOS) {
            finJuego = true;
        }
    }

    public int getVida() {
        return vida;
    }

    public int getAcciones() {
        return acciones;
    }

    public int getTurnos() {
        return turnos;
    }

    public boolean finPartida() {
        return finJuego;
    }

    public boolean getPista1(){
        return this.pista1;
    }
    public boolean getPista2(){
        return this.pista2;
    }
    public boolean getPista3(){
        return this.pista3;
    }
    public void setPista1(boolean pista){
        this.pista1 = pista;
    }
    public void setPista2(boolean pista){
        this.pista2 = pista;
    }

    public void setPista3(boolean pista){
        this.pista3 = pista;
        this.finJuego = true;
    }

    public void setMessage(boolean resp){
        this.message = resp;
    }
    public boolean getMessage(){
        return message;
    }
}


