package modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.vo.Requerimiento_2Vo;

public class Requerimiento_2TableModel extends AbstractTableModel {

    private ArrayList<Requerimiento_2Vo> lista = new ArrayList<Requerimiento_2Vo>();
    private String[] columnNames = { "ID Proyecto", "Proveedor"};

    public Requerimiento_2TableModel(ArrayList<Requerimiento_2Vo> lista){
        this.lista = lista;
    }

    @Override
    public int getRowCount() {        
        return lista.size();
    }

    @Override
    public int getColumnCount() {        
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex){
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Requerimiento_2Vo req2 = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return req2.getID_Proyecto().toString();
            case 1:
                return req2.getProveedor();
        }
        
        return null;
    }

    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            }
            return null;
    }
}
