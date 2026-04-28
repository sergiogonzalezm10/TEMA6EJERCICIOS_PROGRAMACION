package ejerciciosboletin2;

import java.io.*;
import java.util.Scanner;

/**
 * Clase que simula el comando 'more' de Linux.
 * Muestra el fichero de 24 en 24 líneas.
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        File file = new File("src/archivosejerciciosboletin2/carta.txt");
        Scanner teclado = new Scanner(System.in);

        try (Scanner sc = new Scanner(new FileReader(file))) {
            int contadorLineas = 0;

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
                contadorLineas++;

                // Cada 24 líneas espera que el usuario pulse ENTER
                if (contadorLineas % 24 == 0) {
                    System.out.print("Pulsa ENTER para continuar");
                    teclado.nextLine();
                }
            }
            System.out.println("FIN DEL FICHERO");

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        teclado.close();
    }
}