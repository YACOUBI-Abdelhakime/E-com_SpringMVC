package DAO;

public class Panier {
	private int codeClient,qty;
	private Article article;
	private String dateCommande;
	public Panier( Article article,int codeClient, int qty, String dateCommande) {
		super();
		this.codeClient = codeClient;
		this.qty = qty;
		this.article = article;
		this.dateCommande = dateCommande;
	}
	public int getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public String getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

}
