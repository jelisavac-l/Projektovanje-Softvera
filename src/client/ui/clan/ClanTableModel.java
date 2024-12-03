package client.ui.clan;

import domen.Clan;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author luka
 */
public class ClanTableModel extends AbstractTableModel {
    
    private String[] cols = {"Šifra", "Ime", "Prezime", "Kor. ime", "Email", "Telefon"};
    private List<Clan> lc;

    public ClanTableModel(List<Clan> lc) {
        this.lc = lc;
    }
    
    public Clan getRowValue(int row) {
        return lc.get(row);
    }
    
    @Override
    public String getColumnName(int index) {
        return cols[index];
    }
    
    @Override
    public int getRowCount() {
        return lc.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Clan c = lc.get(i);
        switch(i1) {
            case 0: return c.getId();
            case 1: return c.getIme();
            case 2: return c.getPrezime();
            case 3: return c.getKorisnickoIme();
            case 4: return c.getEmail();
            case 5: return c.getTelefon();
        }
        return -1;
    }
    
}
