package client;


import javax.ws.rs.core.MediaType;

import restinterface.*;
import transport.*;


public class ReadClient {
	
	
	public static void main(String[] args) throws Exception {
				
		String url1 = "http://localhost:8080/Service_Taxi/ReservationTaxis/Dup1991";
		AtomReservationTaxi resTaxi = (AtomReservationTaxi)new RestInterface()
			.getRemoteObject(url1,MediaType.APPLICATION_ATOM_XML, AtomReservationTaxi.class);
		System.out.println("------------");
		if(resTaxi==null) {
			System.out.println("la reservation du Taxi n'existe pas");
		}else {
			System.out.println("details de la reservation du taxi : "+resTaxi.getContents());
		}
		
		String url2 = "http://localhost:8080/Service_Avion/ReservationAvions/Dup1991";		
		AtomReservationAvion resAvion = (AtomReservationAvion)new RestInterface().
			getRemoteObject(url2,MediaType.APPLICATION_ATOM_XML, AtomReservationAvion.class);
		System.out.println("------------");
		if(resAvion==null) {
			System.out.println("la reservation de l'avion n'existe pas");
		}else {
			System.out.println("details de la reservation de l'avion : "+resAvion.getContents());
		}		
		String url3 = "http://localhost:8080/Service_Hotel/ReservationHotels/Dup1991";
		AtomReservationHotel resHotel = (AtomReservationHotel)new RestInterface().
			getRemoteObject(url3,MediaType.APPLICATION_ATOM_XML, AtomReservationHotel.class);
		System.out.println("------------");
		if(resHotel==null) {
			System.out.println("la reservation de l'hotel n'existe pas");
		}else {
			System.out.println("details de la reservation de l'hotel : "+resHotel.getContents());
		}		 
		
		}
}
