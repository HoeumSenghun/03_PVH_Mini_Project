package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/stockManagement_db";
        String username = "postgres";
        String password = "root";
        java.sql.Connection con = null;

        try {
            //Load Driver
            Class.forName("org.postgresql.Driver");
            //Connection
            con = DriverManager.getConnection(url, username, password);
            if(con.isValid(2)) {
                System.out.println("Connection Successful");
            }
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) { // Corrected exception
                e.printStackTrace();
            }
        }
    }
}
