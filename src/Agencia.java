import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Agencia extends UnicastRemoteObject implements AgenciaInterface {
	private static final long serialVersionUID = -5138040513214124473L;

	private AdministracaoInterface administracao;
	
	public Agencia(String host) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(host, 1099);
            administracao = (AdministracaoInterface) registry.lookup("Administracao");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public String criarConta(String idTransacao) throws RemoteException {
		return this.administracao.criarConta(idTransacao);
	}
	
	public String fecharConta(Integer numeroConta, String idTransacao) throws RemoteException {
		return this.administracao.fecharConta(numeroConta, idTransacao);
	}
	
	public String deposito(Integer numeroConta, Integer quantia, String idTransacao) throws RemoteException {
		return this.administracao.deposito(numeroConta, quantia, idTransacao);
	}
	
	public String saque(Integer numeroConta, Integer quantia, String idTransacao) throws RemoteException {
		return this.administracao.saque(numeroConta, quantia, idTransacao);
	}
	
	public String saldo(Integer numeroConta, String idTransacao) throws RemoteException {
		return this.administracao.saldo(numeroConta, idTransacao);
	}
	
	public String getIdsTransacao() throws RemoteException {
		return this.administracao.getIdsTransacao();
	}
}
