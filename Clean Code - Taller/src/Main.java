/**
 * Clase principal con menú interactivo para gestionar empleados.
 */
public class Main {
    public static void main(String[] args) {
        AdministradorDeEmpleados administrador = new AdministradorDeEmpleados();
        java.util.Scanner entradaUsuario = new java.util.Scanner(System.in);
        int opcionSeleccionada;

        do {
            imprimirMenu();
            opcionSeleccionada = entradaUsuario.nextInt();
            entradaUsuario.nextLine();

            switch (opcionSeleccionada) {
                case 1:
                    registrarNuevoEmpleado(administrador, entradaUsuario);
                    break;
                case 2:
                    administrador.calcularSalariosMensuales();
                    break;
                case 3:
                    administrador.mostrarTodosLosEmpleados();
                    break;
                case 4:
                    System.out.println("\nGracias por usar el sistema.");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente nuevamente.");
            }
        } while (opcionSeleccionada != 4);

        entradaUsuario.close();
    }

    private static void imprimirMenu() {
        System.out.println("\nSISTEMA DE GESTIÓN DE EMPLEADOS");
        System.out.println("================================");
        System.out.println("1. Agregar nuevo empleado");
        System.out.println("2. Calcular salarios mensuales");
        System.out.println("3. Mostrar información de empleados");
        System.out.println("4. Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    private static void registrarNuevoEmpleado(AdministradorDeEmpleados administrador, java.util.Scanner entradaUsuario) {
        System.out.println("\nRegistro de Nuevo Empleado");
        System.out.println("--------------------------");

        System.out.print("Nombre: ");
        String nombreEmpleado = entradaUsuario.nextLine();

        System.out.print("Edad: ");
        int edadEmpleado = entradaUsuario.nextInt();

        System.out.print("Salario base mensual: $");
        double salarioBaseMensual = entradaUsuario.nextDouble();

        Empleado nuevoEmpleado = new Empleado(nombreEmpleado, edadEmpleado, salarioBaseMensual);

        System.out.print("¿Tiene bonificaciones? (s/n): ");
        entradaUsuario.nextLine();
        String tieneBonificaciones = entradaUsuario.nextLine();

        if (tieneBonificaciones.equalsIgnoreCase("s")) {
            System.out.print("Monto de bonificaciones: $");
            double montoBonificacion = entradaUsuario.nextDouble();
            nuevoEmpleado.agregarBonificacion(montoBonificacion);
            entradaUsuario.nextLine();
        }

        System.out.print("¿Tiene deducciones? (s/n): ");
        String tieneDeducciones = entradaUsuario.nextLine();

        if (tieneDeducciones.equalsIgnoreCase("s")) {
            System.out.print("Monto de deducciones: $");
            double montoDeduccion = entradaUsuario.nextDouble();
            nuevoEmpleado.agregarDeduccion(montoDeduccion);
            entradaUsuario.nextLine();
        }

        administrador.agregarEmpleado(nuevoEmpleado);
    }
}