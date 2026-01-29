/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.Parking;

import java.util.ArrayList;

import org.yourcompany.Parking.places.Coordenada;
import org.yourcompany.Parking.places.PlacaAparcament;
import org.yourcompany.Parking.places.PlacaComptacte;
import org.yourcompany.Parking.places.PlacaGran;
import org.yourcompany.Parking.places.PlacaRegular;
import org.yourcompany.Parking.vehicles.Camio;
import org.yourcompany.Parking.vehicles.Cotxe;
import org.yourcompany.Parking.vehicles.Motocicleta;

/**
 *
 * @author Shuangyu
 */
public class Parking {

    public static void main(String[] args) {
        // Vehicle v = new Vehicle();
        Motocicleta m = new Motocicleta("1111-AA");
        System.out.println(m.getTipusVehicle());
        Cotxe c = new Cotxe("2222-BB");
        Camio ca = new Camio("3333-CC");

        Coordenada[] coordenades = {
            new Coordenada(0, 0),
            new Coordenada(2, 0),
            new Coordenada(2, 1),
            new Coordenada(0, 1)
        };

        PlacaAparcament plaça = new PlacaGran(1, coordenades);
        System.out.println(plaça);
        plaça.aparcar(c);
        System.out.println(plaça.toString());

        ArrayList<PlacaAparcament> places = new ArrayList<>();
        places.add(new PlacaRegular(1, coordenades));
        places.add(new PlacaRegular(2, coordenades));
        places.add(new PlacaRegular(3, coordenades));
        places.add(new PlacaRegular(4, coordenades));
        places.add(new PlacaRegular(5, coordenades));
        places.add(new PlacaComptacte(6, coordenades));
        places.add(new PlacaComptacte(7, coordenades));
        places.add(new PlacaComptacte(8, coordenades));
        places.add(new PlacaComptacte(9, coordenades));
        places.add(new PlacaComptacte(10, coordenades));

        PlacesParking placesParking = new PlacesParking(places);
        placesParking.mostrarEstat();
        placesParking.aparcar(c);
        placesParking.aparcar(ca);
        placesParking.aparcar(m);
        placesParking.mostrarEstat();

        // Motocicleta m2 = new Motocicleta("1111-AA");
        placesParking.desAparcar(m);
        placesParking.mostrarEstat();

    }
}
