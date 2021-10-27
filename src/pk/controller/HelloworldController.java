package pk.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.*;

@Controller

public class HelloworldController {

	@RequestMapping(value="/")
	public String index(ModelMap model){
		return "index";
	}
	@RequestMapping(value="/identifier") 
	public String identifier(ModelMap model){
		return "identifier";
	}
	@RequestMapping(value="/inscrire")
	public String inscrire(ModelMap model){
		return "inscrire";
	}
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request,ModelMap model){
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,ModelMap model){
		DAO imp = new DAOImp();
		String email = request.getParameter("email");
		String motPass = request.getParameter("motPass");
		HttpSession session = request.getSession();
		
		Client cln = imp.testCliet(email, motPass);
		if(cln!=null) {
			session.setAttribute("client", cln);
			return "home";
		}else {
			return "identifier";
		}
		
	}
	@RequestMapping(value="/insertionUser")
	public String insertionUser(HttpServletRequest request,ModelMap model){
		DAO imp = new DAOImp();
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String motPass = request.getParameter("motPass");
		String adress = request.getParameter("adress");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String tel = request.getParameter("tel");
		HttpSession session = request.getSession();
		Client client = new Client(00,nom,prenom,email,motPass,adress,codePostal,ville,tel);
		
		imp.addClient(client);
		Client cln2 = imp.testCliet(email, motPass);
		session.setAttribute("client", cln2);
			return "home";

	}
	@RequestMapping(value="/changeLangIndex")
	public String lang(@RequestParam("lang") String lang,ModelMap model){
		model.addAttribute("lang",lang);
		return "index";
	}
	@RequestMapping(value="/catalogue")
	public String catalogue(HttpServletRequest request,ModelMap model) {
		DAO imp = new DAOImp();
		List<Categorie> cats = imp.getCategories();
		List<Article> arts = imp.getArticles();
		request.setAttribute("Articles", arts);
		request.setAttribute("Categories", cats);
		request.setAttribute("Categorie", "All");
		return "catalogue";
	}
	@RequestMapping(value="/cataloge")
	public String cataloge(HttpServletRequest request,ModelMap model) {
		String cat= request.getParameter("categorie");
		DAO imp = new DAOImp();
		List<Article> arts = new ArrayList<Article>();
		if(cat.equals("all")) {
			arts = imp.getArticles();
		}else {
			arts = imp.getArticlesByCat(cat);
		}
		
		List<Categorie> cats = imp.getCategories();
		request.setAttribute("Categories", cats);
		request.setAttribute("Articles", arts);
		request.setAttribute("Categorie", cat);
		return "catalogue";
	}
	@RequestMapping(value="/details")
	public String details(HttpServletRequest request,ModelMap model) {
		String code= request.getParameter("code");
		int codeArticle= Integer.parseInt(code);
		DAO imp = new DAOImp();
		Article art = imp.getArticlesByCode(codeArticle);
		request.setAttribute("item", art);
		return "details";
	}
	@RequestMapping(value="/panier")
	public String panier(HttpServletRequest request,ModelMap model) {
		String code = request.getParameter("codeArticle");
		HttpSession session = request.getSession();
		DAO imp = new DAOImp();
		if(code != null) {
			int codeArticle= Integer.parseInt(code);
			Client client = (Client) session.getAttribute("client");
			int codeClient = client.getId();
			imp.addCmd(codeClient, codeArticle, 1);
		}
		List<Panier> panier =  imp.getPanier(session);
		request.setAttribute("panier", panier);
		return "panier";
	}
	@RequestMapping(value="/admin")
	public String admin(HttpServletRequest request,ModelMap model) {
		return "admin";
	}
	@RequestMapping(value="/adminAddCat")
	public String addCat(HttpServletRequest request,ModelMap model) {
		String refCat = request.getParameter("RefCat");
		String cat = request.getParameter("Cat");
		
		if(refCat != null & cat != null) {
			request.setAttribute("RefCat", refCat);			
			request.setAttribute("Cat", cat);	
			
			return "admin_addCat";
		}else {
			return "admin_addCat";
		}
		//return "admin_addCat";
		
	}
	@RequestMapping(value="/adminAddArt")
	public String addArt(HttpServletRequest request,ModelMap model) {
		
		String titre = request.getParameter("titre");
		String designation = request.getParameter("designation");
		String prix = request.getParameter("prix");
		String stock = request.getParameter("stock");
		String photo = request.getParameter("photo");
		String categorie = request.getParameter("categorie");
		
		if(titre != null & prix != null) {
			request.setAttribute("titre", titre);			
			request.setAttribute("designation", designation);	
			request.setAttribute("prix", prix);			
			request.setAttribute("stock", stock);
			request.setAttribute("photo", photo);			
			request.setAttribute("categorie", categorie);
			
			return "admin_addArt";
		}else {
			return "admin_addArt";
		}
		//return "admin_addArt";
		
	}
}
