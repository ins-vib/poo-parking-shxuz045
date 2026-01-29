package org.yourcompany.Parking.places;

import org.yourcompany.Parking.vehicles.TipusVehicle;
import org.yourcompany.Parking.vehicles.Vehicle;

public class PlacaComptacte extends PlacaAparcament {

    public PlacaComptacte(int numero, Coordenada[] coordenadas) {
        super(numero, coordenadas);
    }

    @Override
    public boolean compatible(Vehicle vehicle) {
        if (vehicle.getTipusVehicle() == TipusVehicle.PETIT) {
            return true;
        }
        return false;
    }
    
}
