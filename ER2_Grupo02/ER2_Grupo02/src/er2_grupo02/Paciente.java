
package er2_grupo02;

import java.util.ArrayList;

public class Paciente extends Persona {
    private String id;
    private String email;
    private ArrayList<Cita> historial_cita;

    public Paciente() {
    }

    public Paciente(String id, String email, String nombre, int edad) {
        super(nombre, edad);
        this.id = id;
        this.email = email;
        this.historial_cita = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Cita> getHistorial_cita() {
        return historial_cita;
    }

    public void setHistorial_cita(ArrayList<Cita> historial_cita) {
        this.historial_cita = historial_cita;
    }
    
    public void agregar_cita(Cita cita) {
        this.historial_cita.add(cita);
    }
    
    @Override
    public void mostrar_datos() {
        System.out.println("\nDATOS PACIENTE");
        super.mostrar_datos();
        System.out.println("ID: " + this.id);
        System.out.println("Email: " + this.email);
        System.out.println("Citas agendadas: " + this.historial_cita.size());
        
    }
    
}
