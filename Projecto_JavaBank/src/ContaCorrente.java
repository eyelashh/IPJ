import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente extends Conta implements Serializable{

	private Cartao cartao;

	public ContaCorrente(int idConta, Date dataCriacao, double saldo,
			ArrayList<Utilizador> clientes, double valorMaxLevantamento, double valorMaxDia, Cartao cartao) {
		super(idConta, dataCriacao, saldo, clientes, valorMaxLevantamento, valorMaxDia);
		this.cartao = cartao;
	}

	public Cartao getCartao() {
		return cartao;
	}
 
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	
	
	
	
	
}
