package dao;

import java.sql.Connection;

public class DAOFactory {
	private static DAOFactory instance;

    public static DAOFactory getInstance() {
        if (instance == null) {
                instance = new DAOFactory();
        }
        return instance;
    }

    private DAOFactory() {
        super();
    }

    public UtilisateurDAO createUtilisateurDAO() {
        Connection connection = ConnectionFactory.getInstance().connect();
        return new UtilisateurDAO(connection);
    }
    
    public ProduitDAO createProduitDAO() {
        Connection connection = ConnectionFactory.getInstance().connect();
        return new ProduitDAO(connection);
    }
    
    public CategorieDAO createCategorieDAO() {
        Connection connection = ConnectionFactory.getInstance().connect();
        return new CategorieDAO(connection);
    }
    
    public LivraisonDAO createLivraisonDAO() {
        Connection connection = ConnectionFactory.getInstance().connect();
        return new LivraisonDAO(connection);
    }
    
    public CommandeClientDAO createCommandeClientDAO() {
        Connection connection = ConnectionFactory.getInstance().connect();
        return new CommandeClientDAO(connection);
    }
    
    public CommandeDAO createCommandeDAO() {
        Connection connection = ConnectionFactory.getInstance().connect();
        return new CommandeDAO(connection);
    }
}
