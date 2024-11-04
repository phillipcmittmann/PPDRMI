import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

class Conta {
	private Integer saldo;
	private String numeroConta;
		
	public Conta(String numeroConta) {
		this.saldo = 0;
		this.numeroConta = numeroConta;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	
	public String getNumeroConta() {
		return this.numeroConta;
	}
}

public class Administracao extends UnicastRemoteObject implements AdministracaoInterface {
	private static final long serialVersionUID = -513804057617910473L;

	private ArrayList<Conta> contas;
	private Integer numeroContasCriadas;
    private Set<String> transacoesProcessadas;

	public Administracao() throws RemoteException {
		this.contas = new ArrayList<Conta>();
		this.numeroContasCriadas = 0;
		this.transacoesProcessadas = new HashSet<>();
	}
	
	public synchronized String criarConta(String idTransacao) throws RemoteException {
		if (this.transacoesProcessadas.contains(idTransacao)) {
            return "Transação já processada: " + idTransacao;
        } else {
        	numeroContasCriadas++;
    		contas.add(new Conta(numeroContasCriadas.toString()));
    		return "Numero da conta: " + numeroContasCriadas;
        }
	}
	
	public synchronized String fecharConta(Integer numeroConta, String idTransacao) throws RemoteException {
		if (this.transacoesProcessadas.contains(idTransacao)) {
            return "Transação já processada: " + idTransacao;
        } else {
        	contas.remove(numeroConta-1);
    		
    		return "Conta " + numeroConta + "fechada.";
        }
	}
	
	public synchronized String deposito(Integer numeroConta, Integer quantia, String idTransacao) throws RemoteException {
		if (this.transacoesProcessadas.contains(idTransacao)) {
            return "Transação já processada: " + idTransacao;
        } else {
        	this.contas.get(numeroConta-1).setSaldo(this.contas.get(numeroConta-1).getSaldo() + quantia);
    		
    		return "Depositado " + quantia + "na conta " + (numeroConta-1);
        }
	}
	
	public synchronized String saque(Integer numeroConta, Integer quantia, String idTransacao) throws RemoteException {
		if (this.transacoesProcessadas.contains(idTransacao)) {
            return "Transação já processada: " + idTransacao;
        } else {
        	this.contas.get(numeroConta-1).setSaldo(this.contas.get(numeroConta-1).getSaldo() - quantia);
    		
    		return "Sacada " + quantia + "na conta " + (numeroConta-1);	
        }
	}
	
	public synchronized String saldo(Integer numeroConta, String idTransacao) throws RemoteException {
		if (this.transacoesProcessadas.contains(idTransacao)) {
            return "Transação já processada: " + idTransacao;
        } else {
    		return "Saldo da conta " + numeroConta + " é " + this.contas.get(numeroConta-1).getSaldo();    	
        }
	}
	
	public synchronized String gerarIdTransacao() {
        return UUID.randomUUID().toString();
    }
	
	public synchronized String getIdsTransacao() {
		return this.transacoesProcessadas.toString();
	}
}
