package kontroleri;

import broker.DatabaseConnection;
import client.domen.Clan;
import exepts.ModalException;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
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
        return lista;
    }

    public static void create(Clan clan) throws SQLException, ModalException {
        
        // Validacija email-a
        if(!clan.getKorisnickoIme().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new ModalException("Unesen je neispravan email.");
        
        // Validacija korisnickog imena
        List<Clan> lc = getList();
        for(Clan c : lc) {
            if(c.getKorisnickoIme().equals(clan.getKorisnickoIme()))
                throw new ModalException("Uneseno je postojeće korisničko ime!");
        }
        
        // Validacija ostalih parametara
        if(clan.getIme() == null || clan.getPrezime() == null || clan.getTelefon() == null)
            throw new ModalException("Niste uneli sve parametre!");
        
        
        String query = "INSERT INTO ProjektovanjeSoftvera1.clan\n"
                + "(ime, prezime, korisnickoIme, sifra, email, telefon)\n"
                + "VALUES(?, ?, ?, ?, ?, ?);";
        
        Connection conn = DatabaseConnection.getInstance();
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, clan.getIme());
        ps.setString(2, clan.getPrezime());
        ps.setString(3, clan.getKorisnickoIme());
        ps.setString(4, clan.getSifra());
        ps.setString(5, clan.getEmail());
        ps.setString(6, clan.getTelefon());
        
        System.out.println(ps);
        
        ps.execute();
        
        ps.close();
    }

    public static void update(Clan stari, Clan novi) throws SQLException {
        String query = "UPDATE ProjektovanjeSoftvera1.clan "
                + "SET ime=?, prezime=?, korisnickoIme=?, sifra=?, email=?, telefon=? "
                + "WHERE id=?";

        Connection conn = DatabaseConnection.getInstance();
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, novi.getIme());
        ps.setString(2, novi.getPrezime());
        ps.setString(3, novi.getKorisnickoIme());
        ps.setString(4, novi.getSifra());
        ps.setString(5, novi.getEmail());
        ps.setString(6, novi.getTelefon());
        ps.setLong(7, stari.getId());

        System.out.println(ps);

        ps.executeUpdate();

        ps.close();

    }
    
        public static void updateSafe(Clan stari, Clan novi) throws SQLException {
        String query = "UPDATE ProjektovanjeSoftvera1.clan "
                + "SET ime=?, prezime=?, korisnickoIme=?, email=?, telefon=? "
                + "WHERE id=?";

        Connection conn = DatabaseConnection.getInstance();
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, novi.getIme());
        ps.setString(2, novi.getPrezime());
        ps.setString(3, novi.getKorisnickoIme());
        ps.setString(4, novi.getEmail());
        ps.setString(5, novi.getTelefon());
        ps.setLong(6, stari.getId());

        System.out.println(ps);

        ps.executeUpdate();

        ps.close();

    }

    public static void delete(Clan clan) throws SQLException {
        throw new UnsupportedOperationException("Dok ne smislim, nema..");
    }
}
