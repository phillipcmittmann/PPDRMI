import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Caixa extends UnicastRemoteObject implements CaixaInterface {
	private static final long serialVersionUID = -5138012313214124473L;

	private AdministracaoInterface administracao;
	
	public Caixa(String host) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(host, 1099);
            administracao = (AdministracaoInterface) registry.lookup("Administracao");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
