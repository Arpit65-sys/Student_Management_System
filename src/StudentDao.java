import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
    public static void createStudent(Student student) {
        try {
            Connection con = DB.connect();
            String query = Querry.insert;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getCourse());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(Student student) {
        try {
            Connection con = DB.connect();
            String query = Querry.update;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getCourse());
            ps.setInt(5, student.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> readAllStudents() {
        ArrayList<Student> studList = new ArrayList<>();
        try {
            Connection con = DB.connect();
            String query = Querry.select;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student stud = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                        rs.getString("email"), rs.getString("course"));
                studList.add(stud);
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studList;
    }

    public static void deleteStudent(int id) {
        try {
            Connection con = DB.connect();
            String query = Querry.delete;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
