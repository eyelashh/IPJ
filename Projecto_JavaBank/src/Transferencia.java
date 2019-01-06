import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Transferencia extends Operacao implements Serializable {

	private Conta contatransf;
	private Cliente clt;

	public Transferencia(int idOperacao, Funcionario responsavel, LocalDate dataOperacao, double valor, String descricao,
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

	public Cliente getClt() {
		return clt;
	}

	public void setClt(Cliente clt) {
		this.clt = clt;
	}

	@Override
	public String toString() {
		return "Transferencia [contatransf=" + contatransf + ", clt=" + clt + "]";
	}

}
