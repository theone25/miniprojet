package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import beans.Admin;

public class AdminDAO {
	private Connection connection;

    public AdminDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public Collection<Admin> findAll() {
        String sql = "SELECT * FROM Student";
        ArrayList<Admin> list = new ArrayList<Admin>();

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"));
                CourseDAO courseDAO = new CourseDAO(connection);
                student.setCourses((List<Course>) courseDAO.findByIdStudent(student.getId()));
                
                list.add(student);
            }

        } catch (Exception e) {
                e.printStackTrace();
        }
        return list;

    }
    
     public Collection<Admin> findByIdCourse(int idCourse) {
            String sql = "SELECT id, name, lastname FROM StudentCourse sc INNER JOIN Student s ON sc.idStudent = s.id WHERE idCourse= ?";

            ArrayList<Admin> list = new ArrayList<Admin>();

            try {
                    PreparedStatement statement = getConnection().prepareStatement(sql);
                    statement.setInt(1, idCourse);
                    ResultSet rs = statement.executeQuery();

                    while (rs.next()) {
                        Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"));
                        list.add(student);
                    }

            } catch (Exception e) {
                    e.printStackTrace();
            }
            return list;

	}

    public Admin findById(int id) {
        String sql = "SELECT * FROM Admin WHERE ID= ?";
        Connection conn = null;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	Admin admin = new Admin(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"));
                CourseDAO courseDAO = new CourseDAO(connection);
                student.setCourses((List<Course>) courseDAO.findByIdStudent(student.getId()));
                
                return student;
            }

        } catch (SQLException e) {
                e.printStackTrace();
        }
        return null;

    }

    public Student add(Student student) {
        String sql = "INSERT INTO Student (`id`, `name`, `lastname`) VALUES (NULL,?,?)";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getLastname());
            int rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;

    }

    public Course addStudentToCourse(Student student, Course course) {
        String sql = "INSERT INTO StudentCourse (`idStudent`, `idCourse`) VALUES (?,?)";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, student.getId());
            statement.setInt(2, course.getId());
            int rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return course;        

    }

    public Admin update(Admin admin) {
        String sql = "UPDATE Student SET `name` = ?, `lastname` = ? WHERE `Student`.`id` = ?";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getLastname());
            statement.setInt(3, student.getId());
            int rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;

    }

    public int delete(Admin admin) {
        String sql = "DELETE FROM Admin WHERE ID = ?";
        int rs = 0;

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, admin.getID());
            rs = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }


}
