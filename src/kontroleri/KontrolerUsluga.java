package kontroleri;

import broker.DatabaseConnection;
import client.domen.Usluga;
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
public class KontrolerUsluga {
    public static List<Usluga> getList() throws SQLException {
        List<Usluga> lista = new LinkedList<>();
        String query = "SELECT * FROM usluga ORDER BY naziv ASC";
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            lista.add(new Usluga(rs.getLong("id"),
                    rs.getString("naziv"),
                    rs.getDouble("cena")));
        }

        rs.close();
        st.close();
        conn.close();
        return lista;
    }
}
