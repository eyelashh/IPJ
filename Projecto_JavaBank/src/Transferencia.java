import java.io.Serializable;
import java.util.Date;

public class Transferencia extends Operacao implements Serializable {

	private Conta contaDestino;
	
	public Transferencia(int idOperacao, Funcionario responsavel, Date dataOperacao, double valor,
			Conta contaDestino, String descricao) {
		super(idOperacao, responsavel, dataOperacao, valor, descricao);
		this.contaDestino = contaDestino;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}
	
	
	
	
	
	
}
