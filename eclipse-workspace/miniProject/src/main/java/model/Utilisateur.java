package model;

public class Utilisateur {
	private int id;
	private String prenom;
	private String nom;
	private String email;
	private String motDePasse;
	private String role;
	
	public Utilisateur() {}
	
	public Utilisateur(String prenom,String nom, String email,String motDePasse, String role) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
