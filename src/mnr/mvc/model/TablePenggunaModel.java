/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mnr.mvc.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import mnr.mvc.entity.Pengguna;

/**
 *
 * @author KinetaNaraPutriniar
 */
public class TablePenggunaModel extends AbstractTableModel{
    
    private static final long serialVersionUID = -4126490061056267691L;
    private List<Pengguna> list = new ArrayList<Pengguna>();
    
    public void setList(List<Pengguna> list) {
        this.list = list;
    }
    
    public Pengguna set(int index, Pengguna element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }
    
    public Pengguna remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
    public Pengguna get(int index) {
        return list.get(index);
    }
    
    public boolean add(Pengguna e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Nama Depan";
            case 2:
                return "Nama Belakang";
            case 3:
                return "Telepon";
            case 4:
                return "Email";
            default:
                return null;
        }
    }
    
    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 5;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNamaDepan();
            case 2:
                return list.get(rowIndex).getNamaBelakang();
            case 3:
                return list.get(rowIndex).getTelepon();
            case 4:
                return list.get(rowIndex).getEmail();
            default:
                return null;
        }
    }
}
