import java.io.Serializable;
import java.util.Date;

public class Transferencia extends Operacao implements Serializable {

	private Conta contatransf;
	private Cliente clt;
	
	
	public Transferencia(int idOperacao, Funcionario responsavel, Date dataOperacao, double valor, String descricao,
			Conta contatransf, Cliente clt) {
		super(idOperacao, responsavel, dataOperacao, valor, descricao);
		this.contatransf = contatransf;
		this.clt = clt;
	}

	

	public Conta getcontatransf() {
		return contatransf;
	}

	public void setcontatransf(Conta contatransf) {
		this.contatransf = contatransf;
	}
	
	
	
	
	
	
}
