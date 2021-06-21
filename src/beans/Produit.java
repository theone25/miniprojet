package beans;

public class Produit {
	private int ID_PR;
	private int ID_CAT;
	private int ID;
	private String LIBELLE;
	private float PRIX_UNIT;
	private String IMG;
	public int getID_PR() {
		return ID_PR;
	}
	public void setID_PR(int iD_PR) {
		ID_PR = iD_PR;
	}
	public int getID_CAT() {
		return ID_CAT;
	}
	public void setID_CAT(int iD_CAT) {
		ID_CAT = iD_CAT;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getLIBELLE() {
		return LIBELLE;
	}
	public void setLIBELLE(String lIBELLE) {
		LIBELLE = lIBELLE;
	}
	public float getPRIX_UNIT() {
		return PRIX_UNIT;
	}
	public void setPRIX_UNIT(float pRIX_UNIT) {
		PRIX_UNIT = pRIX_UNIT;
	}
	public String getIMG() {
		return IMG;
	}
	public void setIMG(String iMG) {
		IMG = iMG;
	}
	public Produit(int iD_PR, int iD_CAT, int iD, String lIBELLE, float pRIX_UNIT, String iMG) {
		super();
		ID_PR = iD_PR;
		ID_CAT = iD_CAT;
		ID = iD;
		LIBELLE = lIBELLE;
		PRIX_UNIT = pRIX_UNIT;
		IMG = iMG;
	}
	
	public Produit() {
		
	}

}
