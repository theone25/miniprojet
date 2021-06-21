package beans;

import java.sql.Date;

public class Commande {
	private  int NUM_COM;
	private int NUM_LIV;
	private int ID;
	private java.sql.Date DATE_COM;
	private String ETAT_COM;
	private String PAIEMENT;
	
	public int getNUM_COM() {
		return NUM_COM;
	}
	public void setNUM_COM(int nUM_COM) {
		NUM_COM = nUM_COM;
	}
	public int getNUM_LIV() {
		return NUM_LIV;
	}
	public void setNUM_LIV(int nUM_LIV) {
		NUM_LIV = nUM_LIV;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public java.sql.Date getDATE_COM() {
		return DATE_COM;
	}
	public void setDATE_COM(java.sql.Date dATE_COM) {
		DATE_COM = dATE_COM;
	}
	public String getETAT_COM() {
		return ETAT_COM;
	}
	public void setETAT_COM(String eTAT_COM) {
		ETAT_COM = eTAT_COM;
	}
	public String getPAIEMENT() {
		return PAIEMENT;
	}
	public void setPAIEMENT(String pAIEMENT) {
		PAIEMENT = pAIEMENT;
	}
	
	public Commande(int nUM_COM, int nUM_LIV, int iD, Date dATE_COM, String eTAT_COM, String pAIEMENT) {
		super();
		NUM_COM = nUM_COM;
		NUM_LIV = nUM_LIV;
		ID = iD;
		DATE_COM = dATE_COM;
		ETAT_COM = eTAT_COM;
		PAIEMENT = pAIEMENT;
	}
	
	public Commande() {
		
	}

}
