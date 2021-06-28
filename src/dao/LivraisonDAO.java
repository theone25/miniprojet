package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import beans.Livraison;
import beans.Produit;

public class LivraisonDAO {
	private Connection connection;

    public LivraisonDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    /*public Livraison findProduct(int prodID) {
        String sql = "INSERT INTO `livraison`(`NUM_LIV`, `ID_TYPE`, `ADRESSE_LIV`, `TEL_LIV`, `DATE_LIV`)";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);

            statement.setInt(1, prodID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	Produit prod = new Produit(rs.getInt("ID_PR"), rs.getInt("ID_CAT"), rs.getInt("ID"),rs.getString("LIBELLE"),rs.getFloat("PRIX_UNIT"),rs.getString("IMG"));
                return prod;
            }

        } catch (SQLException e) {
                e.printStackTrace();
        }
        return null;

    }*/
    
    public Livraison add(Livraison liv) {
        String sql = "INSERT INTO `livraison`(`NUM_LIV`, `ID_TYPE`, `ADRESSE_LIV`, `TEL_LIV`, `DATE_LIV`) VALUES (NULL,?,?,?,?)";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, liv.getID_TYPE());
            statement.setString(2, liv.getADRESSE_LIV());
            statement.setString(3, liv.getTEL_LIV());
            statement.setDate(4, liv.getDATE_LIV());
            int rs = statement.executeUpdate();
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    liv.setNUM_LIV(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liv;

    }
}
