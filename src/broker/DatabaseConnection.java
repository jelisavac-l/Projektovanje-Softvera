package broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    
    private static DatabaseConnection instance = null;
    private static Connection conn = null;
    
    private void init() throws SQLException {
        final String DB_URL = "jdbc:mysql://localhost:3306/ProjektovanjeSoftvera1";
        final String USER = "root";
        final String PASS = "";
        
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

    }

    private DatabaseConnection() {
        try {
            init();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getInstance() {
        try {
            if(instance == null || conn.isClosed())
                instance = new DatabaseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance.conn;
    }
}
