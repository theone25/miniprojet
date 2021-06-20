package beans;

public class User {
	private int id;
	private String username,prenom,nom,pass,email,role,photo;
	
	public User() {
		
	}

	public User(int id, String username, String prenom, String nom, String pass, String email, String role,
			String photo) {
		super();
		this.id = id;
		this.username = username;
		this.prenom = prenom;
		this.nom = nom;
		this.pass = pass;
		this.email = email;
		this.role = role;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

}
