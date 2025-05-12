package com.miempresa.ejercicios.lastierrasdezaltor.logica;

/**
 *
 * @author manue
 */
public class Mundo {

    public Enemigo generarEnemigoAleatorio() {
        Enemigo enemigo = null;
        int zona = (int) (Math.random() * 3);
        switch (zona) {
            case 1:
                enemigo = new LoboSalvaje(30, 80, 12, 5, 18, "Mordida Rapida");
                return enemigo;
            case 2:
                enemigo = new GuerreroOscuro(130, 50, 10,"Furia Maldita" , 4, 20);
               return enemigo;
            case 3:
                enemigo = new NoMuerto(40, 100, 15, 8, 5, "Regeneracion");
                return enemigo;
        }
        return enemigo;
    }

    public void iniciarCombate(Personaje jugador, Enemigo enemigo) throws JuegoException {
        System.out.println("Un "+ enemigo +"ha aparecido");
        Logger.registrarEvento("El combate ha empezado " +jugador.nombre+ " vs " +enemigo);
        try{
        while(jugador.estaVivo(jugador) && enemigo.estaVivo(enemigo)){
            if(jugador.velocidad > enemigo.velocidad){
                enemigo.recibirDaño(jugador, enemigo);
                Logger.registrarEvento("El "+enemigo+" ha recibido un ataque del "+jugador.nombre);
            }else{
                jugador.recibirDaño(jugador, enemigo);
                Logger.registrarEvento("El "+jugador.nombre+" ha recibido un ataque del "+enemigo);
            }
        }
        }catch(JuegoException e){
        System.out.println(e.getMessage());
        Logger.registrarEvento("EVENTO:" +e.getMessage());
        }
    
    }

    public static void explorarZona(String zona) throws ZonaBloqueadaException {
        if (zona.equals("Castillo Tenebroso")) {
            String mensaje = "ERROR: No tienes la llave para entrar a este sitio.";
            Logger.registrarEvento(mensaje);
            throw new ZonaBloqueadaException(mensaje);
        }
        Logger.registrarEvento("Explorando la zona: " + zona);
        System.out.println("Explorando la zona: " + zona);
    }
}
