/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parcial1_juanaguirre;

/**
 *
 * @author LENOVO V14-G2
 */
import java.io.*;
import java.util.Scanner;

public class PARCIAL1_JUANAGUIRRE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del archivo que contiene a los pasajeros que ya compraron los tiquetes para Septiembre: ");
        String pasajerosSeptiembreArchivo = scanner.nextLine();

        System.out.print("Ingrese el nombre del archivo que contenga a los clientes que han viajado con nosotros en 2023: ");
        String clientes2023Archivo = scanner.nextLine();

        System.out.print("Ingrese el nombre para el archivo de ganadores: ");
        String ganadoresArchivo = scanner.nextLine();

        scanner.close();

        String pasajerosSeptiembreContenido = leerArchivo(pasajerosSeptiembreArchivo + ".txt");
        String clientes2023Contenido = leerArchivo(clientes2023Archivo + ".txt");

        String ganadoresContenido = generarGanadoresContenido(pasajerosSeptiembreContenido, clientes2023Contenido);

        generarGanadoresArchivo(ganadoresContenido, ganadoresArchivo + ".txt");

        System.out.println("Listo, puedes revisar el directorio y encontrar el archivo con los ganadores, Felicidades a los ganadores!, el archivo se llama: " + ganadoresArchivo + ".txt");
    }

    public static String leerArchivo(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenido.toString();
    }

    public static String generarGanadoresContenido(String pasajerosContenido, String clientesContenido) {
        StringBuilder ganadoresContenido = new StringBuilder();

        String[] lineasPasajeros = pasajerosContenido.split("\n");
        String[] lineasClientes = clientesContenido.split("\n");

        for (String pasajero : lineasPasajeros) {
            String[] camposPasajero = pasajero.split("\\s+");
            String cedula = camposPasajero[0];
            String nombre = camposPasajero[1];

            int viajes = 0;
            for (String cliente : lineasClientes) {
                String[] camposCliente = cliente.split("\\s+");
                if (cedula.equals(camposCliente[0])) {
                    viajes = viajes + 1;
                }
            }

            if (viajes >= 3 && ganadoresContenido.indexOf(cedula) == -1) {
                int bono = viajes * 50000;
                String ganador = cedula + "\t" + nombre + "\t" + bono;
                ganadoresContenido.append(ganador).append("\n");
            }
        }

        return ganadoresContenido.toString();
    }

    public static void generarGanadoresArchivo(String ganadoresContenido, String nombreArchivo) {
        try (FileWriter fw = new FileWriter(nombreArchivo);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            pw.println("Cédula\tNombre\tBono");
            pw.print(ganadoresContenido);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}