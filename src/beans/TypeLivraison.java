package beans;

public class TypeLivraison {
	private int ID_TYPE;
	private String LIBELLE_LIB;
	
	public int getID_TYPE() {
		return ID_TYPE;
	}
	public void setID_TYPE(int iD_TYPE) {
		ID_TYPE = iD_TYPE;
	}
	public String getLIBELLE_LIB() {
		return LIBELLE_LIB;
	}
	public void setLIBELLE_LIB(String lIBELLE_LIB) {
		LIBELLE_LIB = lIBELLE_LIB;
	}
	
	public TypeLivraison(int iD_TYPE, String lIBELLE_LIB) {
		super();
		ID_TYPE = iD_TYPE;
		LIBELLE_LIB = lIBELLE_LIB;
	}
	
	public TypeLivraison() {
		
	}
}
