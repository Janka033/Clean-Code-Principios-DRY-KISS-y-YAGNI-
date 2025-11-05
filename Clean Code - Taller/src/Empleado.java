
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un empleado con información básica y cálculo de salario.
 */
class Empleado {
    private String nombre;
    private int edad;
    private double salarioBaseMensual;
    private double bonificaciones;
    private double deducciones;

    public Empleado(String nombre, int edad, double salarioBaseMensual) {
        this.nombre = nombre;
        this.edad = edad;
        this.salarioBaseMensual = salarioBaseMensual;
        this.bonificaciones = 0;
        this.deducciones = 0;
    }

    public void agregarBonificacion(double monto) {
        this.bonificaciones += monto;
    }

    public void agregarDeduccion(double monto) {
        this.deducciones += monto;
    }

    public double calcularSalarioMensual() {
        return salarioBaseMensual + bonificaciones - deducciones;
    }

    public void mostrarInformacion() {
        double salarioMensual = calcularSalarioMensual();
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Salario base: $" + String.format("%,.2f", salarioBaseMensual));
        System.out.println("Bonificaciones: $" + String.format("%,.2f", bonificaciones));
        System.out.println("Deducciones: $" + String.format("%,.2f", deducciones));
        System.out.println("Salario mensual total: $" + String.format("%,.2f", salarioMensual));
        System.out.println("--------------------------------------------------");
    }

    public String getNombre() {
        return nombre;
    }
}
