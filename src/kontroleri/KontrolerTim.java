package kontroleri;

import broker.DatabaseConnection;
import client.domen.Tim;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author luka
 */
public class KontrolerTim {
    public static List<Tim> getList() throws SQLException {
        List<Tim> lista = new LinkedList<>();
        String query = "SELECT * FROM tim ORDER BY naziv ASC";
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            lista.add(new Tim(rs.getLong("id"),
                    rs.getString("naziv")));
        }
        
        rs.close();
        st.close();
        conn.close();
        return lista;
    }
}
