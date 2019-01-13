import java.io.Serializable;
import java.util.Date;

public class Pagamento extends Operacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pagamento(int idOperacao, Date dataOperacao, double valor, String descricao) {
		super(idOperacao, null, dataOperacao, valor, descricao);
		// TODO Auto-generated constructor stub
	}
	
	

}
