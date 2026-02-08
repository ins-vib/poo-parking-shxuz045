package org.yourcompany.Parking.places;

import java.util.Arrays;

import org.yourcompany.Parking.vehicles.Vehicle;

public abstract class PlacaAparcament {

    protected int numero;
    protected Vehicle vehicleAparcat;
    protected Coordenada[] coordenades;

    public PlacaAparcament(int numero, Coordenada[] coordenades) {
        this.numero = numero;
        this.coordenades = coordenades;
        this.vehicleAparcat = null;
    }

    public abstract boolean compatible(Vehicle vehicle);

    public void aparcar(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle incorrecte!");
        }
        if (!this.compatible(vehicle)) {
            throw new IllegalArgumentException("La plaça no és compatible");
        }
        if (this.isOcupada()) {
            throw new IllegalArgumentException("La plaça ja està ocupada");
        }
        this.vehicleAparcat = vehicle;
    }

    public boolean isOcupada() {
        return this.vehicleAparcat != null;
    }

    public boolean estaLliure() {
        return this.vehicleAparcat == null;
    }

    public void desAparcar() {
        this.vehicleAparcat = null;
    }

    public int getNumero() {
        return numero;
    }

    public Vehicle getVehicleAparcat() {
        return vehicleAparcat;
    }

    public Coordenada[] getCoordenades() {
        return coordenades;
    }

    @Override
    public String toString() {

        // String missatge = "PlacaAparcament [numero=" + numero + ", estat=";
        // if (getVehicleAparcat() != null){
        // missatge = missatge + "ocupat matricula: " + vehicleAparcat.getMatricula();
        // } else {
        // missatge = missatge + "lliure";
        // }
        // for(int i=0; i< coordenades.length; i++){
        // missatge = missatge + coordenades[i].toString();
        // }
        // return missatge;
        // }
        String resultat = "";

        resultat += "numero=" + numero + "Estat: ";
        if (!this.isOcupada()) {
            resultat += "Lliure ";
        } else {
            resultat += "Ocupada " + "matricula: "
                    + this.vehicleAparcat.getMatricula() + " ";
        }
        resultat += "coordenades="
                + Arrays.toString(coordenades);
        return resultat;
    }

}
