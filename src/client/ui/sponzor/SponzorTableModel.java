package client.ui.sponzor;

import domen.Sponzor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luka
 */
public class SponzorTableModel extends AbstractTableModel {

    String[] cols = {"Šifra", "Naziv", "Kontakt"};

    
    private List<Sponzor> ls;

    public SponzorTableModel(List<Sponzor> ls) {
        this.ls = ls;

    }

    public void setLs(List<Sponzor> ls) {
        this.ls = ls;
    }
    
    @Override
    public String getColumnName(int index) {
        return cols[index];
    }

    @Override
    public int getRowCount() {
        return ls.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Sponzor s = ls.get(i);
        switch (i1) {
            case 0:
                return s.getId();
            case 1:
                return s.getNaziv();
            case 2:
                return s.getKontakt();
            default:
                throw new AssertionError();
        }
    }

}
