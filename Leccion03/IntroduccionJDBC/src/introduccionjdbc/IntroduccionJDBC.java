package introduccionjdbc;
import java.sql.*;

public class IntroduccionJDBC {

    public static void main(String[] args) {
        //Cadena de conexión de MySql, el parametro useSQL es opcional
        String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        //Cargamos el diver de mysql
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Creamos el objeto conexion 
            Connection conexion = (Connection) DriverManager.getConnection(url,"root","admin");
            //Creamos un objeto Statament
            Statement instruccion = conexion.createStatement();
            //Creamos el query
            String sql = "SELECT id_persona, nombre, apellido FROM persona";
            ResultSet result = instruccion.executeQuery(sql);
            while(result.next()){
                System.out.println("Id: " + result.getInt(1));
                System.out.println(" Nombre: " + result.getString(2));
                System.out.println(" Apellido: " + result.getString(3));
            }
            //Cerrar cada uno de los objetos utilizados
            result.close();
            instruccion.close();
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    
}
