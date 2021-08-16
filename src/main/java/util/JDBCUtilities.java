/**
 * No se debe modificar
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    // private static final String DATABASE_LOCATION = "ProyectosConstruccion.db";
    private static final String DATABASE_LOCATION = "C:\\Users\\Asus\\Documents\\Mis Documentos\\Documentos\\Academia\\Programacion\\MisionTic\\Ciclo 2\\Retos\\Reto_U4\\PojectP05_R4_Plantilla\\ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + DATABASE_LOCATION;

        return DriverManager.getConnection(url);
    }
}
