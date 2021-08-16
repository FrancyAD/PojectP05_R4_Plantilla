package modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import org.sqlite.util.StringUtils;

import modelo.vo.Requerimiento_3Vo;

public class Requerimiento_3TableModel extends AbstractTableModel {

    private ArrayList<Requerimiento_3Vo> lista = new ArrayList<Requerimiento_3Vo>();
    private String[] columnNames = { "ID Proyecto", "Nombre Material"};

    public Requerimiento_3TableModel(ArrayList<Requerimiento_3Vo> lista){
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
        Requerimiento_3Vo req3 = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return req3.getId_Proyecto().toString();
            case 1:
                return req3.getNombre_Material();
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
