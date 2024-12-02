package kontroleri;

import domen.Clan;
import domen.Faktura;
import domen.Sponzor;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import broker.DatabaseConnection;
import domen.StavkaFakture;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author luka
 */
public class KontrolerFaktura {

    public static List<StavkaFakture> pronadjiStavke(Faktura f) throws SQLException {
        Long id = f.getId();
        List<StavkaFakture> lista = new LinkedList<>();

        String query = "SELECT * FROM stavkaFakture WHERE faktura=?";

        Connection conn = DatabaseConnection.getInstance();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(new StavkaFakture(
                    rs.getLong("id"),
                    KontrolerUsluga.getById(rs.getLong("usluga")), // Spojiti posle
                    rs.getInt("kolicina")
            ));

        }

        return lista;
    }

    public static List<Faktura> getList() throws SQLException {
        List<Faktura> lista = new LinkedList<>();
        Faktura temp;
        // Ucitavanje objekata od kojih faktura zavisi
        List<Sponzor> listaSponzora = KontrolerSponzor.getList();
        List<Clan> listaClanova = KontrolerClan.getList();

        String query = "SELECT * FROM faktura";

        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            temp = new Faktura(rs.getLong("id"),
                    rs.getDate("datum"),
                    rs.getDouble("ukupnaCena"),
                    rs.getDouble("pdv"),
                    rs.getBoolean("stornirana"),
                    null,
                    null,
                    rs.getDouble("popust")
            );

            // Pronalazenje i postavljanje stavki fakture
            temp.setListaStavkaFakture(KontrolerFaktura.pronadjiStavke(temp));

            Long clanid = rs.getLong("clan");
            Long sponzorid = rs.getLong("sponzor");

            // Optimizovati kasnije
            for (Clan c : listaClanova) {
                if (c.getId() == clanid) {
                    temp.setClan(c);
                    break;
                }
            }

            // SAMO ZA SVRHE TESTIRANJA!!!!
            // POTREBNO JE PROVERITI DA  LI JE SPONZOR FL ILI PL
            for (Sponzor s : listaSponzora) {
                if (s.getId() == sponzorid) {
                    temp.setSponzor(s);
                    break;
                }
            }

            lista.add(temp);

        }
        rs.close();
        st.close();
        conn.close();
        return lista;
    }

    public static void create(Faktura f) throws SQLException {
        String query = "INSERT INTO ProjektovanjeSoftvera1.faktura\n"
                + "(clan, sponzor, datum, ukupnaCena, pdv, popust, stornirana)\n"
                + "VALUES(?, ?, ?, ?, ?, ?, ?);";

        Connection conn = DatabaseConnection.getInstance();
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, f.getClan().getId());
        ps.setLong(2, f.getSponzor().getId());
        ps.setDate(3, (Date) f.getDatum());
        ps.setDouble(4, f.getOsnovnaCena());
        ps.setDouble(5, f.getPdv());
        ps.setDouble(6, f.getPopust());
        ps.setBoolean(7, false);

        System.out.println(ps);

        ps.executeUpdate();
        ResultSet rsPk = ps.getGeneratedKeys();
        Long pk;
        if(rsPk.next())
            pk = rsPk.getLong(1);
        else throw new SQLException("NESTO GADNO NIJE U REDU");

        query = "INSERT INTO ProjektovanjeSoftvera1.stavkaFakture\n"
                + "(id, faktura, kolicina, usluga)\n"
                + "VALUES(?, ?, ?, ?);";
        
        ps = conn.prepareStatement(query);

        // Ubaciti stavke vezane za fakturu
        List<StavkaFakture> lsf = f.getListaStavkaFakture();
        for (StavkaFakture sf : lsf) {
            ps.setLong(1, sf.getId());
            ps.setLong(2, pk);
            ps.setInt(3, sf.getKolicina());
            ps.setLong(4, sf.getUsluga().getId());
            System.out.println(ps);
            ps.executeUpdate();
        }

    }
}
