package ejerciciosboletin2;

import java.io.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        String rutaFichero = "src/txtejerciciosboletin2/carta.txt";

        int numCaracteres = 0;
        int numLineas = 0;
        int numPalabras = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                numLineas++;

                numCaracteres += linea.length();

                if (!linea.trim().isEmpty()) {
                    String[] palabras = linea.trim().split("\\s+");
                    numPalabras += palabras.length;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el fichero '" + rutaFichero + "'");
            return;
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            return;
        }

        System.out.println("Estadísticas del fichero carta.txt");
        System.out.println("Número de líneas:    " + numLineas);
        System.out.println("Número de palabras:  " + numPalabras);
        System.out.println("Número de caracteres: " + numCaracteres);
    }
}