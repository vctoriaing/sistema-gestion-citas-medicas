
package er2_grupo02;


public class Cita {
    private Paciente paciente;
    private Medico medico;
    private String especialidad;
    private double costo_base;
    private String fecha;

    public Cita() {
    }

    public Cita(Paciente paciente, Medico medico, String especialidad, double costo_base, String fecha) {
        this.paciente = paciente;
        this.medico = medico;
        this.especialidad = especialidad;
        this.costo_base = costo_base;
        this.fecha  = fecha; 
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getCosto_base() {
        return costo_base;
    }

    public void setCosto_base(double costo_base) {
        this.costo_base = costo_base;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void mostrar_datos() {
        System.out.println("\nDATOS PACIENTE");
        System.out.println("Fecha: " + this.fecha);
        System.out.println("Paciente: " + this.paciente.getNombre());
        System.out.println("Medico: " + this.medico.getNombre());
        System.out.println("Especialidad: " + this.especialidad);
        System.out.println("Costo Base: $" + this.costo_base);
    }
    
}
