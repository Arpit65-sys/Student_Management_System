public class Querry {
    static String insert = "INSERT INTO student (id, name, age, email, course) VALUES (?,?,?,?,?)";
    static String update = "UPDATE student SET name=?, age=?, email=?, course=? WHERE id=?";
    static String delete = "DELETE FROM student WHERE id = ?";
    static String select = "SELECT * FROM student";
}
