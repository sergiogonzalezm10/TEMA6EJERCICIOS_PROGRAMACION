package ejerciciosboletin2;

import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        File file = new File("src/txtejerciciosboletin2/carta2.txt");
        Scanner teclado = new Scanner(System.in);

        try (Scanner sc = new Scanner(new FileReader(file))) {
            int contadorLineas = 0;

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
                contadorLineas++;

                if (contadorLineas % 24 == 0) {
                    System.out.print("Pulsa ENTER para continuar");
                    teclado.nextLine(); // ← sc del teclado, no del fichero
                }
            }
            System.out.println("FIN DEL FICHERO");

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        teclado.close();
    }
}