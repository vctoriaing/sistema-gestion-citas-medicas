
package er2_grupo02;

public final class Cardiologo extends Medico {

    public Cardiologo() {
    }

    public Cardiologo( String nombre, int edad) {
        super("Cardiologo", nombre, edad);
    }
      
    @Override
    public double calcular_honorarioBase(double costo) {
        return costo * 0.15;
    }   
    
}

