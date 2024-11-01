package client;
import client.domen.Clan;
import client.domen.ClanTim;
import client.domen.Faktura;
import client.domen.Sponzor;
import client.domen.Tim;
import client.domen.Usluga;
import client.ui.Login;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroleri.*;

public class MainClient {
    public static void main(String[] args) {
        try {
            FlatLightLaf.setup();
            new Login().setVisible(true);
            
            List<Faktura> lf = KontrolerFaktura.getList();
            List<Clan> lc = KontrolerClan.getList();
            List<ClanTim> lct = KontrolerClanTim.getList();
            List<Tim> lt = KontrolerTim.getList();
            List<Sponzor> ls = KontrolerSponzor.getList();
            List<Usluga> lu = KontrolerUsluga.getList();
            
            
            if(lc == null || lct == null || lt == null || ls == null || lu == null || lf == null)
                System.out.println("Ne radi nest");
            else System.out.println("Sve radi!");
        } catch (SQLException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
    }
}
