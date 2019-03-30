package dados;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServicoRemoto extends Remote {

	void inserir (Pessoa ps) throws RemoteException;
	List<Pessoa> listarPessoa() throws RemoteException;
	float gerarAumento(Pessoa ps) throws RemoteException;
	void imprimir(Pessoa ps) throws RemoteException;

}
