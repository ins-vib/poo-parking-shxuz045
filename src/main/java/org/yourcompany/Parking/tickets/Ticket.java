package org.yourcompany.Parking.tickets;

import java.time.LocalDateTime;
import java.time.Duration;

import org.yourcompany.Parking.places.PlacaAparcament;
import org.yourcompany.Parking.vehicles.Vehicle;

public class Ticket {

    private static int comptador = 1;

    private int numero;
    private Vehicle vehicle;
    private PlacaAparcament placa;
    private LocalDateTime entrada;
    private LocalDateTime sortida;

    public Ticket(Vehicle vehicle, PlacaAparcament placa) {
        this.numero = comptador;
        comptador++;
        this.vehicle = vehicle;
        this.placa = placa;
        this.entrada = LocalDateTime.now();
        this.sortida = null;
    }

    public int getNumero() {
        return numero;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public PlacaAparcament getPlaça() {
        return placa;
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

    // metode per calcular els minuts
    public long calcularMinutsEstada() {
        if (sortida == null) {
            Duration duracio = Duration.between(entrada, LocalDateTime.now());
            return duracio.toMinutes();
        } else {
            Duration duracio = Duration.between(entrada, sortida);
            return duracio.toMinutes();
        }
    }

}
