package org.yourcompany.Parking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.yourcompany.Parking.places.Coordenada;
import org.yourcompany.Parking.places.PlacaAparcament;
import org.yourcompany.Parking.places.PlacaCompacta;
import org.yourcompany.Parking.places.PlacaGran;
import org.yourcompany.Parking.places.PlacaRegular;
import org.yourcompany.Parking.vehicles.Camio;
import org.yourcompany.Parking.vehicles.Cotxe;
import org.yourcompany.Parking.vehicles.Motocicleta;
import org.yourcompany.Parking.vehicles.Vehicle;

public class PlacaTest {

    @Test
    public void T1_aparcar_vehicle_compatible() {
        Coordenada[] coords = new Coordenada[4];
        coords[0] = new Coordenada(0, 0);
        coords[1] = new Coordenada(2, 0);
        coords[2] = new Coordenada(2, 1);
        coords[3] = new Coordenada(0, 1);

        PlacaAparcament plaça = new PlacaRegular(1, coords);
        Vehicle cotxe = new Cotxe("1234-ABC");

        plaça.aparcar(cotxe);

        assertTrue(plaça.isOcupada());
        assertEquals(cotxe, plaça.getVehicleAparcat());
    }

    @Test
    public void T2_aparcar_vehicle_null() {
        Coordenada[] coords = new Coordenada[4];
        coords[0] = new Coordenada(0, 0);
        coords[1] = new Coordenada(2, 0);
        coords[2] = new Coordenada(2, 1);
        coords[3] = new Coordenada(0, 1);

        PlacaAparcament plaça = new PlacaRegular(1, coords);

        try {
            plaça.aparcar(null);
            fail("Hauria de llançar excepció");
        } catch (IllegalArgumentException e) {
            assertEquals("Vehicle incorrecte!", e.getMessage());
        }
    }

    @Test
    public void T3_aparcar_vehicle_no_compatible() {
        Coordenada[] coords = new Coordenada[4];
        coords[0] = new Coordenada(0, 0);
        coords[1] = new Coordenada(2, 0);
        coords[2] = new Coordenada(2, 1);
        coords[3] = new Coordenada(0, 1);

        PlacaAparcament plaça = new PlacaCompacta(1, coords);
        Vehicle camio = new Camio("5678-XYZ");

        try {
            plaça.aparcar(camio);
            fail("Hauria de llançar excepció");
        } catch (IllegalArgumentException e) {
            assertEquals("La plaça no és compatible", e.getMessage());
        }
    }

    @Test
    public void T4_aparcar_placa_ocupada() {
        Coordenada[] coords = new Coordenada[4];
        coords[0] = new Coordenada(0, 0);
        coords[1] = new Coordenada(2, 0);
        coords[2] = new Coordenada(2, 1);
        coords[3] = new Coordenada(0, 1);

        PlacaAparcament plaça = new PlacaRegular(1, coords);
        Vehicle cotxe1 = new Cotxe("1111-AAA");
        Vehicle cotxe2 = new Cotxe("2222-BBB");

        plaça.aparcar(cotxe1);

        try {
            plaça.aparcar(cotxe2);
            fail("Hauria de llançar excepció");
        } catch (IllegalArgumentException e) {
            assertEquals("La plaça ja està ocupada", e.getMessage());
        }
    }

    @Test
    public void T5_desaparcar_i_aparcar() {
        Coordenada[] coords = new Coordenada[4];
        coords[0] = new Coordenada(0, 0);
        coords[1] = new Coordenada(2, 0);
        coords[2] = new Coordenada(2, 1);
        coords[3] = new Coordenada(0, 1);

        PlacaAparcament plaça = new PlacaRegular(1, coords);
        Vehicle cotxe1 = new Cotxe("1111-AAA");
        Vehicle cotxe2 = new Cotxe("2222-BBB");

        plaça.aparcar(cotxe1);
        plaça.desAparcar();
        plaça.aparcar(cotxe2);

        assertTrue(plaça.isOcupada());
        assertEquals(cotxe2, plaça.getVehicleAparcat());
    }

    @Test
    public void T6_aparcar_mateix_vehicle_dos_cops() {
        Coordenada[] coords = new Coordenada[4];
        coords[0] = new Coordenada(0, 0);
        coords[1] = new Coordenada(2, 0);
        coords[2] = new Coordenada(2, 1);
        coords[3] = new Coordenada(0, 1);

        PlacaAparcament plaça = new PlacaRegular(1, coords);
        Vehicle cotxe = new Cotxe("1111-AAA");

        plaça.aparcar(cotxe);

        try {
            plaça.aparcar(cotxe);
            fail("Hauria de llançar excepció");
        } catch (IllegalArgumentException e) {
            assertEquals("La plaça ja està ocupada", e.getMessage());
        }
    }

    @Test
    public void T7_moto_placa_regular() {
        Coordenada[] coords = new Coordenada[4];
        coords[0] = new Coordenada(0, 0);
        coords[1] = new Coordenada(2, 0);
        coords[2] = new Coordenada(2, 1);
        coords[3] = new Coordenada(0, 1);

        PlacaAparcament plaça = new PlacaRegular(1, coords);
        Vehicle moto = new Motocicleta("9999-XYZ");

        plaça.aparcar(moto);

        assertTrue(plaça.isOcupada());
    }

    @Test
    public void T8_moto_placa_compacta() {
        Coordenada[] coords = new Coordenada[4];
        coords[0] = new Coordenada(0, 0);
        coords[1] = new Coordenada(2, 0);
        coords[2] = new Coordenada(2, 1);
        coords[3] = new Coordenada(0, 1);

        PlacaAparcament plaça = new PlacaCompacta(1, coords);
        Vehicle moto = new Motocicleta("9999-XYZ");

        plaça.aparcar(moto);

        assertTrue(plaça.isOcupada());
    }

    @Test
    public void T9_camio_placa_gran() {
        Coordenada[] coords = new Coordenada[4];
        coords[0] = new Coordenada(0, 0);
        coords[1] = new Coordenada(2, 0);
        coords[2] = new Coordenada(2, 1);
        coords[3] = new Coordenada(0, 1);

        PlacaAparcament plaça = new PlacaGran(1, coords);
        Vehicle camio = new Camio("7777-CCC");

        plaça.aparcar(camio);

        assertTrue(plaça.isOcupada());
    }

    @Test
    public void T10_camio_placa_compacta() {
        Coordenada[] coords = new Coordenada[4];
        coords[0] = new Coordenada(0, 0);
        coords[1] = new Coordenada(2, 0);
        coords[2] = new Coordenada(2, 1);
        coords[3] = new Coordenada(0, 1);

        PlacaAparcament plaça = new PlacaCompacta(1, coords);
        Vehicle camio = new Camio("7777-CCC");

        try {
            plaça.aparcar(camio);
            fail("Hauria de llançar excepció");
        } catch (IllegalArgumentException e) {
            assertEquals("La plaça no és compatible", e.getMessage());
        }
    }

}
