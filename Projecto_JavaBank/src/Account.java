import java.util.ArrayList;

/**
 * Breve descri��o do c�digo
 *
 * @sid 2013
 * @aid 1.1
 */

public class Account {

	private int n;
	private double balance;
	private ArrayList<Transaction> historicoOperacao;
	private Tipo tipoConta;
	
	public enum Tipo {
		AAA, SSSS, DDD
	}

	// historico de movimentos e transferencias
	
	public Account() {
		tipoConta = Tipo.aaa;
		
		if (tipoConta == Tipo.AAA)
	}

}
