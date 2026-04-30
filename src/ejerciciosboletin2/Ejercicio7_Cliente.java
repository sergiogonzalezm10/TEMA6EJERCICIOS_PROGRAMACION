package ejerciciosboletin2;

import java.time.LocalDate;
import java.time.Period;

public class Ejercicio7_Cliente {

    private String dni;
    private String nombre;
    private LocalDate fechaNacimiento;
    private double saldo;

    public Ejercicio7_Cliente(String dni, String nombre, LocalDate fechaNacimiento, double saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldo;
    }

    public String getDni()                { return dni; }
    public String getNombre()             { return nombre; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public double getSaldo()              { return saldo; }

    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String toLinea() {
        return dni + ";" + nombre + ";" + fechaNacimiento + ";" + saldo;
    }
}