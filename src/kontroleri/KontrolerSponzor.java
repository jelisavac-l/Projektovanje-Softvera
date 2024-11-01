package kontroleri;

import broker.DatabaseConnection;
import client.domen.Sponzor;
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
public class KontrolerSponzor {

    public static List<Sponzor> getList() throws SQLException {
        List<Sponzor> lista = new LinkedList<>();

        String query = "SELECT * FROM sponzor ORDER BY naziv ASC";
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            lista.add(new Sponzor(rs.getLong("id"),
                    rs.getString("naziv"),
                    rs.getString("kontakt")));
        }

        rs.close();
        st.close();
        conn.close();
        return lista;
    }
}
