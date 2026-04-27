package ejercicios;

import java.io.*;
import java.util.*;

public class Ejercicio6 {
    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<>();


        try (Scanner sc = new Scanner(new FileReader("src/txt/numerosDesordenados.txt"))) {
            while (sc.hasNextInt()) {
                listaNumeros.add(sc.nextInt());
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }

        Collections.sort(listaNumeros);

        try (BufferedWriter out = new BufferedWriter(new FileWriter("src/archivosEjercicios/numerosOrdenados.txt"))) {
            for (Integer num : listaNumeros) {
                out.write(num.toString());
                out.newLine();
            }
            System.out.println("Archivo ordenado creado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }
}