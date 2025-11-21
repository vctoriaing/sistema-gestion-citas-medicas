
package er2_grupo02;

import java.util.Scanner;

public class ER2_Grupo02 {

    private static final GestorCita gestor = new GestorCita();
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;
        String id, email, nombre, especialidad, fecha, idPaciente, nombreMedico;
        int edad;
        char opcionCosto;
        double costo;
        Paciente paciente;
        Medico medico;    

        System.out.println("ER2_Grupo02");
        System.out.println("Integrantes:");
        System.out.println("Victoria Rojas Rut: 27942251-1");

        while (opcion != 5) {

            mostrar_menu();
            System.out.print("Ingrese su opcion: ");
            if (leer.hasNextInt()) {
                opcion = leer.nextInt();
                leer.nextLine();
            } else {
                System.out.println("ADVERTENCIA: Ingrese solo numeros.");
                leer.nextLine();
                opcion = 0;     
            }
            switch (opcion) {
                case 1: {
                    System.out.println("\nREGISTRO DE PACIENTE");
                    System.out.print("Ingrese ID (Rut) del paciente: ");
                    id = leer.nextLine();
                    if (gestor.busca_paciente(id) != null) {
                        System.out.println("Error!!!: El paciente con ID " + id + " ya esta registrado.");
                        break;
                    }
                    System.out.print("Ingrese Email: ");
                    email = leer.nextLine();
                    System.out.print("Ingrese Nombre completo: ");
                    nombre = leer.nextLine();
                    System.out.print("Ingrese Edad: ");
                    if (leer.hasNextInt()){
                        edad = leer.nextInt();
                        leer.nextLine();
                    } else {
                        System.out.println("Error!!!: Edad invalida!!!");
                        leer.nextLine(); 
                        break;
                    }
                    gestor.registrar_paciente(id, email, nombre, edad);
                    break;
                }

                case 2: {
                    System.out.println("\nREGISTRO DE MEDICO");
                    System.out.print("Ingrese Nombre del medico: ");
                    nombre = leer.nextLine();

                    if (gestor.busca_medico(nombre) != null) {
                        System.out.println("Error!!!: Ya existe un medico con ese nombre.");
                        break;
                    }

                    System.out.print("Ingrese Edad: ");
                    if (leer.hasNextInt()){
                        edad = leer.nextInt();
                        leer.nextLine();
                    } else {
                        System.out.println("Error!!!: Edad invalida.");
                        leer.nextLine();
                        break;
                    }

                    System.out.print("Ingrese Especialidad (Medicina General, Pediatria, Cardiologia): ");
                    especialidad = leer.nextLine();
                    gestor.registrar_medico(especialidad, nombre, edad);
                    break;
                }
                case 3: {
                    System.out.println("\nREGISTRO DE CITA MEDICA");

                    System.out.print("ID del Paciente: ");
                    idPaciente = leer.nextLine();
                    paciente = gestor.busca_paciente(idPaciente);
                    if (paciente == null) {
                        System.out.println("Error!!!: Paciente no encontrado.");
                        break;
                    }

                    System.out.print("Nombre del Medico: ");
                    nombreMedico = leer.nextLine();
                    medico = gestor.busca_medico(nombreMedico);
                    if (medico == null) {
                        System.out.println("Error!!!: Medico no encontrado.");
                        break;
                    }

                    System.out.print("Ingrese Fecha de la cita (ej. 20251026): ");
                    fecha = leer.nextLine();

                    System.out.print("Desea ingresar el Costo Base de la atencion? (S/N): ");
                    String respCosto = leer.nextLine();
                    if (respCosto.isEmpty()){
                        opcionCosto = 'N';
                    } else {
                        opcionCosto = respCosto.toUpperCase().charAt(0);
                    }

                    if (opcionCosto == 'S') {
                        System.out.print("Ingrese Costo Base: $");
                        if (leer.hasNextDouble()){
                           costo = leer.nextDouble();
                           leer.nextLine();
                           gestor.registrar_cita(paciente, medico, costo, fecha);
                        } else {
                           System.out.println("Error!!!: Costo invalido.");
                           leer.nextLine(); 
                           break;
                        }
                    } else {
                        gestor.registrar_cita(paciente, medico, fecha);
                    }
                    break; 
                }
                case 4: {
                    gestor.mostrarEstadisticasPorMedico();
                    break;
                }
                case 5: {
                    System.out.println("Finalizando programa");
                    break;
                }
                default: {
                    if (opcion != 0) { 
                       System.out.println("Opcion invalida!!!. Intente de nuevo.");
                    }
                }
            } 
        }

        System.out.println("\nPrograma Terminado.");
        leer.close();
    }
    public static void mostrar_menu() {
        System.out.println("\n--- Sistema de Gestion de Pacientes y Citas en un Hospital ---");
        System.out.println("1. Registrar un paciente.");
        System.out.println("2. Registrar un medico y su especialidad.");
        System.out.println("3. Registrar una cita medica.");
        System.out.println("4. Mostrar estadisticas por medico.");
        System.out.println("5. Finalizar programa.");

    }
}