package ejercicios;

import java.io.*;
import java.util.*;

public class Ejercicio7{
    public static void main(String[] args) {
        TreeMap<String, String> agenda = new TreeMap<>();
        File file = new File("src/archivosEjercicios/agenda.txt");

        if (file.exists()) {
            try (Scanner sc = new Scanner(new FileReader(file))) {
                while (sc.hasNext()) {
                    String nombre = sc.next();
                    String tlf = sc.next();
                    agenda.put(nombre, tlf);
                }
            } catch (IOException e) {
                System.out.println("Error al cargar agenda.");
            }
        }

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n--- AGENDA ---");
            System.out.println("1. Nuevo contacto\n2. Buscar por nombre\n3. Mostrar todos\n4. Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> {
                    if (agenda.size() < 20) {
                        System.out.print("Nombre: ");
                        String n = teclado.nextLine();
                        if (!agenda.containsKey(n)) {
                            System.out.print("Teléfono: ");
                            agenda.put(n, teclado.nextLine());
                        } else System.out.println("El nombre ya existe.");
                    } else System.out.println("Agenda llena.");
                }
                case 2 -> {
                    System.out.print("Nombre a buscar: ");
                    String b = teclado.nextLine();
                    System.out.println("Teléfono: " + agenda.getOrDefault(b, "No encontrado"));
                }
                case 3 -> agenda.forEach((k, v) -> System.out.println(k + " -> " + v));
                case 4 -> {
                    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                        for (var entrada : agenda.entrySet()) {
                            out.write(entrada.getKey() + " " + entrada.getValue());
                            out.newLine();
                        }
                    } catch (IOException e) {
                        System.out.println("Error al guardar.");
                    }
                }
            }
        }
    }
}