package dados;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServicoRemotoImpl extends UnicastRemoteObject implements IServicoRemoto {
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8098453374405475584L;
	
	private static List<Pessoa> lstPessoa = new ArrayList<>();
	
	public ServicoRemotoImpl() throws RemoteException {
		
	}
	
	@Override
    public void inserir(Pessoa ps) throws RemoteException{
    	lstPessoa.add(ps);
    }
	
	@Override
	public List<Pessoa> listarPessoa() throws RemoteException{
		return lstPessoa;
	}
    
	@Override
	public float gerarAumento(Pessoa ps)throws RemoteException{
		 float ajuste=0;
		
		 if(ps.getIdade()>0 && ps.getIdade()<=20){
			ajuste=(ps.getSalario()*10)/100; 
		 }else{
			 if(ps.getIdade()>=20 || ps.getIdade()<=30){
				 ajuste=(ps.getSalario()*15)/100;
			 }else{
				 if(ps.getIdade()>30){
					 ajuste=(ps.getSalario()*20)/100;
				 }
			 }
		 }
		 
		 return ajuste;
	}
	
	@Override
	public void imprimir(Pessoa ps)throws RemoteException{
		for ( Pessoa pessoa : listarPessoa()) {
			 System.out.println("Id: "+pessoa.getId());
			 System.out.println("Nome: "+pessoa.getNome());
			 System.out.println("Telefone: "+pessoa.getTelefone());
			 System.out.println("Idade: "+pessoa.getIdade());
			 System.out.println("Endere�o: "+pessoa.getEndereco());
			 System.out.println("Cidade: "+pessoa.getCidade());
			 System.out.println("Estado: "+pessoa.getEstado());
			 System.out.println("Salario Atual: "+pessoa.getSalario());
			 System.out.println("Salario com Rejuste: "+(pessoa.getSalario()+gerarAumento(ps)));
			 System.out.println("Nome do Pai: "+pessoa.getNomePai());
			 System.out.println("Nome do M�e: "+pessoa.getNomeMae());
			 System.out.println("\n");
		}
	}
     
}
