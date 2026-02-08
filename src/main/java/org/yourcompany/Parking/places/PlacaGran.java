package org.yourcompany.Parking.places;

import org.yourcompany.Parking.vehicles.Vehicle;

public class PlacaGran extends PlacaAparcament {

    public PlacaGran(int numero, Coordenada[] coordenades) {
        super(numero, coordenades);
    }

    @Override
    public boolean compatible(Vehicle vehicle) {
        return true;
    }

}
