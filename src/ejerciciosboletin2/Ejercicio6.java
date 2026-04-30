package ejerciciosboletin2;

import java.io.*;
import java.util.Scanner;


public class Ejercicio6 {

    public static void main(String[] args) {
        File file = new File("src/txtejerciciosboletin2/deportistas.txt");

        String nombreMayorEdad = "", nombreMayorPeso = "", nombreMayorEstatura = "";
        int mayorEdad       = -1;
        double mayorPeso    = -1, mayorEstatura = -1;

        try (Scanner sc = new Scanner(new FileReader(file))) {

            sc.nextLine();

            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();
                if (linea.isEmpty()) continue;

                String[] partes = linea.split(";");
                String nombre   = partes[0].trim() + " " + partes[1].trim();
                int edad        = Integer.parseInt(partes[2].trim());
                double peso     = Double.parseDouble(partes[3].trim());
                double estatura = Double.parseDouble(partes[4].trim());

                if (edad     > mayorEdad)     { mayorEdad     = edad;     nombreMayorEdad     = nombre; }
                if (peso     > mayorPeso)     { mayorPeso     = peso;     nombreMayorPeso     = nombre; }
                if (estatura > mayorEstatura) { mayorEstatura = estatura; nombreMayorEstatura = nombre; }
            }

            System.out.println("Mayor edad:     " + nombreMayorEdad     + " (" + mayorEdad     + " años)");
            System.out.println("Mayor peso:     " + nombreMayorPeso     + " (" + mayorPeso     + " kg)");
            System.out.println("Mayor estatura: " + nombreMayorEstatura + " (" + mayorEstatura + " m)");

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}