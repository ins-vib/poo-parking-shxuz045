package org.yourcompany.Parking.vehicles;

public class Cotxe extends Vehicle {

    public Cotxe(String matricula) {
        this.matricula = matricula;
        this.tipusVehicle = TipusVehicle.MITJA;

    }

    @Override
    public String toString() {
        return "Cotxe []" + super.toString();
    }

}
