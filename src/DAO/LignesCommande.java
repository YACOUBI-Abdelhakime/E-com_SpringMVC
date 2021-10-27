package DAO;

public class LignesCommande {
	private String numCmd,codeArticle,qty;

	public LignesCommande(String numCmd, String codeArticle, String qty) {
		super();
		this.numCmd = numCmd;
		this.codeArticle = codeArticle;
		this.qty = qty;
	}

	public String getNumCmd() {
		return numCmd;
	}

	public void setNumCmd(String numCmd) {
		this.numCmd = numCmd;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}
}
