package com.miempresa.ejercicios.lastierrasdezaltor.gui;
import com.miempresa.ejercicios.lastierrasdezaltor.logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaJuego extends JFrame {
    private JTextArea areaLog;
    private JButton btnAtacar, btnHabilidad;
    private JLabel lblVidaEnemigo, lblVidaJugador;
    private Personaje jugador;
    private Enemigo enemigo;

    public VentanaJuego() {
        setTitle("Las Tierras de Zaltor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear los personajes
        jugador = new Guerrero("Manuel");
        enemigo = new GuerreroOscuro(120, 50, 18, "Furia Maldita", 9, 8);

        // Panel de combate
        JPanel panelCombate = new JPanel();
        lblVidaJugador = new JLabel("Jugador: " + jugador.nombre + " Vida: " + jugador.vida);
        lblVidaEnemigo = new JLabel("Enemigo: " + enemigo.nombre + " Vida: " + enemigo.vida);
        panelCombate.add(lblVidaJugador);
        panelCombate.add(lblVidaEnemigo);

        // Área de logs
        areaLog = new JTextArea(10, 40);
        areaLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaLog);

        // Botones de acción
        btnAtacar = new JButton("Atacar");
        btnHabilidad = new JButton("Habilidad Especial");

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAtacar);
        panelBotones.add(btnHabilidad);

        // Acción del botón Atacar
        btnAtacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personaje personaje = null;
                    jugador.recibirDaño(personaje, enemigo);
                    areaLog.append(jugador.nombre + " ataca a " + enemigo.nombre + "\n");
                    lblVidaEnemigo.setText("Enemigo Vida: " + enemigo.vida);

                    if (enemigo.vida <= 0) {
                        areaLog.append("¡" + enemigo.nombre + " ha sido derrotado!\n");
                        btnAtacar.setEnabled(false);
                        btnHabilidad.setEnabled(false);
                    } else {
                        enemigo.recibirDaño(jugador, enemigo);
                        areaLog.append(enemigo.nombre + " ataca a " + jugador.nombre + "\n");
                        lblVidaJugador.setText("Jugador Vida: " + jugador.vida);
                    }
                } catch (JuegoException ex) {
                    areaLog.append("EVENTO: " + ex.getMessage() + "\n");
                    btnAtacar.setEnabled(false);
                    btnHabilidad.setEnabled(false);
                }
            }
        });

        // Agregar componentes a la ventana
        add(panelCombate, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaJuego().setVisible(true));
    }
}


