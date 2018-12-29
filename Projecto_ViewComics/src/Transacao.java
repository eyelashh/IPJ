import java.io.Serializable;
import java.time.LocalDate;

<<<<<<< HEAD
public class Transacao implements  Serializable {
=======
public class Transacao implements Serializable{
>>>>>>> 3ea67d82b688c95db771c172bd92334c7496bfa5

	private String tipoTrasacao;
	private LocalDate data;
	private boolean conclusao;
	private Carrinho cart;
	private Funcionario funcionario;

	public Transacao(String tipoTrasacao, LocalDate data, boolean conclusao, Carrinho cart, Funcionario funcionario) {
		super();
		this.tipoTrasacao = tipoTrasacao;
		this.data = data;
		this.conclusao = conclusao;

		this.cart = cart;
		this.funcionario = funcionario;
	}

	public String getTipoTrasacao() {
		return tipoTrasacao;
	}

	public void setTipoTrasacao(String tipoTrasacao) {
		this.tipoTrasacao = tipoTrasacao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public boolean isConclusao() {
		return conclusao;
	}

	public void setConclusao(boolean conclusao) {
		this.conclusao = conclusao;
	}

	public Carrinho getCart() {
		return cart;
	}

	public void setCart(Carrinho cart) {
		this.cart = cart;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Transacao [tipoTrasacao=" + tipoTrasacao + ", data=" + data + ", conclusao=" + conclusao + ", cart="
				+ cart + ", funcionario=" + funcionario + "]";
	}

}
