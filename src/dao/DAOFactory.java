package dao;

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

    
}
