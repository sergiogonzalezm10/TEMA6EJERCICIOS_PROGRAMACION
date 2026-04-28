package ejerciciosboletin2;

import java.io.*;
import java.util.*;

public class Ejercicio2 {

    public static void main(String[] args) {

        ArrayList<String> firmas = new ArrayList<>();
        File file = new File("src/archivosejerciciosboletin2/firmas.txt");

        if (file.exists()) {
            try (Scanner sc = new Scanner(new FileReader(file))) {
                while (sc.hasNextLine()) {
                    String nombre = sc.nextLine().trim();
                    if (!nombre.isEmpty()) firmas.add(nombre);
                }
            } catch (IOException e) {
                System.out.println("Error al cargar firmas.");
            }
        }

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\n--- LIBRO DE FIRMAS ---");
            System.out.println("1. Ver firmas\n2. Añadir firma\n3. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    if (firmas.isEmpty()) {
                        System.out.println("El libro está vacío.");
                    } else {
                        for (int i = 0; i < firmas.size(); i++)
                            System.out.println((i + 1) + ". " + firmas.get(i));
                    }
                }
                case 2 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine().trim();
                    if (firmas.contains(nombre)) {
                        System.out.println("Ese nombre ya está en el libro.");
                    } else {
                        firmas.add(nombre);
                        System.out.println("Firma añadida.");
                    }
                }
                case 3 -> {
                    file.getParentFile().mkdirs();
                    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                        for (String nombre : firmas) {
                            out.write(nombre);
                            out.newLine();
                        }
                    } catch (IOException e) {
                        System.out.println("Error al guardar.");
                    }
                    System.out.println("Firmas guardadas. ¡Hasta luego!");
                }
                default -> System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}