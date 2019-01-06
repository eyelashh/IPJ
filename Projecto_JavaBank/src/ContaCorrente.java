import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente extends Conta implements Serializable{

	private int codcartao;

	public ContaCorrente(int idConta, Date dataCriacao, double saldo,
			ArrayList<Integer> clientes, double valorMaxLevantamento, double valorMaxDia, int codcartao,boolean aberta) {
		super(idConta, dataCriacao, saldo, clientes, valorMaxLevantamento, valorMaxDia, aberta);
		
		this.codcartao = codcartao;
	}

	public int getCartao() {
		return codcartao;
	}
 
	public void setCartao(int codcartao) {
		this.codcartao = codcartao;
	}
	
	
	
	
	
	
}
