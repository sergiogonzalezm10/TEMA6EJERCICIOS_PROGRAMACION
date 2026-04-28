package ejerciciosboletin1;

import java.io.*;
import java.util.Scanner;

/**
 * Clase para añadir el nombre y la edad de un usuario a un archivo existente.
 */
public class Ejercicio5 {

    /**
     * Pide datos por consola y los añade al final del archivo 'datos.txt'.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();

        // El parámetro 'true' en FileWriter permite añadir texto sin borrar el anterior
        try (BufferedWriter out = new BufferedWriter(new FileWriter("src/archivosejerciciosboletin2/datos.txt", true))) {
            
            out.write(nombre + " " + edad);
            out.newLine();
            
            System.out.println("Datos guardados correctamente.");
            
        } catch (IOException e) {
        	// Posibles errores de escritura 
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}