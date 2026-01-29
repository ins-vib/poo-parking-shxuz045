package org.yourcompany.Parking.vehicles;

public class Motocicleta extends Vehicle {

    public Motocicleta(String matricula) {
        this.matricula = matricula;
        this.tipusVehicle = TipusVehicle.PETIT;

    }

    @Override
    public String toString() {
        return "Motocicleta []" + super.toString();
    }

}
