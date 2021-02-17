package client;

import javax.ws.rs.core.MediaType;

import business.*;
import restinterface.RestInterface;
import transport.AtomTravel;

public class CreateTravel {

	public static void main(String[] args) {
		//l'id du client est les 3 premieres lettres du nom et l'annee de naissance
		Client client =new Client("Dup1991","David","Dupont","10/01/1991");
		ReservationTaxi reservationTaxi=new ReservationTaxi(client.getId(), "08h00","12/07/2018");
		reservationTaxi.setId("Dup1991");
		ReservationAvion reservationAvion=new ReservationAvion(client.getId(), "09h00", "12h00", "Vienne","Geneve","12/07/2018");
		reservationAvion.setId("Dup1991");
		ReservationHotel reservationHotel=new ReservationHotel(client.getId(),"12/07/2018", "10"); 
		reservationHotel.setId("Dup1991");
		Travel travel=new Travel("1",reservationTaxi, reservationAvion, reservationHotel);
		AtomTravel atomTravel=new AtomTravel(null, travel, true);
		
		String url = "http://localhost:8080/SEC/Travels";
		new RestInterface().postRemoteObject(url,MediaType.APPLICATION_ATOM_XML, AtomTravel.class,atomTravel);
	}
}
