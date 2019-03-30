package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6846181251493065529L;
	    
	   //private int id;
		private String usuario;
		private String message;
		
		private static List<Message> lstMessage = new ArrayList<Message>();
		
		public Message(String usuario, String message) {
			//this.id=id;
			this.usuario=usuario;
			this.message=message;
		}
		
		public Message(){}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public static List<Message> getLstMessage() {
			return lstMessage;
		}

		public static void setLstMessage(Message msg) {
			lstMessage.add(msg);
		}
		
		//public int getId() {
		//	return id;
		//}

		//public void setId(int id) {
		//	this.id = id;
		//}
		
		public int geraID(){
			int cdg=1;
			
			return cdg++;
		}
		
}
