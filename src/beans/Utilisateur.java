package beans;

import java.sql.Date;

public class Utilisateur {
	private int ID;
	private String NOM;
	private String PRENOM;
	private java.sql.Date DATE_NAIS;
	private String LOGIN;
	private String PWD;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNOM() {
		return NOM;
	}
	public void setNOM(String nOM) {
		NOM = nOM;
	}
	public String getPRENOM() {
		return PRENOM;
	}
	public void setPRENOM(String pRENOM) {
		PRENOM = pRENOM;
	}
	public java.sql.Date getDATE_NAIS() {
		return DATE_NAIS;
	}
	public void setDATE_NAIS(java.sql.Date dATE_NAIS) {
		DATE_NAIS = dATE_NAIS;
	}
	public String getLOGIN() {
		return LOGIN;
	}
	public void setLOGIN(String lOGIN) {
		LOGIN = lOGIN;
	}
	public String getPWD() {
		return PWD;
	}
	public void setPWD(String pWD) {
		PWD = pWD;
	}
	public Utilisateur(int iD, String nOM, String pRENOM, Date dATE_NAIS, String lOGIN, String pWD) {
		super();
		ID = iD;
		NOM = nOM;
		PRENOM = pRENOM;
		DATE_NAIS = dATE_NAIS;
		LOGIN = lOGIN;
		PWD = pWD;
	}
	
	public Utilisateur() {
		
	}
}
