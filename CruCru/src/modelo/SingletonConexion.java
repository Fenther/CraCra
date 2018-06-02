package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConexion {
	
	private static Connection con=null;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/Comisaria3?useSSL=false";
    private static final String USERNAME = "root";
    private static final String  PASSWORD = "root";
    
    public static Connection getInstance(){
    	try {
    	if (con == null){
    		Class.forName(DRIVER);
			con = (Connection)DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
    	}
    	} catch(ClassNotFoundException | SQLException ex){
    		ex.printStackTrace();
    	}
    	return con;
    }
    
}
