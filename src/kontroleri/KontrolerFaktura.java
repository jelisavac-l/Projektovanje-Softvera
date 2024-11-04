package kontroleri;

import client.domen.Clan;
import client.domen.Faktura;
import client.domen.Sponzor;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import broker.DatabaseConnection;
import client.domen.StavkaFakture;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author luka
 */
public class KontrolerFaktura {
    public static List<StavkaFakture> pronadjiStavke(Faktura f) throws SQLException
    {
//        Long id = f.getId();
//        List<StavkaFakture> lista;
//        
//        String query = "SELECT * FROM stavkaFakture WHERE id=?";
//        
//        Connection conn = DatabaseConnection.getInstance();
//        PreparedStatement ps = conn.prepareStatement(query);
//        ps.setString(1, id.toString());
//        
//        
//        
//        
//        
//        return lista;
        throw new UnsupportedOperationException("Nije jos implementirano :(");
    }
            
    public static List<Faktura> getList() throws SQLException   
    {
        List<Faktura> lista = new LinkedList<>();
        Faktura temp;
        // Ucitavanje objekata od kojih faktura zavisi
        List<Sponzor> listaSponzora = KontrolerSponzor.getList();
        List<Clan> listaClanova = KontrolerClan.getList();
        
        String query = "SELECT * FROM faktura";
        
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()) {
            temp = new Faktura(rs.getLong("id"),
                    rs.getDate("datum"), 
                    rs.getDouble("ukupnaCena"),
                    rs.getDouble("pdv"),
                    rs.getBoolean("stornirana"), null, null);
            
            Long clanid = rs.getLong("clan");
            Long sponzorid = rs.getLong("sponzor");
            
            // Optimizovati kasnije
            for(Clan c : listaClanova)
                if(c.getId() == clanid) {
                    temp.setClan(c);
                    break;
                }
            
            // SAMO ZA SVRHE TESTIRANJA!!!!
            // POTREBNO JE PROVERITI DA  LI JE SPONZOR FL ILI PL
             
            for(Sponzor s : listaSponzora)
                if(s.getId() == sponzorid) {
                    temp.setSponzor(s);
                    break;
                }
            
            
            
            lista.add(temp);
            
        }
        rs.close();
        st.close();
        conn.close();
        return lista;
    }
}