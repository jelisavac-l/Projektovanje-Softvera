package kontroleri;

import broker.DatabaseConnection;
import domen.Clan;
import domen.Tim;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public static Tim getTimFromClan(Clan clan) throws SQLException
    {
        Connection conn = DatabaseConnection.getInstance();
        String query = "SELECT t.id, t.naziv FROM `clan-tim` ct JOIN tim t ON ct.clan = t.id WHERE ct.clan=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, clan.getId());
        Tim t;
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            t = new Tim(rs.getLong("id"),
                    rs.getString("naziv"));
            
        } else {
            t = null;
        }
        return t;
    }

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
    
    
    
    public static void create(Tim tim) throws SQLException {
        String query = "INSERT INTO ProjektovanjeSoftvera1.tim\n"
                + "(naziv)\n"
                + "VALUES(?);";

        Connection conn = DatabaseConnection.getInstance();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, tim.getNaziv());

        ps.execute();
        ps.close();
        conn.close();
    }

    public static void update(Tim stari, Tim novi) throws SQLException {
        String query = "UPDATE ProjektovanjeSoftvera1.tim\n"
                + "SET naziv=?\n"
                + "WHERE id=?;";
        
        Connection conn = DatabaseConnection.getInstance();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, novi.getNaziv());
        ps.setLong(2, stari.getId());
        
        ps.execute();
        ps.close();
        conn.close();
        
    }
}
