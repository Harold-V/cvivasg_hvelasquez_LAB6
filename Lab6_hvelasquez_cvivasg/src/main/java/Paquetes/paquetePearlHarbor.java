package Paquetes;

import PaqueteDecorador.PaqueteDecorador;
import PaqueteTuristico.IPaqueteTuristico;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class paquetePearlHarbor extends PaqueteDecorador {

    public paquetePearlHarbor(IPaqueteTuristico _paqueteDecorador) {
        super(_paqueteDecorador);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + 653.0;
    }

    @Override
    public int getDias() {
        return super.getDias() + 2;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "\n- Visita a Pearl Harbor.\n- Museo Iolani.\n- Museo Bishop y USS Arizona Memorial.";
    }
    
    @Override
    public String getNombre(){
        return super.getNombre() + ", Pearl Harbor";
    }

}
