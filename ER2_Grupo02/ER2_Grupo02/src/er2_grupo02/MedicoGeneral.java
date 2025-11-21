
package er2_grupo02;

public final class MedicoGeneral extends Medico {

    public MedicoGeneral() {
    }

    public MedicoGeneral(String nombre, int edad) {
        super("Medicina General", nombre, edad);
    }
    
    @Override
    public double calcular_honorarioBase(double costo) {
        return costo * 0.10;
    }   
    
}
