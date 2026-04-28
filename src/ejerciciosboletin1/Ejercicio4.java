package ejerciciosboletin1;

import java.io.*;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (BufferedWriter out = new BufferedWriter(new FileWriter("src/archivosejerciciosboletin1/cadenas.txt"))) {
            String cadena;
            System.out.println("Introduce frases (escribe 'fin' para terminar):");
            
            while (true) {
                cadena = sc.nextLine();
                
                if (cadena.equalsIgnoreCase("fin")) {
                    break;
                }
                
                out.write(cadena);
                out.newLine();    
            }
            System.out.println("Archivo guardado con éxito.");
            
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}