import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdministracaoServidor {
	public static void main(String[] args) {
		try {
			AdministracaoInterface administracao = new Administracao();
            Registry registry = LocateRegistry.createRegistry(1099);
            
            registry.rebind("Administracao", administracao);
            System.out.println("Servidor pronto.");
		} catch (Exception e) {
            e.printStackTrace();
		}
	}
}
