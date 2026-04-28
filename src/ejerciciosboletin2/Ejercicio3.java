package ejerciciosboletin2;

import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        File file = new File("src/archivosejerciciosboletin2/carta.txt");
        Scanner sc = new Scanner(System.in);

        try (Scanner sc1 = new Scanner(new FileReader(file))) {
            int contadorLineas = 0;

            while (sc1.hasNextLine()) {
                System.out.println(sc1.nextLine());
                contadorLineas++;
                if (contadorLineas % 24 == 0) {
                    System.out.print("Pulsa ENTER para continuar");
                    sc1.nextLine();
                }
            }
            System.out.println("FIN DEL FICHERO");

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        sc.close();
    }
}