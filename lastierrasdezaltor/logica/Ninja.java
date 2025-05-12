/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.ejercicios.lastierrasdezaltor.logica;

/**
 *
 * @author manue
 */
class Ninja extends Personaje{
    public int ataqueSigiloso;

    public Ninja(int vida, int ataque, int defensa, int velocidad, String habilidadEspecial, String nombre) {
        super(100, 15, 8, 15, "Ataque Silencioso", "Pakirrin");
        this.ataqueSigiloso = ataqueSigiloso;
    }
    
    public void ataqueSigiloso(Enemigo enemigo, Personaje jugador){
        ataqueSigiloso = jugador.ataque + 5;
        enemigo.vida -= ataqueSigiloso;
        
    }



}
