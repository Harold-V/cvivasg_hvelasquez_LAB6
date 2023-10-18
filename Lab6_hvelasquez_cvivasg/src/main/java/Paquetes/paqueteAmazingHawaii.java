package Paquetes;

import PaqueteDecorador.PaqueteDecorador;
import PaqueteTuristico.IPaqueteTuristico;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class paqueteAmazingHawaii extends PaqueteDecorador {

    public paqueteAmazingHawaii(IPaqueteTuristico _paqueteDecorador) {
        super(_paqueteDecorador);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "\n- Escalada en Waipio Valley.\n- Surf en playas Waikiki o Hanalei Bay.\n- Buceo en Hanauma Bay.";
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + 931.0;
    }

    @Override
    public int getDias() {
        return super.getDias() + 3;
    }
    
    @Override
    public String getNombre(){
        return super.getNombre() + ", Amazing Hawaii";
    }
}
