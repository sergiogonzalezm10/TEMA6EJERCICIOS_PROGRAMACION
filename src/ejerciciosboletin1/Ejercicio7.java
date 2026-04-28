package ejerciciosboletin1;

import java.io.*;
import java.util.*;

/**
 * Clase que gestiona una agenda telefónica simple.
 * Permite añadir, buscar y listar contactos, guardando los datos en un archivo.
 */
public class Ejercicio7 {

    /**
     * Punto de entrada de la agenda con menú interactivo por consola.
     */
    public static void main(String[] args) {
        // TreeMap mantiene los contactos ordenados alfabéticamente
        TreeMap<String, String> agenda = new TreeMap<>();
        File file = new File("src/archivosejerciciosboletin1/agenda.txt");

        // Carga inicial: Si el archivo existe, leemos los datos previos
        if (file.exists()) {
            try (Scanner scFile = new Scanner(new FileReader(file))) {
                while (scFile.hasNext()) {
                    String nombre = scFile.next();
                    String tlf = scFile.next();
                    agenda.put(nombre, tlf);
                }
            } catch (IOException e) {
                System.out.println("Error al cargar agenda.");
            }
        }

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Bucle del menú principal
        while (opcion != 4) {
            System.out.println("\nAGENDA");
            System.out.println("1. Nuevo contacto\n2. Buscar por nombre\n3. Mostrar todos\n4. Salir");
            
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner (importante tras nextInt)

            switch (opcion) {
                case 1 -> { // Añadir contacto con límite de 20
                    if (agenda.size() < 20) {
                        System.out.print("Nombre: ");
                        String n = sc.nextLine();
                        if (!agenda.containsKey(n)) {
                            System.out.print("Teléfono: ");
                            agenda.put(n, sc.nextLine());
                        } else System.out.println("El nombre ya existe.");
                    } else System.out.println("Agenda llena.");
                }
                case 2 -> { // Buscar teléfono por nombre
                    System.out.print("Nombre a buscar: ");
                    String b = sc.nextLine();
                    System.out.println("Teléfono: " + agenda.getOrDefault(b, "No encontrado"));
                }
                case 3 -> // Mostrar toda la agenda
                    agenda.forEach((k, v) -> System.out.println(k + " -> " + v));
                
                case 4 -> { // Guardar datos en el archivo antes de salir
                    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                        for (var entrada : agenda.entrySet()) {
                            out.write(entrada.getKey() + " " + entrada.getValue());
                            out.newLine();
                        }
                        System.out.println("Agenda guardada. ¡Adiós!");
                    } catch (IOException e) {
                        System.out.println("Error al guardar.");
                    }
                }
            }
        }
    }
}