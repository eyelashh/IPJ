import java.io.Serializable;
import java.util.Date;

public class Transferencia extends Operacao implements Serializable {

	private Conta contatransf;
	
	public Transferencia(int idOperacao, Funcionario responsavel, Date dataOperacao, double valor,
			Conta contaDestino, String descricao) {
		super(idOperacao, responsavel, dataOperacao, valor, descricao);
		this.contatransf = contaDestino;
	}

	public Conta getcontatransf() {
		return contatransf;
	}

	public void setcontatransf(Conta contatransf) {
		this.contatransf = contatransf;
	}
	
	
	
	
	
	
}
