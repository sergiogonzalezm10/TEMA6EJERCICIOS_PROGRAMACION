package ejerciciosboletin1;

import java.io.*;
import java.util.Scanner;
import java.util.Locale;

/**
 * Esta clase se encarga de leer números reales desde un archivo de texto
 * para calcular su suma total y su media aritmética.
 */
public class Ejercicio1 {

    /**
     * Punto de entrada principal de la aplicación.
     * Realiza la lectura del archivo 'NumerosReales.txt', acumula los valores
     * y muestra los resultados por consola.
     */
    public static void main(String[] args) {
        double suma = 0;
        int contador = 0;
        
        // Abrimos el Scanner con try-catch
        try (Scanner sc = new Scanner(new FileReader("src/txt/NumerosReales.txt"))) {
            
            sc.useLocale(Locale.US);
            
            // Leemos el archivo mientras existan números decimales
            while (sc.hasNextDouble()) {
                suma += sc.nextDouble();
                contador++;
            }
            
            // Si se ha leído al menos un número, mostramos los resultados
            if (contador > 0) {
                System.out.println("Suma: " + suma);
                System.out.println("Media: " + (suma / contador));
            } else {
                System.out.println("El archivo está vacío o no contiene números válidos.");
            }
            
        } catch (IOException e) {
            // Posibles errores de lectura 
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}