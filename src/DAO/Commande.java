package DAO;

public class Commande {
	private String numCmd,DateCmd;
	private int codeClient;

	public Commande(String numCmd, int codeClient, String dateCmd) {
		super();
		this.numCmd = numCmd;
		this.codeClient = codeClient;
		DateCmd = dateCmd;
	}

	public String getNumCmd() {
		return numCmd;
	}

	public void setNumCmd(String numCmd) {
		this.numCmd = numCmd;
	}

	public int getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}

	public String getDateCmd() {
		return DateCmd;
	}

	public void setDateCmd(String dateCmd) {
		DateCmd = dateCmd;
	}
}
