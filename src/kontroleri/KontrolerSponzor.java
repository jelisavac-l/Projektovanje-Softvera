package kontroleri;

import broker.DatabaseConnection;
import client.domen.FizickoLice;
import client.domen.PravnoLice;
import client.domen.Sponzor;
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
        return lista;
    }

    public static List<FizickoLice> getListFL() throws SQLException {
        List<FizickoLice> lista = new LinkedList<>();

        String query = "SELECT s.id, s.naziv, s.kontakt, f.jmbg "
                + "FROM fizickoLice f "
                + "JOIN sponzor s ON (s.id = f.id)";

        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            lista.add(new FizickoLice(
                    rs.getString("jmbg"),
                    rs.getLong("id"),
                    rs.getString("naziv"),
                    rs.getString("kontakt")
            ));
        }

        rs.close();
        st.close();
        return lista;

    }

    public static List<PravnoLice> getListPL() throws SQLException {
        List<PravnoLice> lista = new LinkedList<>();

        String query = "SELECT s.id, s.naziv, s.kontakt, pl.regBr, pl.pib "
                + "FROM pravnoLice pl "
                + "JOIN sponzor s ON (s.id = pl.id)";

        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            lista.add(new PravnoLice(
                    rs.getString("regBr"),
                    rs.getString("pib"),
                    rs.getLong("id"),
                    rs.getString("naziv"),
                    rs.getString("kontakt")
            ));
        }

        rs.close();
        st.close();
        return lista;

    }

    // Zasto ovo nisam ranije otkrio...
    /**
     * Sponzor is either FL or PL but the superclass must be generated first.
     *
     * @param s type Sponzor so that if I change attributes I don't need to
     * change this method parameters.
     * @return Returns created ID
     * @throws SQLException
     */
    private static Long createS(Sponzor s) throws SQLException {
        String query = "INSERT INTO ProjektovanjeSoftvera1.sponzor\n"
                + "(naziv, kontakt)\n"
                + "VALUES(?, ?)";

        Connection conn = DatabaseConnection.getInstance();
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, s.getNaziv());
        ps.setString(2, s.getKontakt());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getLong(1);
        } else {
            throw new SQLException("Uf...");
        }

    }

    public static void createFL(FizickoLice fl) throws SQLException {

        Long genId = createS(new Sponzor(null, fl.getNaziv(), fl.getKontakt()));

        String query = "INSERT INTO ProjektovanjeSoftvera1.fizickoLice\n"
                + "(id, jmbg)\n"
                + "VALUES(?, ?)";
        Connection conn = DatabaseConnection.getInstance();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, genId);
        ps.setString(2, fl.getJmbg());
        ps.executeUpdate();

        ps.close();
    }

    public static void createPL(PravnoLice pl) throws SQLException {
        Long genId = createS(new Sponzor(null, pl.getNaziv(), pl.getKontakt()));

        String query = "INSERT INTO ProjektovanjeSoftvera1.pravnoLice\n"
                + "(id, regBr, pib)\n"
                + "VALUES(?, ?, ?)";
        Connection conn = DatabaseConnection.getInstance();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, genId);
        ps.setString(2, pl.getRegBr());
        ps.setString(3, pl.getPIB());
        ps.executeUpdate();
        
        ps.close();
    }
    
    // TODO: Update pravnog i fizickog lica (mnogo kucanja)
}
