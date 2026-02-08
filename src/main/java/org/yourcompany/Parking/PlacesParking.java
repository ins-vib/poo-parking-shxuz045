package org.yourcompany.Parking;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.yourcompany.Parking.places.PlacaAparcament;
import org.yourcompany.Parking.tickets.Ticket;
import org.yourcompany.Parking.vehicles.Vehicle;

public class PlacesParking {

    public static final double PREU_MINUT = 2.0;

    protected ArrayList<PlacaAparcament> places;
    private ArrayList<Ticket> tickets;

    public PlacesParking(ArrayList<PlacaAparcament> places, ArrayList<Ticket> tickets) {
        this.places = places;
        this.tickets = tickets;
    }

    public PlacesParking(ArrayList<PlacaAparcament> places) {
        this.places = places;
        this.tickets = new ArrayList<>();
    }

    // buscar ticket per numero
    public Ticket getTickets(int numero) {
        for (int i = 0; i < tickets.size(); i++) {
            Ticket t = tickets.get(i);
            if (t.getNumero() == numero) {
                return t;
            }
        }
        return null;
    }

    public void mostrarEstat() {
        for (int i = 0; i < places.size(); i++) {
            System.out.println(places.get(i).toString());
        }
    }

    public Ticket aparcar(Vehicle vehicle) {
        for (int i = 0; i < places.size(); i++) {
            PlacaAparcament plaça = places.get(i);
            if (plaça.estaLliure() && plaça.compatible(vehicle)) {
                plaça.aparcar(vehicle);
                Ticket ticket = new Ticket(vehicle, plaça);
                tickets.add(ticket);
                return ticket;
            }
        }
        return null;
    }

    public boolean desAparcar(Vehicle vehicle) {
        for (int i = 0; i < places.size(); i++) {
            PlacaAparcament plaça = places.get(i);
            if (plaça.isOcupada()) {
                if (plaça.getVehicleAparcat().getMatricula().equals(vehicle.getMatricula())) {
                    plaça.desAparcar();
                    return true;
                }
            }
        }
        return false;
    }

    public double desaparcar(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket no vàlid");
        }
        if (!tickets.contains(ticket)) {
            throw new IllegalArgumentException("Ticket no vàlid");
        }

        ticket.setSortida(LocalDateTime.now());
        long minuts = ticket.calcularMinutsEstada();
        double preu = minuts * PREU_MINUT;

        ticket.getPlaça().desAparcar();
        tickets.remove(ticket);

        return preu;
    }

}
