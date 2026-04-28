package ejerciciosboletin1;

import java.io.*;
import java.util.Scanner;

/**
 * Clase para escribir frases en un archivo de texto hasta que se escriba "fin".
 */
public class Ejercicio4 {

    /**
     * Pide cadenas por consola y las guarda en 'cadenas.txt'.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Abrimos el archivo en modo escritura
        try (BufferedWriter out = new BufferedWriter(new FileWriter("src/archivosejerciciosboletin1/cadenas.txt"))) {
            String cadena;
            System.out.println("Introduce frases (escribe 'fin' para terminar):");
            
            // Bucle infinito que se detiene al recibir la palabra "fin"
            while (true) {
                cadena = sc.nextLine();
                
                // Comparamos sin importar mayúsculas o minúsculas
                if (cadena.equalsIgnoreCase("fin")) {
                    break;
                }
                
                out.write(cadena); // Escribe la frase
                out.newLine();     // Añade un salto de línea
            }
            System.out.println("Archivo guardado con éxito.");
            
        } catch (IOException e) {
         	// Posibles errores de escritura 
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}