package com.miempresa.ejercicios.lastierrasdezaltor.logica;

import java.util.Scanner;

/**
 *
 * @author manue
 */
public class Juego {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws JuegoException {
        Juego juego = new Juego();
        Mundo mundo = new Mundo();
        Enemigo enemigo;
        Personaje jugador;

        jugador = juego.seleccionarClase();

        enemigo = mundo.generarEnemigoAleatorio();
        mundo.iniciarCombate(jugador, enemigo);
        //Uso de habilidad sin energía
        try {
            ((Guerrero) jugador).golpeDebastador(enemigo, jugador);
        } catch (EnergiaInsuficienteException e) {
            System.out.println(e.getMessage());
        }
        //Exploración de zona sin éxito
        try {
            Mundo.explorarZona("Castillo Tenebroso");
        } catch (ZonaBloqueadaException e) {
            System.out.println(e.getMessage());
        }
    }

    public Personaje seleccionarClase() {
        Personaje jugador = null;
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a Las Tierras de Zaltor!, como te llamas?: ");

        System.out.println("Elija su clase: 1.Guerrero 2.Ninja 3.Chaman");
        int eleccion = scanner.nextInt();

        switch (eleccion) {
            case 1:
                jugador = new Guerrero("Golpe Devastador");
                return jugador;
            case 2:
                jugador = new Ninja(100, 15, 8, 15, "Ataque Silencioso", "Pakirrin");
                return jugador;
            case 3:
                jugador = new Chaman(120, 12, 10, 10, "Curacion Mistica", "Juan");
                return jugador;
            default:
                System.out.println("Opción inválida, serás un Guerrero por defecto.");
                jugador = new Guerrero("Golpe Devastador");
        }
        return null;
    }

    public void realizarAccion(Personaje jugador, Enemigo enemigo) throws JuegoException {
        System.out.println("\n Este es el menu de acciones:");
        System.out.println("1. Atacar básico");

        // Mostrar opción de habilidad especial según la clase
        if (jugador instanceof Guerrero) {
            System.out.println("2. Golpe devastador (Doble daño)");
        } else if (jugador instanceof Ninja) {
            System.out.println("2. Ataque sigiloso (+5 daño)");
        } else if (jugador instanceof Chaman) {
            System.out.println("2. Curación mística (+20 vida)");
            System.out.println("3. Atacar básico y curar");
        }

        System.out.println("0. Huir (pierdes experiencia)");
        System.out.print("Elige tu acción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1: // Ataque básico
                enemigo.recibirDaño(jugador, enemigo);
                break;

            case 2: // Habilidad especial
                if (jugador instanceof Guerrero) {
                    ((Guerrero) jugador).golpeDebastador(enemigo, jugador);
                } else if (jugador instanceof Ninja) {
                    ((Ninja) jugador).ataqueSigiloso(enemigo, jugador);
                } else if (jugador instanceof Chaman) {
                    ((Chaman) jugador).curar(new Chaman(120, 12, 10, 10, "Curacion Mistica", "Juan"));
                }
                break;

            case 3: // Opción solo para Chaman (atacar y curar)
                if (jugador instanceof Chaman) {
                    jugador.recibirDaño(jugador, enemigo);
                    ((Chaman) jugador).curar(new Chaman(120, 12, 10, 10, "Curacion Mistica", "Juan"));
                } else {
                    System.out.println("Opción no válida. Pierdes tu turno.");
                }
                break;
            default:
                System.out.println("Opción no válida. Pierdes tu turno.");
        }

        // Turno del enemigo si sigue vivo
        if (enemigo.estaVivo(enemigo)) {
            System.out.println("\n--- TURNO DEL ENEMIGO ---");
            jugador.recibirDaño(jugador, enemigo);
        }
    }

}
