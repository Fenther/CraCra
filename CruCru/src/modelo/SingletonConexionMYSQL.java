package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConexionMYSQL {
	
	private static int contador = 0;
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
    	} else if (con.isClosed()){
    		con = (Connection)DriverManager.getConnection(URL, USERNAME, PASSWORD);
    	}
    	} catch(ClassNotFoundException | SQLException ex){
    		ex.printStackTrace();
    	}
    	contador++;
    	return con;
    }
    
    public static void InstanceClose(){
    	try{
    		if (con != null && !con.isClosed()){
    			if(--contador == 0) con.close();
    		}
    	} catch(SQLException ex){
    		ex.printStackTrace();
    	}
    }
    
}
