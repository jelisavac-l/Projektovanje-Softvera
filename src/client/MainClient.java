package client;
import client.domen.Clan;
import client.domen.ClanTim;
import client.domen.Faktura;
import client.domen.Sponzor;
import client.domen.Tim;
import client.domen.Usluga;
import client.ui.Login;
import client.ui.clan.FormClan;
import client.ui.tim.FormTim;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroleri.*;

public class MainClient {
    public static void main(String[] args) {
        try {
            FlatMacLightLaf.setup();
            new FormTim().setVisible(true);
            
            List<Faktura> lf = KontrolerFaktura.getList();
            List<Clan> lc = KontrolerClanTim.getClanoviTima(new Tim(1L, null, null));
            List<ClanTim> lct = KontrolerClanTim.getList();
            List<Tim> lt = KontrolerTim.getList();
            List<Sponzor> ls = KontrolerSponzor.getList();
            List<Usluga> lu = KontrolerUsluga.getList();
            //KontrolerClan.update(lc.get(2), lc.get(3));
            for(Clan c : lc) {
                System.out.println(c.getIme() + " " + c.getPrezime());
            }
            
            
            
            if(lc == null || lct == null || lt == null || ls == null || lu == null || lf == null)
                System.out.println("Ne radi nest");
            else System.out.println("Sve radi!");
        } catch (SQLException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
    }
}
