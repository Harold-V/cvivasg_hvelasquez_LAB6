package Vista;

import PaqueteTuristico.IPaqueteTuristico;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class Cotizar {

    private IPaqueteTuristico _paqueteTuristico;
    private int cantidadPersonas;
    private int dias;

    public Cotizar(IPaqueteTuristico _paqueteTuristico, int cantidadPersonas, int dias) {
        this._paqueteTuristico = _paqueteTuristico;
        this.cantidadPersonas = cantidadPersonas;
        this.dias = dias;
    }

    public double valorCotizacion() {
        double costoAdicionalPersonas = 0.0, costoAdicionalDias = 0.0;
        int diferenciaDias = dias - _paqueteTuristico.getDias();

        if (cantidadPersonas > 0) {
            costoAdicionalPersonas = (_paqueteTuristico.getPrecio() / 4) * cantidadPersonas;
        }

        if (diferenciaDias > 0) {
            costoAdicionalDias = (_paqueteTuristico.getPrecio() / _paqueteTuristico.getDias()) * diferenciaDias;
        }
        return costoAdicionalPersonas + costoAdicionalDias;
    }

}
