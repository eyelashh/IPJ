import java.time.LocalDate;

public class Transferencia extends Operacao {

	private Conta contaDestino;
	private Cliente titularTransf;
	
	public Transferencia(int idOperacao, Funcionario responsavel, LocalDate dataOperacao, double valor,
			Conta contaDestino, Cliente titularTransf) {
		super(idOperacao, responsavel, dataOperacao, valor);
		this.contaDestino = contaDestino;
		this.titularTransf = titularTransf;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}


	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}


	public Cliente getTitularTransf() {
		return titularTransf;
	}

	public void setTitularTransf(Cliente titularTransf) {
		this.titularTransf = titularTransf;
	}
	
	
	
	
	
	
}
