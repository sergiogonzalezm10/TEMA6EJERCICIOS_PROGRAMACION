package ejerciciosboletin2;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre del primer fichero (sin ruta):  ");
        File file1 = new File("src/txtejerciciosboletin2/" + teclado.nextLine().trim());
        System.out.print("Nombre del segundo fichero (sin ruta): ");
        File file2 = new File("src/txtejerciciosboletin2/" + teclado.nextLine().trim());

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2))) {

            String linea1, linea2;
            int numLinea = 0;
            boolean iguales = true;

            while (true) {
                linea1 = br1.readLine();
                linea2 = br2.readLine();
                numLinea++;

                if (linea1 == null && linea2 == null) break;

                if (linea1 == null || linea2 == null) {
                    System.out.println("Son DISTINTOS. Uno termina antes en la línea " + numLinea);
                    iguales = false;
                    break;
                }

                int maxLen = Math.max(linea1.length(), linea2.length());
                for (int i = 0; i < maxLen; i++) {
                    char c1 = i < linea1.length() ? linea1.charAt(i) : '\0';
                    char c2 = i < linea2.length() ? linea2.charAt(i) : '\0';
                    if (c1 != c2) {
                        System.out.println("Son DISTINTOS.");
                        System.out.println("Primera diferencia -> Línea: " + numLinea + ", Carácter: " + (i + 1));
                        System.out.println("Fichero 1: '" + c1 + "'  |  Fichero 2: '" + c2 + "'");
                        iguales = false;
                        break;
                    }
                }
                if (!iguales) break;
            }

            if (iguales) System.out.println("Los ficheros son IGUALES.");

        } catch (IOException e) {
            System.out.println("Error al comparar: " + e.getMessage());
        }

        teclado.close();
    }
}