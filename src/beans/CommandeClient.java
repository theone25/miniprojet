package beans;

public class CommandeClient {
	private int NUM_COM;
	public int getNUM_COM()
	{
		return this.NUM_COM;
	}
	public void setNUM_COM(int value)
	{
		this.NUM_COM = value;
	}

	private int ID_PR;
	public int getID_PR()
	{
		return this.ID_PR;
	}
	public void setID_PR(int value)
	{
		this.ID_PR = value;
	}


	public CommandeClient(int NUM_COM,int ID_PR)
	{
		this.NUM_COM = NUM_COM;
		this.ID_PR = ID_PR;
	}
	
	public CommandeClient() {
		
	}
}

