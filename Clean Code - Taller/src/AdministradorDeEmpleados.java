import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona la colección de empleados y sus operaciones.
 */
class AdministradorDeEmpleados {
    private List<Empleado> empleados;

    public AdministradorDeEmpleados() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado " + empleado.getNombre() + " agregado exitosamente.");
    }

    public void calcularSalariosMensuales() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados en el sistema.");
            return;
        }

        System.out.println("\n=== SALARIOS MENSUALES ===");
        double totalSalarios = 0;

        for (Empleado empleado : empleados) {
            double salario = empleado.calcularSalarioMensual();
            totalSalarios += salario;
            System.out.println(empleado.getNombre() + ": $" + String.format("%,.2f", salario));
        }

        System.out.println("\nTotal en salarios: $" + String.format("%,.2f", totalSalarios));
        System.out.println("==================================================");
    }

    public void mostrarTodosLosEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados en el sistema.");
            return;
        }

        System.out.println("\n=== INFORMACIÓN DE EMPLEADOS ===");
        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();
        }
    }
}