/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.ejercicios.lastierrasdezaltor.logica;

/**
 *
 * @author manue
 */
class Chaman extends Personaje{
    public int curacionMistica;
    private int exp;

    public Chaman(int vida, int ataque, int defensa, int velocidad, String habilidadEspecial,String nombre) {
        super(120, 12, 10, 10, "Curacion Mistica", "Manuel");
        this.curacionMistica = curacionMistica;
        this.exp = exp;
    }


    
    public void curar(Personaje chaman){
        
        curacionMistica = chaman.vida + 20;
        
    }
}
