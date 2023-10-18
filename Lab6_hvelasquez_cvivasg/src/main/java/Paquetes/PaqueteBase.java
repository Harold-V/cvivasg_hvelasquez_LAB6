package Paquetes;

import PaqueteTuristico.IPaqueteTuristico;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class PaqueteBase implements IPaqueteTuristico {
    
    public PaqueteBase(){
        
    }

    @Override
    public int getDias() {
        return 5;
    }

    @Override
    public double getPrecio() {
        return 7000.0;
    }

    @Override
    public String getDescripcion() {
        return "consta de: \n- Tiquetes aéreos.\n- Hotel en habitación estándar.\n- Alimentación.\n- Vuelta a la isla.\n- Recepción con lei hawaiano y camiseta de Millonarios.";
    }

    @Override
    public String getNombre() {
        return "Paquete Base";
    }

}
