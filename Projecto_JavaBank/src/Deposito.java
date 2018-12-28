import java.io.Serializable;
import java.time.LocalDate;

public class Deposito extends Operacao implements Serializable{

	public Deposito(int idOperacao, Funcionario responsavel, LocalDate dataOperacao, double valor) {
		super(idOperacao, responsavel, dataOperacao, valor);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
 