package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Categorie;
import beans.Produit;

public class CategorieDAO {
	private Connection connection;

    public CategorieDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public Categorie findCat(int catID) {
        String sql = "SELECT `ID_CAT`, `LIB_CAT`, `IMG_CAT` FROM `categorie` WHERE `ID_CAT`=?";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);

            statement.setInt(1, catID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	Categorie cat= new Categorie(rs.getInt("ID_CAT"),rs.getString("LIB_CAT"),rs.getString("IMG_CAT"));
                return cat;
            }

        } catch (SQLException e) {
                e.printStackTrace();
        }
        return null;

    }
    
    public ArrayList<Categorie> findall() {
        String sql = "SELECT `ID_CAT`, `LIB_CAT`, `IMG_CAT` FROM `categorie`";
        ArrayList<Categorie> list = new ArrayList<Categorie>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	Categorie prod = new Categorie(rs.getInt("ID_CAT"),rs.getString("LIB_CAT"),rs.getString("IMG_CAT"));
            	list.add(prod);
            }
            
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return list;

    }

    /*public Produit add(Produit prod) {
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

    }*/
    /*
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

    }*/
}
