package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Commande;
import beans.Produit;

public class CommandeDAO {
	private Connection connection;

    public CommandeDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public ArrayList<Commande> findall() {
        String sql = "SELECT `NUM_COM`, `NUM_LIV`, `ID`, `DATE_COM`, `ETAT_COM`, `PAIEMENT` FROM `commande` WHERE `ID` = ?";
        ArrayList<Commande> list = new ArrayList<Commande>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	Commande cmd= new Commande(rs.getInt("NUM_COM"), rs.getInt("NUM_LIV"), rs.getInt("ID"),Date.valueOf(rs.getString("DATE_COM")),rs.getString("ETAT_COM"),rs.getString("PAIEMENT"));
            	list.add(cmd);
            }
            
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return list;

    }

    public Commande add(Commande cmd) {
        String sql = "INSERT INTO `commande`(`NUM_COM`, `NUM_LIV`, `ID`, `DATE_COM`, `ETAT_COM`, `PAIEMENT`) VALUES (NULL,?,?,?,?,?)";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, cmd.getNUM_LIV());
            statement.setInt(2, cmd.getID());
            statement.setDate(3, cmd.getDATE_COM());
            statement.setString(4, cmd.getETAT_COM());
            statement.setString(5, cmd.getPAIEMENT());
            int rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cmd;

    }
}
