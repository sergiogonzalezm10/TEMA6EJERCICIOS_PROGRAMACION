package ejerciciosboletin1;

import java.io.*;
import java.util.Scanner;
import java.util.Locale;

public class Ejercicio1 {

    public static void main(String[] args) {
        double suma = 0;
        int contador = 0;
        
        
        try (Scanner sc = new Scanner(new FileReader("src/txt/NumerosReales.txt"))) {
            
            sc.useLocale(Locale.US);
            
            
            while (sc.hasNextDouble()) {
                suma += sc.nextDouble();
                contador++;
            }
            
            
            if (contador > 0) {
                System.out.println("Suma: " + suma);
                System.out.println("Media: " + (suma / contador));
            } else {
                System.out.println("El archivo está vacío o no contiene números válidos.");
            }
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}