import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    static Connection conn = null;

    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/new_schema_student";
            String userName = "root";
            String password = "Tanvi@123";

            conn = DriverManager.getConnection(url, userName, password);

            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
