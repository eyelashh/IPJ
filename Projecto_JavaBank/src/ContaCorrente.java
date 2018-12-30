import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente extends Conta implements Serializable{

	private Cartao cartao;

	public ContaCorrente(int idConta, Date dataCriacao, double saldo, ArrayList<Operacao> operacoes,
			ArrayList<Cliente> clientes, double valorMaxLevantamento, double valorMaxDia, Cartao cartao) {
		super(idConta, dataCriacao, saldo, operacoes, clientes, valorMaxLevantamento, valorMaxDia);
		this.cartao = cartao;
	}

	public Cartao getCartao() {
		return cartao;
	}
 
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	
	
	
}
