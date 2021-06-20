package beans;

public class Categorie {
	private int ID_CAT;
	public int getID_CAT()
	{
		return this.ID_CAT;
	}
	public void setID_CAT(int value)
	{
		this.ID_CAT = value;
	}

	private String LIB_CAT;
	public String getLIB_CAT()
	{
		return this.LIB_CAT;
	}
	public void setLIB_CAT(String value)
	{
		this.LIB_CAT = value;
	}

	private String IMG_CAT;
	public String getIMG_CAT()
	{
		return this.IMG_CAT;
	}
	public void setIMG_CAT(String value)
	{
		this.IMG_CAT = value;
	}


	public Categorie(int ID_CAT,String LIB_CAT,String IMG_CAT)
	{
		this.ID_CAT = ID_CAT;
		this.LIB_CAT = LIB_CAT;
		this.IMG_CAT = IMG_CAT;
	}
	
	public Categorie() {
		
	}
}
