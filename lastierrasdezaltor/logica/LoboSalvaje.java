package com.miempresa.ejercicios.lastierrasdezaltor.logica;

/**
 *
 * @author manue
 */
class LoboSalvaje extends Enemigo{
    public int mordidaRapida;

    public LoboSalvaje(int exp, int vida, int ataque, int defensa,int velocidad, String habilidadEspecial) {
        super(30, 80, 12, 5, 18, "Mordida Rapida");
        this.mordidaRapida = mordidaRapida;
    }


    
    public void mordidaRapida(){

        mordidaRapida = ataque + 2;
    }

}
