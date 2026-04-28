package ejerciciosboletin1;

import java.io.*;
import java.util.Scanner;

/**
 * Clase para leer datos de alumnos (nombre, edad, estatura) y calcular medias.
 */
public class Ejercicio3 {

    /**
     * Lee el archivo 'Alumnos.txt' y muestra los datos y las medias por pantalla.
     */
    public static void main(String[] args) {
        double sumaEdad = 0, sumaEstatura = 0;
        int total = 0;

        // Intentamos abrir y leer el archivo
        try (Scanner sc = new Scanner(new FileReader("src/txt/Alumnos.txt"))) {
            
            // Leemos mientras existan datos (nombre, edad y estatura)
            while (sc.hasNext()) {
                String nombre = sc.next();
                int edad = Integer.parseInt(sc.next());
                double estatura = Double.parseDouble(sc.next());
                
                System.out.println("Alumno: " + nombre);
                sumaEdad += edad;
                sumaEstatura += estatura;
                total++;
            }
            
            // Si hay alumnos, calculamos y mostramos las medias
            if (total > 0) {
                System.out.println("\nMedia Edad: " + (sumaEdad / total));
                System.out.println("Media Estatura: " + (sumaEstatura / total));
            }
            
        } catch (IOException e) {
         	// Posibles errores
            System.out.println("Error: " + e.getMessage());
        }
    }
}