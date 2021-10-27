package DAO;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.servlet.http.HttpSession;

public class DAOImp implements DAO {
	Connection cnx;
	public DAOImp()  {

	     Connexion connexion = Connexion.getInstance();
		cnx = connexion.getConne();
	}
	@Override
	public List<Article> getArticles() {
		List<Article> articles = new ArrayList<Article>();
		try {
			Statement stm = cnx.createStatement();
			ResultSet rs = stm.executeQuery("select * from articles");
			
			while(rs.next()) {
				articles.add(new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7)));
			}
			return articles;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}

	@Override
	public Client testCliet(String email, String password) {
		try {
			PreparedStatement pstm = cnx.prepareStatement("select * from clients where email=? and motPass = ?");
			pstm.setString(1, email);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()){
				return new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
			}else {
				return null;
			}
						
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addClient(Client c) {
		try {
			PreparedStatement pstm = cnx.prepareStatement("INSERT into clients(nom,prenom,email,motPass,adresse,codePostal,ville,tel) values (?,?,?,?,?,?,?,?)");
			pstm.setString(1, c.getNom());
			pstm.setString(2,  c.getPrenom());
			pstm.setString(3,  c.getEmail());
			pstm.setString(4,  c.getMotPass());
			pstm.setString(5,  c.getAdress());
			pstm.setString(6,  c.getCodePostal());
			pstm.setString(7,  c.getVille());
			pstm.setString(8,  c.getTel());
			return pstm.execute();
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addArticle(Article c) {
		try {
			PreparedStatement pstm = cnx.prepareStatement("INSERT into articles values (?,?,?,?,?,?,?)");
			pstm.setInt(1,  c.getCodeArticle());
			pstm.setString(2,  c.getTitre());
			pstm.setString(3,  c.getDesignation());
			pstm.setDouble(4,  c.getPrix());
			pstm.setDouble(5,  c.getStock());
			pstm.setString(6,  c.getCategorie() );
			pstm.setString(7,  c.getPhoto() );
			return pstm.execute();
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Article> getArticlesByCat(String cat) {
		List<Article> articles = new ArrayList<Article>();
		try {
			PreparedStatement pstm = cnx.prepareStatement("select * from articles where categorie = ?");
			pstm.setString(1,cat);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				articles.add(new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7)));
			}
			return articles;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Article getArticlesByCode(int code) {
		try {
			PreparedStatement pstm = cnx.prepareStatement("select * from articles where codeArticle = ?");
			pstm.setInt(1,code);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				return new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7));
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Categorie> getCategories() {
		List<Categorie> cats = new ArrayList<Categorie>();
		try {
			Statement stm = cnx.createStatement();
			ResultSet rs = stm.executeQuery("select * from Categories");
			
			while(rs.next()) {
				cats.add(new Categorie(rs.getString(1),rs.getString(2)));
			}
			return cats;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean addCmd(int codeClient, int codeArticle, int qty) {
		try {
			Date date = new Date();
			String dt = date.toLocaleString();
			
			PreparedStatement pstm = cnx.prepareStatement("Insert into Commande(codeClient,DateCommande) values(?,?)");
			pstm.setInt(1,codeClient);
			pstm.setString(2, dt);
			System.out.println("DATE=="+dt);
			boolean cmd = pstm.execute();
			
			Statement stm = cnx.createStatement();
			ResultSet rs = stm.executeQuery("select * from commande where codeClient='"+codeClient+"' and dateCommande='"+dt+"'  ");
			rs.next();
			int numCmd = rs.getInt(1);
			
			
			PreparedStatement pstm2 = cnx.prepareStatement("Insert into lignescommande values(?,?,?)");
			pstm2.setInt(1,numCmd);
			pstm2.setInt(2, codeArticle);
			pstm2.setInt(3, qty);
			boolean lCmd = pstm2.execute();
			
			return cmd && lCmd;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Panier> getPanier(HttpSession session) {
		try {
			List<Panier> panier = new ArrayList<Panier>();
			Statement stm = cnx.createStatement();
			Client cln = (Client) session.getAttribute("client");
			int idCln = cln.getId();
			
			ResultSet rs = stm.executeQuery("select * from Commande c, LignesCommande l where c.NumCommande = l.NumCommande and codeClient = '"+idCln+"'");
			while(rs.next()) {
				Panier p = new Panier(getArticlesByCode(rs.getInt("codeArticle")),rs.getInt("codeClient"),rs.getInt("Qty"),rs.getString("DateCommande"));
				panier.add(p);
			}
			return panier;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
