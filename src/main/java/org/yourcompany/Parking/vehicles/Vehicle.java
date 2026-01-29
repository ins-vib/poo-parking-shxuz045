package org.yourcompany.Parking.vehicles;

import java.util.Objects;

public abstract class Vehicle {

    protected String matricula;
    protected TipusVehicle tipusVehicle;

    public String getMatricula() {
        return matricula;
    }

    public TipusVehicle getTipusVehicle() {
        return tipusVehicle;
    }

    @Override
    public String toString() {
        return "Vehicle [matricula=" + matricula + ", tipusVehicle=" + tipusVehicle + ", toString()=" + super.toString()
                + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        return Objects.equals(this.matricula, other.matricula);
    }

}
