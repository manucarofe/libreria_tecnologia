/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.ejercicios.lastierrasdezaltor.logica;

/**
 *
 * @author manue
 */
public class GuerreroOscuro extends Enemigo{
    public int furiaMaldita;

    public GuerreroOscuro(int vida, int exp,int ataque, String habilidadEspecial,int velocidad, int defensa) {
        super(50, 120, 18, 8, 9, "Furia Maldita");
        this.furiaMaldita = furiaMaldita;
    }


    public void furiaMaldita(){
        furiaMaldita = ataque + 5;
        
    }
}
