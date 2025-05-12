/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.ejercicios.lastierrasdezaltor.logica;

/**
 *
 * @author manue
 */
class NoMuerto extends Enemigo{
    

    public NoMuerto(int exp, int vida, int ataque, int defensa,int velocidad, String habilidadEspecial) {
        super(40, 100, 15, 8, 5, "Regeneracion");
    }


    
    public void regeneracion(Enemigo noMuerto){

        int regeneracion = noMuerto.vida + 10;
    }
}
