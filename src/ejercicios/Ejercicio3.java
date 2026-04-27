package ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        double sumaEdad = 0, sumaEstatura = 0;
        int total = 0;

        try (Scanner sc = new Scanner(new FileReader("src/txt/Alumnos.txt"))) {
            while (sc.hasNext()) {
                String nombre = sc.next();
                int edad = Integer.parseInt(sc.next());
                double estatura = Double.parseDouble(sc.next());
                
                System.out.println("Alumno: " + nombre);
                sumaEdad += edad;
                sumaEstatura += estatura;
                total++;
            }
            if (total > 0) {
                System.out.println("\nMedia Edad: " + (sumaEdad / total));
                System.out.println("Media Estatura: " + (sumaEstatura / total));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}