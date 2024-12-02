package client.ui.faktura;

import client.domen.StavkaFakture;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luka
 */
public class StavkaFaktureTableModel extends AbstractTableModel{

    String[] cols = {"RBR", "Usluga", "Količina", "Jed. cena", "Σ"};
    private List<StavkaFakture> lsf;

    public StavkaFaktureTableModel(List<StavkaFakture> lsf) {
        this.lsf = lsf;
    }
    
    public void load(List<StavkaFakture> lsf) {
        this.lsf = lsf;
    }
    
    @Override
    public String getColumnName(int index) {
        return cols[index];
    }
    
    
    @Override
    public int getRowCount() {
        return lsf.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        StavkaFakture sf = lsf.get(i);
        switch(i1)
        {
            case 0: return sf.getId();
            case 1: return sf.getUsluga().getNaziv();
            case 2: return sf.getKolicina();
            case 3: return sf.getUsluga().getCena(); 
            case 4: return sf.getUsluga().getCena() * sf.getKolicina();
        }
        return -1;
    }
    
}
