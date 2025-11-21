
package er2_grupo02;

import java.util.ArrayList;

public class GestorCita {
    private ArrayList<Paciente> lista_pacientes;
    private ArrayList<Medico> lista_medicos;
    private ArrayList<Cita> lista_citas;
    
    private static final double costo_defecto = 30000;

    public GestorCita() {
        this.lista_pacientes = new ArrayList<>();
        this.lista_medicos = new ArrayList<>();
        this.lista_citas = new ArrayList<>();
    }

    public ArrayList<Paciente> getLista_pacientes() {
        return lista_pacientes;
    }

    public void setLista_pacientes(ArrayList<Paciente> lista_pacientes) {
        this.lista_pacientes = lista_pacientes;
    }

    public ArrayList<Medico> getLista_medicos() {
        return lista_medicos;
    }

    public void setLista_medicos(ArrayList<Medico> lista_medicos) {
        this.lista_medicos = lista_medicos;
    }

    public ArrayList<Cita> getLista_citas() {
        return lista_citas;
    }

    public void setLista_citas(ArrayList<Cita> lista_citas) {
        this.lista_citas = lista_citas;
    }
    
    public Paciente busca_paciente(String id) {
        for (Paciente p : this.lista_pacientes) {
            if (p.getId().equals(id)) {
                return p; 
            }
        }
        return null;
    }
    
    public Medico busca_medico(String nombre) {
        for (Medico m : this.lista_medicos) {
            if (m.getNombre().equals(nombre)) {
                return m; 
            }
        }
        return null;
    }
    
    public void registrar_paciente(String id, String email, String nombre, int edad) {
        Paciente nuevoPaciente =  new Paciente(id, email, nombre, edad);
        this.lista_pacientes.add(nuevoPaciente);
        System.out.println("Paciente " + nombre + " registrado");
    }
    
    public void registrar_medico(String especialidad, String nombre, int edad) {
        Medico nuevoMedico;
        if (especialidad.equalsIgnoreCase("Pediatria")) {
        nuevoMedico = new Pediatra(nombre, edad);
    } else if (especialidad.equalsIgnoreCase("Cardiologia")) { 
        nuevoMedico = new Cardiologo(nombre, edad);
    } else { 
        nuevoMedico = new MedicoGeneral(nombre, edad);
    }
        this.lista_medicos.add(nuevoMedico);
        System.out.println("Dr. "+ nombre + " ("+ nuevoMedico.getEspecialidad() +") "+ "registrado");
        
    }
    
    public void registrar_cita(Paciente p, Medico m, double costo_base, String fecha) {
        Cita nuevaCita = new Cita(p, m, m.getEspecialidad(), costo_base, fecha);
        this.lista_citas.add(nuevaCita);
        m.registrar_cita(nuevaCita);    
        p.agregar_cita(nuevaCita);
        System.out.println("Cita registrada para " + p.getNombre() + " con Dr. " + m.getNombre());
    }
    public void registrar_cita(Paciente p, Medico m, String fecha) {
        System.out.println("Costo sin especificar, uso valor por defecto: $" + costo_defecto);
        this.registrar_cita(p, m, costo_defecto, fecha);
    }
    
    public void mostrarEstadisticasPorMedico() {
        System.out.println("\nREPORTE DE HONORARIOS Y CITAS POR MEDICO");
        for (Medico medicoActual : this.lista_medicos) {
            int totalCitas = medicoActual.total_citas(); 
            double honorarioAcumulado = medicoActual.calcular_honorarioTotal();
            System.out.println("Medico: " + medicoActual.getNombre());
            System.out.println("Especialidad: " + medicoActual.getEspecialidad());
            System.out.println("Citas Atendidas: " + totalCitas);
            System.out.println("Honorarios Generados: $" + honorarioAcumulado);
        }
    }
}
    
