package org.yourcompany.Parking.vehicles;

import java.util.Objects;

public abstract class Vehicle {

    protected String matricula;
    protected MidaVehicle mida;

    public String getMatricula() {
        return this.matricula;
    }

    public MidaVehicle getMida() {
        return this.mida;
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
