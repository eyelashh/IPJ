import java.io.Serializable;
import java.util.Date;

public class Deposito extends Operacao implements Serializable{

	public Deposito(int idOperacao, Funcionario responsavel, Date dataOperacao, double valor,String descricao) {
		super(idOperacao, responsavel, dataOperacao, valor, descricao);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
 