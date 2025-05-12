/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.ejercicios.lastierrasdezaltor.logica;

/**
 *
 * @author manue
 */
public class Enemigo extends Personaje{
    
    public int exp;

    public Enemigo(int exp, int vida, int ataque, int defensa, int velocidad, String habilidadEspecial) {
        super(vida, ataque, defensa, velocidad, habilidadEspecial, "Manuel");
        this.exp = exp;
    }
    
    public int getExp() {

        return exp;
    }

    public void setExp(int exp) {

        this.exp = exp;
    }
    
    public void habilidadEspecial(){
        
    }
    
    public void atacar(Enemigo enemigo, Personaje personaje){
        
        personaje.vida = personaje.vida - enemigo.ataque;
    }
    
    public boolean estaVivo(Enemigo enemigo){
        
        if(enemigo.vida > 0){
            return true;
        }
        return vida <= 0;
    }
    
    @Override
    public void recibirDaño(Personaje personaje, Enemigo enemigo){
        int cantidad = enemigo.vida + enemigo.defensa;
        enemigo.vida = cantidad - personaje.ataque;
    }
}
