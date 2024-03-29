package capadatos.pool;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Erika
 */
public class PoolConexionesOracle {
    
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUsername("hr");
        ds.setPassword("hr");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        //Definimos el tamano del pool de conexiones
        ds.setInitialSize(5);//5 Conexiones iniciales
        return ds;
    }
    
    public static Connection getConexion() throws SQLException{
        return getDataSource().getConnection();
    }
}
