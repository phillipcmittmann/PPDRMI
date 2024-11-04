import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CaixaInterface extends Remote {	
	public String deposito(Integer numeroConta, Integer quantia, String idTransacao) throws RemoteException;

	public String saque(Integer numeroConta, Integer quantia, String idTransacao) throws RemoteException;

	public String saldo(Integer index, String idTransacao) throws RemoteException;
	
	public String getIdsTransacao() throws RemoteException;
}