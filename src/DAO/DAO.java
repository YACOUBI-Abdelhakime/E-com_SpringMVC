package DAO;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface DAO {
	public List<Article> getArticles();
	public Client testCliet(String email,String password);
	public boolean addClient(Client c);
	public boolean addArticle(Article c);
	public List<Article> getArticlesByCat(String cat);
	public Article getArticlesByCode(int dode);
	public List<Categorie> getCategories();
	public boolean addCmd(int codeClient,int codeArticle,int qty);
	List<Panier> getPanier(HttpSession session);
}
