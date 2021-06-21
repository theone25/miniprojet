package beans;

import java.sql.Date;

public class Livraison
{
	public int NUM_LIV;
	public int ID_TYPE;
	public String ADRESSE_LIV;
	public String TEL_LIV;
	public java.sql.Date DATE_LIV;
	
	public int getNUM_LIV() {
		return NUM_LIV;
	}
	public void setNUM_LIV(int nUM_LIV) {
		NUM_LIV = nUM_LIV;
	}
	public int getID_TYPE() {
		return ID_TYPE;
	}
	public void setID_TYPE(int iD_TYPE) {
		ID_TYPE = iD_TYPE;
	}
	public String getADRESSE_LIV() {
		return ADRESSE_LIV;
	}
	public void setADRESSE_LIV(String aDRESSE_LIV) {
		ADRESSE_LIV = aDRESSE_LIV;
	}
	public String getTEL_LIV() {
		return TEL_LIV;
	}
	public void setTEL_LIV(String tEL_LIV) {
		TEL_LIV = tEL_LIV;
	}
	public java.sql.Date getDATE_LIV() {
		return DATE_LIV;
	}
	public void setDATE_LIV(java.sql.Date dATE_LIV) {
		DATE_LIV = dATE_LIV;
	}
	
	public Livraison(int nUM_LIV, int iD_TYPE, String aDRESSE_LIV, String tEL_LIV, Date dATE_LIV) {
		super();
		NUM_LIV = nUM_LIV;
		ID_TYPE = iD_TYPE;
		ADRESSE_LIV = aDRESSE_LIV;
		TEL_LIV = tEL_LIV;
		DATE_LIV = dATE_LIV;
	}
	
	public Livraison() {
		
	}
	
}