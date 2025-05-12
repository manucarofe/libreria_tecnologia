/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.ejercicios.lastierrasdezaltor.logica;

/**
 *
 * @author manue
 */
public abstract class Personaje {

    public int vida;
    public int ataque;
    public int defensa;
    public int velocidad;
    public String habilidadEspecial;
    public int exp;
    public String nombre;
    public String clase;
    public int nivel;

    public Personaje(int vida, int ataque, int defensa, int velocidad, String habilidadEspecial, String nombre) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.habilidadEspecial = habilidadEspecial;
        this.exp = exp;
        this.nombre = nombre;
    }

    public void recibirDaño(Personaje personaje, Enemigo enemigo) throws JuegoException {
        int cantidad = enemigo.ataque;
        int danioRecibido = Math.max(0, cantidad - defensa);
        vida -= danioRecibido;
        if (vida <= 0) {
            throw new JuegoException(personaje + " ha sido derrotado.");
        }
    }

    public boolean estaVivo(Personaje jugador) {
        
        if (vida > 0) {
            return true;
        }
        return vida <= 0;
    }

    public void ganarExperiencia(int i, Enemigo enemigo, Personaje jugador) {
        if(enemigo.vida<= 0){
            i = enemigo.exp;
            jugador.exp = i;
        }
    }
}
