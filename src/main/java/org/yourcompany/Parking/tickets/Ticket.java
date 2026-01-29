package org.yourcompany.Parking.tickets;

import java.time.LocalDateTime;

import org.yourcompany.Parking.places.PlacaAparcament;
import org.yourcompany.Parking.vehicles.Vehicle;

public class Ticket {

    private int numero;
    private Vehicle vehicle;
    private PlacaAparcament plaça;
    private LocalDateTime entrada;
    private LocalDateTime sortida;

    static private int comptador = 1;

    public Ticket(Vehicle vehicle, PlacaAparcament plaça) {
        numero = comptador;
        entrada = LocalDateTime.now();
        comptador++;
        this.plaça = plaça;
        this.vehicle = vehicle;
    }

    public int getNumero() {
        return numero;

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public PlacaAparcament getPlaça() {
        return plaça;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSortida() {
        return sortida;
    }

    public void setSortida(LocalDateTime sortida) {
        this.sortida = sortida;
    }

}
