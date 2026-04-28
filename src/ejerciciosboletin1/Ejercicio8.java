package ejerciciosboletin1;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n1. Registrar nueva temperatura\n2. Mostrar historial\n3. Salir");
            op = sc.nextInt();

            if (op == 1) {
                try (BufferedWriter out = new BufferedWriter(new FileWriter("src/archivosejerciciosboletin1/temperaturas.txt", true))) {
                    System.out.print("Temp Máxima: "); int max = sc.nextInt();
                    System.out.print("Temp Mínima: "); int min = sc.nextInt();
                    
                    out.write(LocalDate.now() + "," + max + "," + min);
                    out.newLine();
                } catch (IOException e) {
                    System.out.println("Error al guardar datos.");
                }
            } else if (op == 2) {
                try (BufferedReader in = new BufferedReader(new FileReader("src/archivosejerciciosboletin1/temperaturas.txt"))) {
                    String linea;
                    int maxAbs = -999, minAbs = 999;
                    System.out.println("Fecha | Max | Min");
                    
                    while ((linea = in.readLine()) != null) {
                        String[] datos = linea.split(",");
                        int tMax = Integer.parseInt(datos[1]);
                        int tMin = Integer.parseInt(datos[2]);
                        
                        
                        if (tMax > maxAbs) maxAbs = tMax;
                        if (tMin < minAbs) minAbs = tMin;
                        
                        System.out.println(linea);
                    }
                    System.out.println("\nVALORES EXTREMOS:");
                    System.out.println("Máxima absoluta: " + maxAbs);
                    System.out.println("Mínima absoluta: " + minAbs);
                } catch (IOException e) {
                    System.out.println("No hay registros previos.");
                }
            }
        } while (op != 3);
    }
}