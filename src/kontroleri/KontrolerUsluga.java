package kontroleri;

import broker.DatabaseConnection;
import domen.Usluga;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
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
        return lista;
    }
    
    // Malo optimalniji nacin da se izvede pretraga
    public static Usluga getById(Long id) throws RuntimeException, SQLException
    {
        
        Connection conn = DatabaseConnection.getInstance();
        String query = "SELECT * FROM usluga WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            return new Usluga(rs.getLong("id"), rs.getString("naziv"), rs.getDouble("cena"));
        } else {
            throw new RuntimeException("Nije pronadjena usluga sa zadatim ID-jem!");
        }
    }
}
