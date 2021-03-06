package business;

public class Personne {
	protected String id;
	protected String nom;
	protected String prenom;
	protected String dateNaissane;
	
	public Personne(String id, String nom, String prenom, String dateNaissane) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissane = dateNaissane;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDateNaissane() {
		return dateNaissane;
	}

	public void setDateNaissane(String dateNaissane) {
		this.dateNaissane = dateNaissane;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String toString() {
		return nom +" " +prenom;
	}

}
