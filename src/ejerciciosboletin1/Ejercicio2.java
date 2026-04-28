package ejerciciosboletin1;

import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {


    public static void main(String[] args) {
        int suma = 0;
        int contador = 0;

        try (Scanner sc = new Scanner(new FileReader("src/txt/Enteros.txt"))) {
            
            while (sc.hasNextInt()) {
                suma += sc.nextInt();
                contador++;
            }
            
            if (contador > 0) {
                System.out.println("Suma: " + suma);
                System.out.println("Media: " + (double) suma / contador);
            }
            
        } catch (IOException e) {
            System.out.println("No se pudo acceder al archivo.");
        }
    }
}