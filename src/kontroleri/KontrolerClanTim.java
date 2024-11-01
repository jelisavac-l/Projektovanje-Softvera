package kontroleri;

import broker.DatabaseConnection;
import client.domen.Clan;
import client.domen.ClanTim;
import client.domen.Tim;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author luka
 */
public class KontrolerClanTim {

    public static List<ClanTim> getList() throws SQLException {
        Clan c;
        Tim t;
        Date datumPocetka;
        List<ClanTim> lista = new LinkedList<>();
        // Rekao jedan mudar covek da svalim sav fizicki posao na bazu podataka pa:
        String query = "SELECT \n" 
                + "c.id AS 'idclan',\n"
                + "c.ime,\n"
                + "c.prezime,\n"
                + "c.korisnickoIme,\n"
                + "c.email,\n"
                + "c.telefon,\n"
                + "t.id AS 'idtim',\n"
                + "t.naziv,\n"
                + "ct.datumPocetka\n"
                + "FROM `clan-tim` ct JOIN clan c ON (ct.clan = c.id) JOIN tim t ON (ct.tim = t.id)";
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            c = new Clan(rs.getLong("idclan"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getString("korisnickoIme"),
                    null,
                    rs.getString("email"),
                    rs.getString("telefon"));
            t = new Tim(rs.getLong("idtim"),
                    rs.getString("naziv"));
            datumPocetka = rs.getDate("datumPocetka");
            lista.add(new ClanTim(c, t, datumPocetka));
        }

        rs.close();
        st.close();
        conn.close();
        return lista;
    }
}
