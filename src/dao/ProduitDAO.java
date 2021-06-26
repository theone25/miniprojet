package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import beans.Admin;
import beans.Produit;
import beans.Utilisateur;

public class ProduitDAO {
	private Connection connection;

    public ProduitDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public Produit findProduct(int prodID) {
        String sql = "SELECT `ID_PR`, `ID_CAT`, `ID`, `LIBELLE`, `PRIX_UNIT`, `IMG` FROM `produit` WHERE `ID_PR`=?";

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

    }
    
    public Collection<Produit> findall() {
        String sql = "SELECT `ID_PR`, `ID_CAT`, `ID`, `LIBELLE`, `PRIX_UNIT`, `IMG` FROM `produit`";
        ArrayList<Produit> list = new ArrayList<Produit>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	Produit prod = new Produit(rs.getInt("ID_PR"), rs.getInt("ID_CAT"), rs.getInt("ID"),rs.getString("LIBELLE"),rs.getFloat("PRIX_UNIT"),rs.getString("IMG"));
            	list.add(prod);
            }

        } catch (SQLException e) {
                e.printStackTrace();
        }
        return null;

    }

    public Produit add(Produit prod) {
        String sql = "INSERT INTO `produit`(`ID_PR`, `ID_CAT`, `ID`, `LIBELLE`, `PRIX_UNIT`, `IMG`) VALUES (NULL,?,?,?,?,?)";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, prod.getID_CAT());
            statement.setInt(2, prod.getID());
            statement.setString(3, prod.getLIBELLE());
            statement.setFloat(4, prod.getPRIX_UNIT());
            statement.setString(5, prod.getIMG());
            int rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prod;

    }

    public Produit update(Produit prod) {
        String sql = "UPDATE `produit` SET `ID_CAT`=? ,`ID`=?,`LIBELLE`=?,`PRIX_UNIT`=?,`IMG`=? WHERE `ID_PR`=?";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, prod.getID_CAT());
            statement.setInt(2, prod.getID());
            statement.setString(3, prod.getLIBELLE());
            statement.setFloat(4, prod.getPRIX_UNIT());
            statement.setString(5, prod.getIMG());
            statement.setInt(6, prod.getID_PR());
            int rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prod;

    }

    public int delete(Produit prod) {
        String sql = "DELETE FROM utilisateur WHERE `ID`=?";
        int rs = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, prod.getID());
            rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }
}
