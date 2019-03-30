package util;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChatAula extends Remote {
	
	 void sendMessage(Message msg)throws RemoteException;
	 List<Message> retrieveMesage() throws RemoteException;
	 String nomeStart()throws RemoteException;
	 String recebeNome(String nome) throws RemoteException;
	 String mensagemStart(String nm)throws RemoteException;
	 boolean status() throws RemoteException;
	 boolean closeChat(String nome) throws RemoteException;
}
