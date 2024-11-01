package kontroleri;

import broker.DatabaseConnection;
import client.domen.Clan;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class KontrolerClan {
    
    public static List<Clan> getListSafe() throws SQLException {
        List<Clan> lista = new LinkedList<>();
        String query = "SELECT id,"
                + "ime, prezime,"
                + "korisnickoIme,"
                + "email,"
                + "telefon"
                + "FROM clan"
                + "ORDER BY ime ASC";
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            lista.add(new Clan(rs.getLong("id"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getString("korisnickoIme"),
                    null,
                    rs.getString("email"),
                    rs.getString("telefon")));
        }
        
        rs.close();
        st.close();
        conn.close();
        return lista;
    }

    public static List<Clan> getList() throws SQLException {
        List<Clan> lista = new LinkedList<>();
        String query = "SELECT * FROM clan ORDER BY ime ASC";
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            lista.add(new Clan(rs.getLong("id"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getString("korisnickoIme"),
                    rs.getString("sifra"),
                    rs.getString("email"),
                    rs.getString("telefon")));
        }
        
        rs.close();
        st.close();
        conn.close();
        return lista;
    }
}
