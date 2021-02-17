package services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.http.HttpResponse;
import business.*;
import dto.FileStorage;
import restinterface.RestInterface;
import transport.*;

@Path("/")
public class EntryPoint {
	

	private static final String FILE_PATH_SERVICES= EntryPoint.class.getClassLoader().getResource("servicesWrite.txt").getPath();
	private static final String FILE_PATH_LOG= EntryPoint.class.getClassLoader().getResource("log.txt").getPath();
	private static final String OK = "ok-";
	private static final String KO = "ko-";
	
	//stores a new data
	@POST
	@Path("Travels")
	@Consumes(MediaType.APPLICATION_ATOM_XML)
	public void updatesServices(AtomTravel atomTravel,@Context HttpServletResponse response){
		try {
			//charger les urls des services (enregistrés localement )
		List <Service> services = new FileStorage().readAllServices(FILE_PATH_SERVICES);		//récuperer le travel reçu dans le payload
		Travel travel= atomTravel.getContents();
	
		

		
		new FileStorage().rewrite(FILE_PATH_LOG);//je vide le fichier pour chaque requete
		
		boolean koExist=false;
		
		for(Service service : services) {
				//suivant le type de service la méthode nou retourne un AtomReservationXXX spécifique(AtomReservationTaxi, AtomReservationHotel....)
				AtomConstruct atom =getReservationAtom(service.getType(), travel);
				
				// envoyer la reservation au service concerné
				HttpResponse responsefromService=new RestInterface().postRemoteObject(service.getUrl(), MediaType.APPLICATION_ATOM_XML, atom.getClass(), atom);				

				//suivant le status retourne, on peut déduire si la requete est realisé avec success( ok), ou pas (ko)=>on enregistre dans le log
				if(responsefromService.getStatusLine().getStatusCode() == HttpServletResponse.SC_CREATED) {
					new FileStorage().appendResevationDTO(OK+service.getUrl(), FILE_PATH_LOG);
				}else {
					new FileStorage().appendResevationDTO(KO+service.getUrl(), FILE_PATH_LOG); 
					koExist=true;
					break;
				}		
				
		}
		
		
		//si aucun "ko" on ne fait rien
		if(!koExist) {
			response.setStatus(HttpServletResponse.SC_OK);
		}else {
		//si on a un "ko" on execute la compensation dans les services avec des "ok" pour respecter 
		//la consistance
			List<String> urlsOk = new FileStorage().readAllok(FILE_PATH_LOG);
			for(String url:urlsOk) {
				System.out.println(url+"/undo");
				new RestInterface().deleteAllRemoteObject(url+"/undo");				
			}
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		response.flushBuffer();
		} catch (Exception e) {e.printStackTrace();}
	}
	
	
	public AtomConstruct getReservationAtom(TypeReservation type, Travel travel) {	
		if(type.equals(TypeReservation.RESERVATION_TAXI)) {
			return new AtomReservationTaxi(null, travel.getReservationTaxi(), true);
		}else if(type.equals(TypeReservation.RESERVATION_AVION)) {
			return new AtomReservationAvion(null, travel.getReservationAvion(), true);
		}else {
			return new AtomReservationHotel(null, travel.getReservationHotel(), true);
		}		
	}

}
