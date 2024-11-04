import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdministracaoInterface extends Remote {
	public  String criarConta(String idTransacao) throws RemoteException;
	
	public String fecharConta(Integer index, String idTransacao) throws RemoteException;
	
	public String deposito(Integer numeroConta, Integer quantia, String idTransacao) throws RemoteException;

	public String saque(Integer numeroConta, Integer quantia, String idTransacao) throws RemoteException;

	public String saldo(Integer index, String idTransacao) throws RemoteException;
	
	public String gerarIdTransacao() throws RemoteException;
	
	public String getIdsTransacao() throws RemoteException;
}
