package Paquetes;

import PaqueteDecorador.PaqueteDecorador;
import PaqueteTuristico.IPaqueteTuristico;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class paqueteNature extends PaqueteDecorador {
    
    public paqueteNature(IPaqueteTuristico _paqueteDecorador) {
        super(_paqueteDecorador);
    }
    
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "\n- Visita a Kualoa Ranch.\n- Visita a Maui Ocean Center y Akaka Falls State Park.";
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + 720.0;
    }

    @Override
    public int getDias() {
        return super.getDias() + 5;
    }
    
    @Override
    public String getNombre(){
        return super.getNombre() + ", Nature";
    }
    
}
