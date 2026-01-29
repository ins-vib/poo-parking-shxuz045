package org.yourcompany.Parking.places;

import org.yourcompany.Parking.vehicles.TipusVehicle;
import org.yourcompany.Parking.vehicles.Vehicle;

public class PlacaRegular extends PlacaAparcament {

    public PlacaRegular(int numero, Coordenada[] coordenadas) {
        super(numero, coordenadas);
    }

    @Override
    public boolean compatible(Vehicle vehicle) {
        if (vehicle.getTipusVehicle() == TipusVehicle.PETIT || vehicle.getTipusVehicle() == TipusVehicle.MITJA) {
            return true;
        }
        return false;
    }
    
}
