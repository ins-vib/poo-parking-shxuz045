package org.yourcompany.Parking.vehicles;

public class Camio extends Vehicle {

    public Camio(String matricula) {
        this.matricula = matricula;
        this.tipusVehicle = TipusVehicle.GRAN;

    }

    @Override
    public String toString() {
        return "Camio []" + super.toString();
    }

}
