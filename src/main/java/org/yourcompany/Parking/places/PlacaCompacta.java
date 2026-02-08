package org.yourcompany.Parking.places;

import org.yourcompany.Parking.vehicles.MidaVehicle;
import org.yourcompany.Parking.vehicles.Vehicle;

public class PlacaCompacta extends PlacaAparcament {

    public PlacaCompacta(int numero, Coordenada[] coordenades) {
        super(numero, coordenades);
    }

    @Override
    public boolean compatible(Vehicle vehicle) {
        return vehicle.getMida() == MidaVehicle.PETIT;
    }

}
