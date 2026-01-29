package org.yourcompany.Parking;

import java.util.ArrayList;

import org.yourcompany.Parking.places.PlacaAparcament;
import org.yourcompany.Parking.tickets.Ticket;
import org.yourcompany.Parking.vehicles.Vehicle;

public class PlacesParking {

    protected ArrayList<PlacaAparcament> places;
    private ArrayList<Ticket> tickets;

    public PlacesParking(ArrayList<PlacaAparcament> places) {
        this.places = places;
    }

    public void mostrarEstat() {
        for (PlacaAparcament plaça : places) {
            System.out.println(plaça);
        }
    }

    public boolean aparcar(Vehicle vehicle) {
        for (PlacaAparcament plaça : places) {
            if (plaça.compatible(vehicle) && !plaça.isOcupada()) {
                plaça.aparcar(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean desAparcar(Vehicle vehicle) {
        for (PlacaAparcament plaça : places) {
            if (plaça.isOcupada() && plaça.getVehicleAparcat().getMatricula().equals(vehicle.getMatricula())) {
                plaça.desAparcar();
                return true;
            }
        }
        return false;
    }

}
