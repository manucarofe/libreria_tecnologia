/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.ejercicios.lastierrasdezaltor.logica;

import com.miempresa.ejercicios.lastierrasdezaltor.gui.VentanaJuego;
import javax.swing.*;

/**
 *
 * @author manue
 */
public class Guerrero extends Personaje {
    public int golpeDebastador;
    public int energia;

    public Guerrero(String habilidadEspecial) {
        super(150, 18, 12, 6, habilidadEspecial, "Manuel");
        this.energia = energia;
        this.golpeDebastador = golpeDebastador;
    }


    public void golpeDebastador(Enemigo enemigo, Personaje guerrero) throws EnergiaInsuficienteException {
        energia = 50;
        if (energia < 20) {
            String mensaje = nombre + " no tiene suficiente energía para usar su habilidad especial.";
            Logger.registrarEvento("ERROR: " +mensaje);
            throw new EnergiaInsuficienteException(guerrero + " no tiene suficiente energía para usar su habilidad especial.");
        }
        golpeDebastador = guerrero.ataque * 2;
        enemigo.vida = enemigo.vida - golpeDebastador;
        energia -= 20;
        Logger.registrarEvento(nombre + " usa la habilidad especial.");
        System.out.println(guerrero + " usa un golpe devastador.");
        
    }
    
}
