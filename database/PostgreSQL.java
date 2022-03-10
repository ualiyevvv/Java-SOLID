package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL implements IDatabase {
    private String url = "jdbc:postgresql://localhost:5432/lab6";
    private String user = "postgres";
    private String pass = "root";
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Connection connect = DriverManager.getConnection(url, user, pass);
            return connect;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
