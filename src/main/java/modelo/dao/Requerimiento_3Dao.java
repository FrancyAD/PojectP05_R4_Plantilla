package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {

        Connection conex = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_3Vo> lista3 = new ArrayList<Requerimiento_3Vo>();
        boolean existe = false;
        
        String sql = "SELECT ID_Proyecto, Nombre_Material FROM Compra c Natural Join MaterialConstruccion mc WHERE ID_Proyecto BETWEEN 5 and 15 order by ID_Proyecto";
        
        try {
            
            PreparedStatement consulta = conex.prepareStatement(sql);
            ResultSet res = consulta.executeQuery();

            while (res.next()) {
                
                var proyecto = new Requerimiento_3Vo();
                existe = true;

                proyecto.setId_Proyecto(res.getInt("ID_Proyecto"));
                proyecto.setNombre_Material(res.getString("Nombre_Material"));
                
                lista3.add(proyecto);
            }

            res.close(); // cierra consulta
            conex.close(); // cierra conexion

        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos");
        }

        if (existe) {
            return lista3;
        } else {
            return null;
        }
        
    }
}