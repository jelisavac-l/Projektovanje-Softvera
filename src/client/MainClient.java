package client;

import client.domen.Clan;
import client.ui.Login;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClient {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Login().setVisible(true);
        
        
        try {
            List<Clan> lista = kontroleri.KontrolerClan.getList();
            for(Clan c : lista)
                System.out.println(c);
        } catch (SQLException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
    }
}
