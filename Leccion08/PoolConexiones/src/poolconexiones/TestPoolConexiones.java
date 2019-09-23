package poolconexiones;

import capadatos.pool.PoolConexionesMysql;
import capadatos.pool.PoolConexionesOracle;
import java.sql.*;
/**
 *
 * @author Erika
 */
public class TestPoolConexiones {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            //Probamos el pool de MySql
            //y ejecutamos una cunsulta
            conn = PoolConexionesMysql.getConexion();
            System.out.println("Utilizamos el pool de conexiones de MySql");
            stmt = conn.prepareStatement("SELECT * FROM persona");
            rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(" " + rs.getInt(1));//id_persona
                System.out.println(" " + rs.getString(2));//nombre
                System.out.println(" " + rs.getString(3));//apellido
            }
            conn.close();
            //Probamos el pool de Oracle
            //y ejecutamos una consulta
            conn = PoolConexionesOracle.getConexion();
            System.out.println("Utilizamo el pool de conexiones de Oracle");
            stmt = conn.prepareStatement("SELECT * FROM employees WHERE employee_id in(100,101,102)");
            rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(" " + rs.getInt(1));//empleado_id
                System.out.println(" " + rs.getString(2));//nombre
                System.out.println(" " + rs.getString(3));//apellido
            }
            //cerramos la conexion para regresarla al pool
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}