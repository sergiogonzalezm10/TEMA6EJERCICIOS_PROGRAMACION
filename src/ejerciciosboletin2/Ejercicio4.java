package ejerciciosboletin2;

import java.io.*;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        File fileCodec   = new File("src/txtejerciciosboletin2/codec.txt");
        File fileEntrada = new File("src/txtejerciciosboletin2/carta2.txt");
        File fileSalida  = new File("src/archivosejerciciosboletin2/carta_cifrada.txt");

        char[] original = new char[26];
        char[] cifrado  = new char[26];

        try (Scanner sc = new Scanner(new FileReader(fileCodec))) {
            String[] partesOriginales = sc.nextLine().trim().split(" ");
            String[] partesCifradas = sc.nextLine().trim().split(" ");

            for (int i = 0; i < 26; i++) {
                original[i] = partesOriginales[i].charAt(0);
                cifrado[i]  = partesCifradas[i].charAt(0);
            }
        } catch (IOException e) {
            System.out.println("Error al leer codec.txt: " + e.getMessage());
            return;
        }

        fileSalida.getParentFile().mkdirs();

        try (BufferedReader in  = new BufferedReader(new FileReader(fileEntrada));
             BufferedWriter out = new BufferedWriter(new FileWriter(fileSalida))) {

            int leido;
            while ((leido = in.read()) != -1) {
                char c = (char) leido;
                char lower = Character.toLowerCase(c);
                char resultado = c;

                for (int i = 0; i < 26; i++) {
                    if (original[i] == lower) {
                        resultado = Character.isUpperCase(c)
                                ? Character.toUpperCase(cifrado[i])
                                : cifrado[i];
                        break;
                    }
                }
                out.write(resultado);
            }
            System.out.println("Fichero cifrado guardado en archivosejerciciosboletin2/carta_cifrada.txt");

        } catch (IOException e) {
            System.out.println("Error al cifrar: " + e.getMessage());
        }
    }
}
