package banco.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.Message;

public class DadosBanco {
	
	Connection con;
	PreparedStatement ps;
	
	public DadosBanco() {
		con = Conexao.getConnection();
	}
	
	public boolean inserir(Message msg)throws SQLException{

		try {
			 
			PreparedStatement stmt = this.con
					.prepareStatement("INSERT INTO TB_CHAT (usuario,mensagem) values ( ?, ?)");
            
			
			stmt.setString(1,msg.getUsuario());
			stmt.setString(2,msg.getMessage());
			
			stmt.execute();
			return true;
		
		}catch (SQLException e) {
			System.err.println(e.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			con.close();
		}
		return false;
	}

}
