import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CaixaCliente {
	public static void main(String[] args) {
		try {
            Registry registry = LocateRegistry.getRegistry("192.160.0.10", 1099);
            
            AdministracaoInterface adm = (AdministracaoInterface) registry.lookup("Administracao");
            
        	Scanner scanner = new Scanner(System.in);

        	while (true) {
            	System.out.println("Digite a opção desejada: ");
            	System.out.println("1 - Abrir conta");
            	System.out.println("2 - Realizar depósito");
            	System.out.println("3 - Realizar saque");
            	System.out.println("4 - Consultar saldo");
            	System.out.println("5 - Fechar conta");
            	System.out.println("6 - Abrir conta com ID");
            	System.out.println("7 - Realizar depósito com ID");
            	System.out.println("8 - Realizar saque com ID");
            	System.out.println("9 - Consultar saldo com ID");
            	System.out.println("10 - Fechar conta com ID");
            	System.out.println("11 - Buscar IDs de transações realizadas");
            	
            	System.out.println("Opção: ");
            	String opcao = scanner.nextLine();
        		String idTransacao = adm.gerarIdTransacao();
	
            	switch (opcao) {
            	case "1":
            		System.out.println(adm.criarConta(idTransacao));
            		
            		break;
            		
            	case "2": 
            		System.out.println("Digite o número da conta: ");
            		Integer numeroContaDeposito = scanner.nextInt();
            		
            		System.out.println("Digite a quantia: ");
            		Integer quantiaDeposito = scanner.nextInt();
            		
            		System.out.println(adm.deposito(numeroContaDeposito, quantiaDeposito, idTransacao));
            		
            		break;
            		
            	case "3":
            		System.out.println("Digite o número da conta: ");
            		Integer numeroContaSaque = scanner.nextInt();
            		
            		System.out.println("Digite a quantia: ");
            		Integer quantiaSaque = scanner.nextInt();
            		
            		System.out.println(adm.deposito(numeroContaSaque, quantiaSaque, idTransacao));
            		
            		break;
            		
            	case "4": 
            		System.out.println("Digite o número da conta: ");
            		Integer numeroContaSaldo = scanner.nextInt();
            		
            		System.out.println(adm.saldo(numeroContaSaldo, idTransacao));

            		break;
            		
            	case "5":
            		System.out.println("Digite o número da conta: ");
            		Integer numeroContaFechar = scanner.nextInt();
            		
            		System.out.println(adm.saldo(numeroContaFechar, idTransacao));
            		
            		break;
            		
            	case "6": 
            		System.out.println("Digite o ID da transação: ");
            		String idCriarConta = scanner.nextLine();
            		
            		System.out.println(adm.criarConta(idCriarConta));
            		break;
            		
            	case "7":
            		System.out.println("Digite o número da conta: ");
            		Integer numeroContaDepositoID = scanner.nextInt();
            		
            		System.out.println("Digite a quantia: ");
            		Integer quantiaDepositoID = scanner.nextInt();

            		System.out.println("Digite o ID da transação: ");
            		String idDepositoID = scanner.nextLine();
            		
            		System.out.println(adm.deposito(numeroContaDepositoID, quantiaDepositoID, idDepositoID));
            		
            		break;
            		
            	case "8": 
            		System.out.println("Digite o número da conta: ");
            		Integer numeroContaSaqueID = scanner.nextInt();
            		
            		System.out.println("Digite a quantia: ");
            		Integer quantiaSaqueID = scanner.nextInt();

            		System.out.println("Digite o ID da transação: ");
            		String idSaqueID = scanner.nextLine();
            		
            		System.out.println(adm.deposito(numeroContaSaqueID, quantiaSaqueID, idSaqueID));
            		
            		break;
            		
            	case "9":
            		System.out.println("Digite o número da conta: ");
            		Integer numeroContaSaldoID = scanner.nextInt();

            		System.out.println("Digite o ID da transação: ");
            		String idSaldoID = scanner.nextLine();
            		
            		System.out.println(adm.saldo(numeroContaSaldoID, idSaldoID));

            		break;
            		
            	case "10": 
            		System.out.println("Digite o número da conta: ");
            		Integer numeroContaFecharID = scanner.nextInt();

            		System.out.println("Digite o ID da transação: ");
            		String idFecharID = scanner.nextLine();
            		
            		System.out.println(adm.saldo(numeroContaFecharID, idFecharID));
            		
            		break;
            		
            	default:
            		System.out.println("Opção inválida.");
            	}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
