package business;

public class ReservationHotel {
	private String id;
	private String idClient;
	private String date;
	private String nbJours;

	public ReservationHotel(String idClient, String date, String nbJours) {
		super();
		this.idClient = idClient;
		this.date = date;
		this.nbJours = nbJours;
		id=idClient+date;
	}
	
	public ReservationHotel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNbJours() {
		return nbJours;
	}
	public void setNbJours(String nbJours) {
		this.nbJours = nbJours;
	}
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: "+id+" ,idClient: "+idClient+" ,date: "+date+" ,Nb jours:"+nbJours;
	}
	
}
