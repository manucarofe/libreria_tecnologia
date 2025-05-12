package com.miempresa.ejercicios.lastierrasdezaltor.logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PersonajeDAO {
    public void insertarPersonaje(Personaje personaje){
        String query = "INSERT INTO personajes (nombre, clase, vida, ataque, defensa, velocidad, nivel, experiencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, personaje.nombre);
            ps.setString(2, personaje.clase);
            ps.setInt(3, personaje.vida);
            ps.setInt(4, personaje.ataque);
            ps.setInt(5, personaje.defensa);
            ps.setInt(6, personaje.velocidad);
            ps.setInt(7, personaje.exp);
            ps.setInt(8, personaje.nivel);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Personaje obtenerPersonaje(int id) {
        String query = "SELECT * FROM personajes WHERE id = ?";
        Personaje personaje = null;

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getString("clase") == "guerrero"){
                    personaje = new Guerrero("Golpe devastador");
                    personaje = new Chaman(120, 12, 10, 10, "Curacion Mistica", "Manuel");
                    personaje = new Ninja(100, 15, 8, 15, "Ataque Silencioso", "Pakirrin");

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personaje;
    }
}
