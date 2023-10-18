package PaqueteDecorador;

import PaqueteTuristico.IPaqueteTuristico;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public abstract class PaqueteDecorador implements IPaqueteTuristico {

    protected IPaqueteTuristico _paqueteDecorador;

    public PaqueteDecorador(IPaqueteTuristico _paqueteDecorador) {
        this._paqueteDecorador = _paqueteDecorador;
    }

    @Override
    public int getDias() {
        return _paqueteDecorador.getDias();
    }

    @Override
    public double getPrecio() {
        return _paqueteDecorador.getPrecio();
    }

    @Override
    public String getDescripcion() {
        return _paqueteDecorador.getDescripcion();
    }
    
    @Override
    public String getNombre() {
        return _paqueteDecorador.getNombre();
    }
}
