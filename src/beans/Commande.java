package beans;

import java.util.HashMap;

public class Commande {
	private int id,UserId;
	private HashMap<Integer, Integer> commande;
	private float totale;
	
	public Commande(int id, int userId, HashMap<Integer, Integer> commande, float totale) {
		super();
		this.id = id;
		UserId = userId;
		this.commande = commande;
		this.totale = totale;
	}
	
	public Commande() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public HashMap<Integer, Integer> getCommande() {
		return commande;
	}

	public void setCommande(HashMap<Integer, Integer> commande) {
		this.commande = commande;
	}

	public float getTotale() {
		return totale;
	}

	public void setTotale(float totale) {
		this.totale = totale;
	}
	
	

}
