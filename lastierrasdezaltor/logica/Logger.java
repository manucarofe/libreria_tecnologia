/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.ejercicios.lastierrasdezaltor.logica;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author manue
 */
public class Logger {
    private static final String Log = "logs.txt";
    public static void registrarEvento(String mensaje){
        String evento = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String registro = "[" + evento + "]" +mensaje;

        //Escribimos en el archivo .txt
        try(FileWriter writer = new FileWriter("logs.txt", true)){
            writer.write("[" +evento+ "]" +mensaje+ "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de texto" +e.getMessage());
        }
        //Mostrar en el área de texto
        Logger.registrarEvento(registro + "\n");

    }

}
