package beans;

public class Produit {
	private int id;
	private String nom,description,image;
	private float prix;
	
	public Produit(int id, String nom, String description, String image, float prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.image = image;
		this.prix = prix;
	}
	
	public Produit() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	

}
