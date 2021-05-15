package metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author EQUIPO 4 TPOO
 *
 */

public class ConexionSQL {

Connection cn;

/**
 * @param Conexion Este metodo crea nuestra conexion a la base de datos para realizar todas las consultas. 
 * @return Devuelve el metodo que crea las consultas.
 */
	
	public Connection conexion() 
	{
		
		try {
			
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/base_panaderiav2","root","54wbxmccim0AdV8c"); 
			//System.out.println("Conexion Exitosa");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return cn;
	
	}
	
	/**
	 * 
	 * @throws Lanza una excepcion en caso de que la conexion ha fallado
	 */
	
    public Connection Desconectar(){
        try{
        	
            cn.close();
            //System.out.println("Conexion cerrada");
        }catch(SQLException ex){
            
        }return cn;
    }
	
	
	
}
