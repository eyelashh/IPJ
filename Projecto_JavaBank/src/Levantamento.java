import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Levantamento extends Operacao implements Serializable{

	public Levantamento(int idOperacao, Funcionario responsavel, Date dataOperacao, double valor, String descricao) {
		super(idOperacao, responsavel, dataOperacao, valor,descricao);
		// TODO Auto-generated constructor stub
	}
 
	
	
}
