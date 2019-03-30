package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dados.CNPJ;
import dados.CPF;
import dados.IServicoRemoto;


public class AppCliente {

	public static void main(String[] args) {
		
		try {
			
			IServicoRemoto objPessoa = (IServicoRemoto)Naming.lookup("rmi://localhost:8282/pessoa");
			
			CPF cpf = new CPF();
			
            cpf.setId(1);
			cpf.setNome("Carlos");
			cpf.setTelefone("(16) 9875-6532");
			cpf.setIdade(28);
			cpf.setEndereco("Av. Rio Branco");
			cpf.setCidade("Ribeirão Preto");
			cpf.setEstado("São Paulo");
			cpf.setSalario(1500);
			cpf.setNomePai("Paulo");
			cpf.setNomeMae("Alice");
			
			objPessoa.inserir(cpf);
			objPessoa.imprimir(cpf);
			
			CNPJ cnpj = new CNPJ();
			
			cnpj.setId(2);
			cnpj.setNome("Laura");
			cnpj.setTelefone("(16) 9903-1254");
			cnpj.setIdade(40);
			cnpj.setEndereco("Rua. Independente");
			cnpj.setCidade("Belo Horizonte");
			cnpj.setEstado("Minas Gerais");
			cnpj.setSalario(1700);
			cnpj.setNomePai("José");
			cnpj.setNomeMae("Claudia");
			
			objPessoa.inserir(cnpj);
			objPessoa.imprimir(cnpj);
			
		} catch (MalformedURLException e) {
			     e.printStackTrace();
		} catch (RemoteException e) {
			     e.printStackTrace();
		} catch (NotBoundException e) {
			     e.printStackTrace();
		}
	}

}
