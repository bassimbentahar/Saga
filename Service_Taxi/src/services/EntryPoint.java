	package services;



import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dto.FileStorage;

@Path("/")
public class EntryPoint {
	
	// get le path du fichier actualData.txt (dans le serveur)
	private static final String FILE_PATH_ACTUAL_DATA= EntryPoint.class.getClassLoader().getResource("actualData.txt").getPath();
	// get le path du fichier de recuperation 
	private static final String FILE_PATH_UNDO= EntryPoint.class.getClassLoader().getResource("undoData.txt").getPath();
	
	//update a new data 
	@POST
	@Path("ReservationTaxis")
	@Consumes(MediaType.APPLICATION_ATOM_XML)
	public void createReservation(String reservation,@Context HttpServletResponse response)throws Exception{
		System.out.println("--- Service 1 => creation d'une reservation d'un taxi (retourne 201)");		
		FileStorage fileStorage=new FileStorage();
		//enregistre le fichier actuel avant la modification dans le fichier de recuperation
		fileStorage.save(FILE_PATH_ACTUAL_DATA,FILE_PATH_UNDO);
		// pour simplifier on va enregistrer l'AtomReservationTaxi dans le fichier principal	
		fileStorage.append(reservation.toString(), FILE_PATH_ACTUAL_DATA);
		response.setStatus(HttpServletResponse.SC_CREATED);
		try { response.flushBuffer();}catch(Exception e){}
	}
	
	@DELETE
	@Path("ReservationTaxis/undo")
	@Consumes(MediaType.APPLICATION_ATOM_XML)
	public void undo()throws Exception{
		FileStorage fileStorage=new FileStorage();
		fileStorage.save(FILE_PATH_UNDO,FILE_PATH_ACTUAL_DATA);
	}
	
	//retrieves the lastest event having the id
	@GET
	@Path("ReservationTaxis/{id}")
	@Produces(MediaType.APPLICATION_ATOM_XML)
	public String getEvent(@PathParam("id") String id)throws Exception{
		String result = new FileStorage().read(id,FILE_PATH_ACTUAL_DATA);
		if(result == null)
			throw new WebApplicationException(404);
		return result;
	}
	

}
