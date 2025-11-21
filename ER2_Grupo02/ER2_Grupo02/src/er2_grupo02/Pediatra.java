
package er2_grupo02;

public final class Pediatra extends Medico {

    public Pediatra() {
    }

    public Pediatra( String nombre, int edad) {
        super("Pediatra", nombre, edad);
    }

    @Override
    public double calcular_honorarioBase(double costo) {
        return costo * 0.12;
    }   
    

}
