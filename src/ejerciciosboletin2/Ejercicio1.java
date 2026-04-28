package ejerciciosboletin2;

import java.io.*;

/**
 * Clase que calcula estadísticas de un archivo de texto: 
 * número de líneas, palabras y caracteres.
 */
public class Ejercicio1 {

    /**
     * Lee el archivo 'carta.txt' y analiza su contenido para mostrar el conteo final.
     */
    public static void main(String[] args) {
        String rutaFichero = "src/txtejerciciosboletin2/carta.txt";

        int numCaracteres = 0;
        int numLineas = 0;
        int numPalabras = 0;

        // Utilizamos BufferedReader para leer el texto línea por línea
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                numLineas++;

                // Sumamos la longitud de cada línea al total de caracteres
                numCaracteres += linea.length();

                // Si la línea no está vacía, contamos las palabras
                if (!linea.trim().isEmpty()) {
                    String[] palabras = linea.trim().split("\\s+");
                    numPalabras += palabras.length;
                }
            }

        } catch (FileNotFoundException e) {
        	// Posibles errores de ruta 
            System.out.println("Error: No se encontró el fichero '" + rutaFichero + "'");
            return;
        } catch (IOException e) {
        	// Posibles errores de lectura 
            System.out.println("Error al leer el fichero: " + e.getMessage());
            return;
        }

        // Mostramos los resultados obtenidos
        System.out.println("Estadísticas del fichero carta.txt");
        System.out.println("Número de líneas:    " + numLineas);
        System.out.println("Número de palabras:  " + numPalabras);
        System.out.println("Número de caracteres: " + numCaracteres);
    }
}