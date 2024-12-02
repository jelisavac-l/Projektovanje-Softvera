package client.ui.faktura;

import domen.Faktura;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luka
 */
public class FakturaTableModel extends AbstractTableModel {
    String[] cols = {"Šifra", "Sponzor", "Datum", "Cena", "Porez", "Izdao"};
    private List<Faktura> lf;

    
    public FakturaTableModel(List<Faktura> lf) {
        this.lf = lf;
    }
    
    public void setList(List<Faktura> lf) {
        this.lf = lf;
    }
    
    @Override
    public String getColumnName(int index) {
        return cols[index];
    }
    
    
    @Override
    public int getRowCount() {
        return lf.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Faktura f = lf.get(i);
        // Sifra, sponzor, datum, cena, porez, izdao
        switch(i1) {
            case 0: return f.getId();
            case 1: return f.getSponzor();
            case 2: return f.getDatum();
            case 3: return f.getOsnovnaCena();
            case 4: return f.getPdv();
            case 5: return f.getClan();
        }
        return -1;
    }
    
    public Faktura getFromRow(int i)
    {
        return lf.get(i);
    }
    
}
