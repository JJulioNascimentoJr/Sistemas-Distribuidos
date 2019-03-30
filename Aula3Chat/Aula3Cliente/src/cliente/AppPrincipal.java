package cliente;

import java.io.FileWriter;

import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import util.ChatAula;
import util.IChatAula;
import util.Message;
import banco.dados.DadosBanco;

public class AppPrincipal {
	
    private static String returnMessage(List<Message> lst){
		
		String valor = "";
		for (Message message : lst) {
			valor+= message.getUsuario()+ " : " + message.getMessage()+"\n";
		}
		
		return valor;
	}
	
    public static void main(String[] args) {
		
		try {
			
			ChatAula chat = new ChatAula();
			
			String name=chat.nomeStart();
			chat.recebeNome(name);
		    chat.status();
			String message;
		    
			do{
		         
			     message=chat.mensagemStart(name);
				 IChatAula objChat =(IChatAula)Naming.
						             lookup("rmi://localhost:8282/chat");
				 
				 Message msg = new Message(name,message);
				
				 objChat.sendMessage(msg);
				 System.out.println(returnMessage(objChat.retrieveMesage()));
				
			     new DadosBanco().inserir(msg);
			     FileWriter arq = new FileWriter("C://RegistroChat/conversa.txt",true);
			     PrintWriter gravarArq = new PrintWriter(arq);
			     
			       gravarArq.println(name+": "+message);
			       gravarArq.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			       gravarArq.println("");
			       gravarArq.flush();
			       gravarArq.close();
			     
			 }while(message.equals("")!=true);
			
		} catch (MalformedURLException e) {
			    e.printStackTrace();
		
		}catch (RemoteException e) {
			    e.printStackTrace();
		
		}catch (NotBoundException e) {
			    e.printStackTrace();
		
		}catch (Exception e) {
			   e.printStackTrace();
		}
	}

}
