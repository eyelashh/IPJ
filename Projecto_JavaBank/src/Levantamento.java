import java.io.Serializable;
import java.time.LocalDate;

public class Levantamento extends Operacao implements Serializable{

	public Levantamento(int idOperacao, Funcionario responsavel, LocalDate dataOperacao, double valor) {
		super(idOperacao, responsavel, dataOperacao, valor);
		// TODO Auto-generated constructor stub
	}
 
	
	
}
