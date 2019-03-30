package banco.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	static String status="";
    

	public static Connection getConnection(){
	  Connection conn=null;
	   try{
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String url = "jdbc:mysql://localhost/bancoChat?user=root&password=jr";
	      conn = DriverManager.getConnection(url);
	      status = "OK! Conexao aberta...";
	   }
	   catch (SQLException e){
	       status = e.getMessage();
	   }
	   catch(ClassNotFoundException e){
	      status = e.getMessage();
	   }catch(Exception e){
	      status = e.getMessage();
	   }
	    return conn;
	 }
}
