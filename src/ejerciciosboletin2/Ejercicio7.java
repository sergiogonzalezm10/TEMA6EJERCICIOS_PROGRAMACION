package ejerciciosboletin2;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Ejercicio7 {

    public static void main(String[] args) {

        ArrayList<Ejercicio7_Cliente> clientes = new ArrayList<>();

        File fileEntrada = new File("src/txtejerciciosboletin2/clientes.txt");
        
        File fileSalida  = new File("src/archivosejerciciosboletin2/clientes.txt");

        if (fileEntrada.exists()) {
            try (Scanner sc = new Scanner(new FileReader(fileEntrada))) {
                while (sc.hasNextLine()) {
                    String linea = sc.nextLine().trim();
                    if (linea.isEmpty()) continue;
                    String[] p = linea.split(";");
                    clientes.add(new Ejercicio7_Cliente(p[0], p[1], LocalDate.parse(p[2]), Double.parseDouble(p[3])));
                }
            } catch (IOException e) {
                System.out.println("Error al cargar clientes.");
            }
        }

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n--- BANCO ---");
            System.out.println("1. Alta cliente\n2. Baja cliente\n3. Listar clientes\n4. Salir");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("DNI: ");
                    String dni = teclado.nextLine().trim().toUpperCase();

                    boolean existe = false;
                    for (Ejercicio7_Cliente c : clientes)
                        if (c.getDni().equals(dni)) { existe = true; break; }

                    if (existe) {
                        System.out.println("Ya existe un cliente con ese DNI.");
                    } else {
                        System.out.print("Nombre completo: ");
                        String nombre = teclado.nextLine().trim();
                        System.out.print("Fecha nacimiento (aaaa-MM-dd): ");
                        LocalDate fecha = LocalDate.parse(teclado.nextLine().trim());
                        System.out.print("Saldo inicial: ");
                        double saldo = Double.parseDouble(teclado.nextLine().trim());

                        clientes.add(new Ejercicio7_Cliente(dni, nombre, fecha, saldo));
                        clientes.sort((a, b) -> a.getDni().compareTo(b.getDni()));
                        System.out.println("Cliente dado de alta.");
                    }
                }
                case 2 -> {
                    System.out.print("DNI del cliente a eliminar: ");
                    String dni = teclado.nextLine().trim().toUpperCase();
                    boolean eliminado = clientes.removeIf(c -> c.getDni().equals(dni));
                    System.out.println(eliminado ? "Cliente eliminado." : "No se encontró ese DNI.");
                }
                case 3 -> { 
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes.");
                    } else {
                        double max = clientes.get(0).getSaldo();
                        double min = clientes.get(0).getSaldo();
                        double suma = 0;

                        for (Ejercicio7_Cliente c : clientes) {
                            System.out.println(c.getDni() + " | " + c.getNombre()
                                    + " | " + c.getSaldo() + " € | " + c.getEdad() + " años");
                            if (c.getSaldo() > max) max = c.getSaldo();
                            if (c.getSaldo() < min) min = c.getSaldo();
                            suma += c.getSaldo();
                        }
                        System.out.println("Saldo máximo:   " + max);
                        System.out.println("Saldo mínimo:   " + min);
                        System.out.println("Saldo promedio: " + suma / clientes.size());
                    }
                }
                case 4 -> { // Guardar en archivosejerciciosboletin2 antes de salir
                    fileSalida.getParentFile().mkdirs();
                    try (BufferedWriter out = new BufferedWriter(new FileWriter(fileSalida))) {
                        for (Ejercicio7_Cliente c : clientes) {
                            out.write(c.toLinea());
                            out.newLine();
                        }
                    } catch (IOException e) {
                        System.out.println("Error al guardar.");
                    }
                    System.out.println("Datos guardados. ¡Hasta luego!");
                }
                default -> System.out.println("Opción no válida.");
            }
        }

        teclado.close();
    }
}