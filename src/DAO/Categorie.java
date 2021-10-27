package DAO;

public class Categorie {
	private String refCat,cat;

	public Categorie(String refCat, String cat) {
		super();
		this.refCat = refCat;
		this.cat = cat;
	}

	public String getRefCat() {
		return refCat;
	}

	public void setRefCat(String refCat) {
		this.refCat = refCat;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
	
	
}
