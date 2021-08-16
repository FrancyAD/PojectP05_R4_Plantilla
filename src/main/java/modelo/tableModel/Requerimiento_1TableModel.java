package modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.vo.Requerimiento_1Vo;

public class Requerimiento_1TableModel extends AbstractTableModel {

    private ArrayList<Requerimiento_1Vo> lista = new ArrayList<Requerimiento_1Vo>();
    private String[] columnNames = { "Ciudad", "Promedio"};

    public Requerimiento_1TableModel(ArrayList<Requerimiento_1Vo> lista){
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
        Requerimiento_1Vo req1 = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return req1.getCiudad_Residencia();
            case 1:
                return " $  " + req1.getSalario();
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
