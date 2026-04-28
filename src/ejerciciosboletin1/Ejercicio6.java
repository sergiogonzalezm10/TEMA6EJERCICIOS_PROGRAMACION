package ejerciciosboletin1;

import java.io.*;
import java.util.*;

/**
 * Clase que lee números de un archivo, los ordena de menor a mayor
 * y los guarda en un nuevo archivo.
 */
public class Ejercicio6 {

    /**
     * Procesa el archivo de números desordenados y genera uno ordenado.
     */
    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<>();

        // 1. Leemos los números y los guardamos en una lista
        try (Scanner sc = new Scanner(new FileReader("src/txt/numerosDesordenados.txt"))) {
            while (sc.hasNextInt()) {
                listaNumeros.add(sc.nextInt());
            }
        } catch (IOException e) {
        	// Posibles errores de lectura 
            System.out.println("Error al leer: " + e.getMessage());
        }

        // 2. Ordenamos la lista numéricamente
        Collections.sort(listaNumeros);

        // 3. Escribimos la lista ordenada en el nuevo archivo
        try (BufferedWriter out = new BufferedWriter(new FileWriter("src/archivosejerciciosboletin1/numerosOrdenados.txt"))) {
            for (Integer num : listaNumeros) {
                out.write(num.toString());
                out.newLine();
            }
            System.out.println("Archivo ordenado creado con éxito.");
        } catch (IOException e) {
        	// Posibles errores de escritura 
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }
}