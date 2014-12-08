/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lat1.objek.model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lat1.objek.entity.Siswa;
/**
 *
 * @author acusgazerock
 */
public class TabelSiswa extends AbstractTableModel {
    List<Siswa> list = new ArrayList<Siswa>();

    public TabelSiswa(List list) {
        this.list=list;
    }


    public int getRowCount() {
        return this.list.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNis();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getAlamat();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nis";
            case 1:
                return "Nama";
            case 2:
                return "Alamat";
            default:
                return null;
        }
    }
}
