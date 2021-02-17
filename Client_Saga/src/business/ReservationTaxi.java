package business;

public class ReservationTaxi {
	private String id;
	private String idClient;
	private String heureDepart;
	private String date;
	
	public ReservationTaxi(String idClient, String heureDepart, String date) {
		super();
		this.idClient = idClient;
		this.heureDepart = heureDepart;
		this.date = date;
		id=idClient+heureDepart;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}


	public ReservationTaxi() {
		super();
	}
	public String getId() {
		return id;
	}
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public String getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: "+id+" ,idClient: "+idClient+", heureDepart:"+heureDepart+" ,date: "+date;
	}

}
