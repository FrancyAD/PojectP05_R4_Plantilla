package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        // Su código

        Connection conex = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_2Vo> lista2 = new ArrayList<Requerimiento_2Vo>();
        boolean existe = false;
        
        String sql = "SELECT ID_Proyecto, Proveedor from Proyecto p2 natural join Compra c WHERE Ciudad ='Quibdo' ORDER by ID_Proyecto";
        
        try {
            
            PreparedStatement consulta = conex.prepareStatement(sql);
            ResultSet res = consulta.executeQuery();

            while (res.next()) {
                
                var proveedor = new Requerimiento_2Vo();
                existe = true;

                proveedor.setID_Proyecto(res.getInt("ID_Proyecto"));
                proveedor.setProveedor(res.getString("Proveedor"));
                
                lista2.add(proveedor);
            }

            res.close(); // cierra consulta
            conex.close(); // cierra conexion

        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos");
        }

        if (existe) {
            return lista2;
        } else {
            return null;
        }

    }
}