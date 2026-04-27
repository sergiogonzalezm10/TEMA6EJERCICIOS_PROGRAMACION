package ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();

        try (BufferedWriter out = new BufferedWriter(new FileWriter("src/archivosEjercicios/datos.txt", true))) {
            out.write(nombre + " " + edad);
            out.newLine();
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}
