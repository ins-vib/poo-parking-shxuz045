package org.yourcompany.Parking;

import java.util.ArrayList;
import java.util.Scanner;

import org.yourcompany.Parking.places.Coordenada;
import org.yourcompany.Parking.places.PlacaAparcament;
import org.yourcompany.Parking.places.PlacaCompacta;
import org.yourcompany.Parking.places.PlacaGran;
import org.yourcompany.Parking.places.PlacaRegular;
import org.yourcompany.Parking.tickets.Ticket;
import org.yourcompany.Parking.vehicles.Camio;
import org.yourcompany.Parking.vehicles.Cotxe;
import org.yourcompany.Parking.vehicles.Motocicleta;
import org.yourcompany.Parking.vehicles.Vehicle;

/**
 *
 * @author Shuangyu
 */
public class Parking {

    public static void main(String[] args) {
        // // Vehicle v = new Vehicle();
        // Motocicleta m = new Motocicleta("1111-AA");
        // System.out.println(m.getTipusVehicle());
        // Cotxe c = new Cotxe("2222-BB");
        // Camio ca = new Camio("3333-CC");

        // Coordenada[] coordenades = {
        // new Coordenada(0, 0),
        // new Coordenada(2, 0),
        // new Coordenada(2, 1),
        // new Coordenada(0, 1)
        // };
        // PlacaAparcament plaça = new PlacaGran(1, coordenades);
        // System.out.println(plaça);
        // plaça.aparcar(c);
        // System.out.println(plaça.toString());
        // ArrayList<PlacaAparcament> places = new ArrayList<>();
        // places.add(new PlacaRegular(1, coordenades));
        // places.add(new PlacaRegular(2, coordenades));
        // places.add(new PlacaRegular(3, coordenades));
        // places.add(new PlacaRegular(4, coordenades));
        // places.add(new PlacaRegular(5, coordenades));
        // places.add(new PlacaComptacte(6, coordenades));
        // places.add(new PlacaComptacte(7, coordenades));
        // places.add(new PlacaComptacte(8, coordenades));
        // places.add(new PlacaComptacte(9, coordenades));
        // places.add(new PlacaComptacte(10, coordenades));
        // PlacesParking placesParking = new PlacesParking(places);
        // placesParking.mostrarEstat();
        // placesParking.aparcar(c);
        // placesParking.aparcar(ca);
        // placesParking.aparcar(m);
        // placesParking.mostrarEstat();
        // // Motocicleta m2 = new Motocicleta("1111-AA");
        // placesParking.desAparcar(m);
        // placesParking.mostrarEstat();

        Scanner teclat = new Scanner(System.in);

        Coordenada[] coordenades = {
                new Coordenada(0, 0),
                new Coordenada(2, 0),
                new Coordenada(2, 1),
                new Coordenada(0, 1)
        };

        ArrayList<PlacaAparcament> places = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            places.add(new PlacaRegular(i, coordenades));
        }
        for (int i = 6; i <= 10; i++) {
            places.add(new PlacaCompacta(i, coordenades));
        }
        for (int i = 11; i <= 13; i++) {
            places.add(new PlacaGran(i, coordenades));
        }

        PlacesParking placesParking = new PlacesParking(places);

        while (true) {
            System.out.println("MENU PARKING");
            System.out.println("1-Aparcar vehicle");
            System.out.println("2-Desaparcar vehicle");
            System.out.println("3-Mostrar estat del pàrquing");
            System.out.print("Selecciona opció: ");

            int opcio = teclat.nextInt();

            switch (opcio) {
                case 1:
                    System.out.println("Tipus de vehicle:");
                    System.out.println("1-Motocicleta");
                    System.out.println("2-Cotxe");
                    System.out.println("3-Camió");
                    System.out.print("Selecciona tipus: ");
                    int tipusVehicle = teclat.nextInt();
                    teclat.nextLine();

                    System.out.print("Introdueix la matrícula: ");
                    String matricula = teclat.nextLine();

                    Vehicle vehicle = null;
                    switch (tipusVehicle) {
                        case 1:
                            vehicle = new Motocicleta(matricula);
                            break;
                        case 2:
                            vehicle = new Cotxe(matricula);
                            break;
                        case 3:
                            vehicle = new Camio(matricula);
                            break;
                        default:
                            System.out.println("Tipus de vehicle incorrecte!");
                            break;
                    }

                    if (vehicle != null) {
                        Ticket ticket = placesParking.aparcar(vehicle);
                        if (ticket != null) {
                            System.out.println("Vehicle aparcat correctament!");
                            System.out.println("ID del ticket: " + ticket.getNumero());
                        } else {
                            System.out.println("No hi ha places disponibles per aquest vehicle!");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Introdueix l'ID del ticket: ");
                    int ticketId = teclat.nextInt();
                    teclat.nextLine();

                    Ticket ticketASortir = placesParking.getTickets(ticketId);
                    if (ticketASortir != null) {
                        try {
                            double preu = placesParking.desaparcar(ticketASortir);
                            System.out.println("Vehicle desaparcat correctament!");
                            System.out.println("Import a pagar: " + preu + " euros");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Ticket no vàlid!");
                    }
                    break;

                case 3:
                    System.out.println("ESTAT DEL PÀRQUING");
                    placesParking.mostrarEstat();
                    break;

                default:
                    System.out.println("Opció incorrecta!");
            }
        }
    }

}
