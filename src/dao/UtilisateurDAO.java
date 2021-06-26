package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Utilisateur;

public class UtilisateurDAO {
	private Connection connection;

    public UtilisateurDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public Utilisateur findUser(String login, String pwd) {
        String sql = "SELECT `ID`, `NOM`, `PRENOM`, `DATE_NAIS`, `LOGIN`, `PWD` FROM utilisateur WHERE `LOGIN`=? and `PWD`=?";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);

            statement.setString(1, login);
            statement.setString(2, pwd);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	Utilisateur user = new Utilisateur(rs.getInt("ID"), rs.getString("NOM"), rs.getString("PRENOM"),Date.valueOf(rs.getString("DATE_NAIS")),rs.getString("LOGIN"),"");
                return user;
            }

        } catch (SQLException e) {
                e.printStackTrace();
        }
        return null;

    }

    public Utilisateur add(Utilisateur user) {
        String sql = "INSERT INTO utilisateur(`ID`, `NOM`, `PRENOM`, `DATE_NAIS`, `LOGIN`, `PWD`) VALUES (NULL,?,?,?,?,?)";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, user.getNOM());
            statement.setString(2, user.getPRENOM());
            statement.setDate(3, user.getDATE_NAIS());
            statement.setString(4, user.getLOGIN());
            statement.setString(5, user.getPWD());
            int rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    public Utilisateur update(Utilisateur user) {
        String sql = "UPDATE utilisateur SET `NOM`=? ,`PRENOM`=?,`DATE_NAIS`=?,`LOGIN`=?,`PWD`=? WHERE `ID`=?";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, user.getNOM());
            statement.setString(2, user.getPRENOM());
            statement.setDate(3, user.getDATE_NAIS());
            statement.setString(4, user.getLOGIN());
            statement.setString(5, user.getPWD());
            statement.setInt(6, user.getID());
            int rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    public int delete(Utilisateur user) {
        String sql = "DELETE FROM utilisateur WHERE `ID`=?";
        int rs = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, user.getID());
            rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }
}
