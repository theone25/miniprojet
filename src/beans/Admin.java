package beans;

public class Admin
{
	private int ID;
	public int getID()
	{
		return this.ID;
	}
	public void setID(int value)
	{
		this.ID = value;
	}

	private String NOM;
	public String getNOM()
	{
		return this.NOM;
	}
	public void setNOM(String value)
	{
		this.NOM = value;
	}

	private String PRENOM;
	public String getPRENOM()
	{
		return this.PRENOM;
	}
	public void setPRENOM(String value)
	{
		this.PRENOM = value;
	}

	private java.sql.Date DATE_NAIS;
	public java.sql.Date getDATE_NAIS()
	{
		return this.DATE_NAIS;
	}
	public void setDATE_NAIS(java.sql.Date value)
	{
		this.DATE_NAIS = value;
	}

	private String LOGIN;
	public String getLOGIN()
	{
		return this.LOGIN;
	}
	public void setLOGIN(String value)
	{
		this.LOGIN = value;
	}

	private String PWD;
	public String getPWD()
	{
		return this.PWD;
	}
	public void setPWD(String value)
	{
		this.PWD = value;
	}

	private String MATRICULE;
	public String getMATRICULE()
	{
		return this.MATRICULE;
	}
	public void setMATRICULE(String value)
	{
		this.MATRICULE = value;
	}


	public Admin(int ID,String NOM,String PRENOM,java.sql.Date DATE_NAIS,String LOGIN,String PWD,String MATRICULE)
	{
		this.ID = ID;
		this.NOM = NOM;
		this.PRENOM = PRENOM;
		this.DATE_NAIS = DATE_NAIS;
		this.LOGIN = LOGIN;
		this.PWD = PWD;
		this.MATRICULE = MATRICULE;
	}
	
	public Admin() {
		
	}
}
