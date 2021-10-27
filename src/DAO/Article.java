package DAO;

public class Article {
	private int codeArticle;
	private String titre,designation,categorie,photo;
	private double prix,stock;
	
	
	public Article(int codeArtivle, String titre, String designation,double prix,
			double stock ,String categorie, String photo ) {
		super();
		this.codeArticle = codeArtivle;
		this.titre = titre;
		this.designation = designation;
		this.categorie = categorie;
		this.photo = photo;
		this.prix = prix;
		this.stock = stock;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getCodeArticle() {
		return codeArticle;
	}
	public void setCodeArticle(int codeArtivle) {
		this.codeArticle = codeArtivle;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
}
