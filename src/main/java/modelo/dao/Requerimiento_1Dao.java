package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {

    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
        // Su código
        Connection conex = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_1Vo> lista = new ArrayList<Requerimiento_1Vo>();
        boolean existe = false;
        
        String sql = "SELECT Ciudad_Residencia, AVG(Salario) AS Promedio FROM Lider l group by Ciudad_Residencia HAVING AVG(Salario)<600000 ORDER by AVG(Salario) DESC";
        
        try {
            
            PreparedStatement consulta = conex.prepareStatement(sql);
            ResultSet res = consulta.executeQuery();

            while (res.next()) {
                
                var lider = new Requerimiento_1Vo();
                existe = true;

                lider.setCiudad_Residencia(res.getString("Ciudad_Residencia"));
                lider.setSalario((int)Math.round(res.getDouble("Promedio")));
                
                lista.add(lider);
            }

            res.close(); // cierra consulta
            conex.close(); // cierra conexion

        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos");
        }

        if (existe) {
            return lista;
        } else {
            return null;
        }

    }
}