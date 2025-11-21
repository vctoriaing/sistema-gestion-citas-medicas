
package er2_grupo02;

import java.util.ArrayList;


public abstract class Medico extends Persona implements Pegable {
    private String especialidad;
    private ArrayList<Cita> citas_atendidas;

    public Medico() {
    }

    public Medico(String especialidad, String nombre, int edad) {
        super(nombre, edad);
        this.especialidad = especialidad;
        this.citas_atendidas = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Cita> getCitas_atendidas() {
        return citas_atendidas;
    }

    public void setCitas_atendidas(ArrayList<Cita> citas_atendidas) {
        this.citas_atendidas = citas_atendidas;
    }
    
    public void registrar_cita(Cita cita) {
        this.citas_atendidas.add(cita);
    }
    
    public int total_citas() {
        return this.citas_atendidas.size();
    }
    
    public abstract double calcular_honorarioBase(double costo);

    
    @Override
    public double calcular_honorarioTotal() {
        double honorariosTotales = 0; 
        ArrayList<String> fechasProcesadas = new ArrayList<>();

        for (Cita citaActual : this.citas_atendidas) {
            String fecha_cita = citaActual.getFecha(); 
            if (fechasProcesadas.contains(fecha_cita)) {
                continue; 
            }

            ArrayList<Cita> citasDeEsteDia = new ArrayList<>();
            for (Cita cita_interna : this.citas_atendidas) {
                if (cita_interna.getFecha().equals(fecha_cita)) {
                    citasDeEsteDia.add(cita_interna);
                }
            }
            double subtotal_dia = 0;
            for (Cita cita_dia : citasDeEsteDia) {
                subtotal_dia += this.calcular_honorarioBase(cita_dia.getCosto_base());
            }
            if (citasDeEsteDia.size() > 10) {
                subtotal_dia *= 1.05; 
            }
            honorariosTotales += subtotal_dia;
            fechasProcesadas.add(fecha_cita); 
        }  
        return honorariosTotales;
    }
    
    @Override
    public void mostrar_datos() {
        super.mostrar_datos();
        System.out.println("Especialidad: " + this.especialidad);
        System.out.println("Citas Atendidas: " + this.total_citas());
    }
}


