package business;

public class ReservationTrain {
	private String id;
	private String idClient;
	private String heureDepart;
	private String heureArrivee;
	private String villeDepart;
	private String villeArrivee;	
	private String date;

	public ReservationTrain(String idClient, String heureDepart, String heureArrivee, String villeDepart,
			String villeArrivee, String date) {
		super();
		this.idClient = idClient;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.date = date;
		id=idClient+heureDepart;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public ReservationTrain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
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
	public String getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
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
		return "id: "+id+" ,idClient: "+idClient+", heureDepart:"+heureDepart+" ,date: "+date+"  De:"+villeDepart+" à"+villeArrivee;
	}	
	
}
