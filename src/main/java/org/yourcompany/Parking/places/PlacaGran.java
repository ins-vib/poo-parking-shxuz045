package org.yourcompany.Parking.places;

import org.yourcompany.Parking.vehicles.Vehicle;

public class PlacaGran extends PlacaAparcament {

    public PlacaGran(int numero, Coordenada[] coordenadas) {
        super(numero, coordenadas);
    }

    @Override
    public boolean compatible(Vehicle vehicle) {
        return true;

    }

    

}
