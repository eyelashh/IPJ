import java.time.LocalDate;
import java.util.ArrayList;

public class ContaCorrente extends Conta {

	private Cartao cartao;

	public ContaCorrente(int idConta, LocalDate dataCriacao, double saldo, ArrayList<Operacao> operacoes,
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
