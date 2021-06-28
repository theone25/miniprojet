package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Commande;
import beans.CommandeClient;

public class CommandeClientDAO {
	private Connection connection;

    public CommandeClientDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public ArrayList<CommandeClient> findall() {
        String sql = "SELECT `NUM_COM`, `ID_PR`, `QTE` FROM `association_7` WHERE `NUM_COM` = ?";
        ArrayList<CommandeClient> list = new ArrayList<CommandeClient>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	CommandeClient cmd= new CommandeClient(rs.getInt("NUM_COM"), rs.getInt("ID_PR"), rs.getInt("QTE"));
            	list.add(cmd);
            }
            
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return list;

    }

    public CommandeClient add(CommandeClient cmd) {
        String sql = "INSERT INTO `association_7`(`NUM_COM`, `ID_PR`, `QTE`) VALUES (?,?,?)";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, cmd.getNUM_COM());
            statement.setInt(2, cmd.getID_PR());
            statement.setInt(2, cmd.getQTE());
            int rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cmd;

    }
}
