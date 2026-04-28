package ejerciciosboletin1;

import java.io.*;
import java.util.Scanner;

/**
 * Clase que suma números enteros desde un archivo y calcula su media.
 */
public class Ejercicio2 {

    /**
     * Lee los números del archivo 'Enteros.txt' y muestra el resultado.
     */
    public static void main(String[] args) {
        int suma = 0;
        int contador = 0;

        // Abrimos el archivo de texto
        try (Scanner sc = new Scanner(new FileReader("src/txt/Enteros.txt"))) {
            
            // Mientras haya números, los sumamos y contamos
            while (sc.hasNextInt()) {
                suma += sc.nextInt();
                contador++;
            }
            
            // Mostramos resultados si el archivo no estaba vacío
            if (contador > 0) {
                System.out.println("Suma: " + suma);
                System.out.println("Media: " + (double) suma / contador);
            }
            
        } catch (IOException e) {
        	// Posibles errores de acceso 
            System.out.println("No se pudo acceder al archivo.");
        }
    }
}