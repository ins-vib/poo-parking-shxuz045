package org.yourcompany.Parking;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.yourcompany.Parking.places.PlacaAparcament;
import org.yourcompany.Parking.places.PlacaRegular;
import org.yourcompany.Parking.vehicles.Vehicle;

public class PlacaTest {

    @Test
    public void test_aparcar_vehicle_null() {

        Vehicle v = null;
        PlacaAparcament plaça;
        plaça = new PlacaRegular(1, null);
        try {
            plaça.aparcar(v);
            fail("Hauria de fallar l'aparcament");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void test_aparcar_vehicle_() {
        
    }
}
