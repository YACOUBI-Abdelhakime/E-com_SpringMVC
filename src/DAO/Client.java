package DAO;

public class Client {
	private String nom,prenom,email,motPass,adress,codePostal,ville,tel;
	private int id;

	public Client(int id, String nom, String prenom, String email, String motPass, String adress, String codePostal,
			String ville, String tel) {
	
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPass = motPass;
		this.adress = adress;
		this.codePostal = codePostal;
		this.ville = ville;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motPass=" + motPass
				+ ", adress=" + adress + ", codePostal=" + codePostal + ", ville=" + ville + ", tel=" + tel + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotPass() {
		return motPass;
	}

	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
