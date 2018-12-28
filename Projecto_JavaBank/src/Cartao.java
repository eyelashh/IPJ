import java.io.Serializable;
import java.time.LocalDate;

public class Cartao implements Serializable{

	private int nCartao;
	private String nomeTitular;
	private LocalDate dataValidade;
	private int codvalidacao;
	
	
	public Cartao() {
		super();
	}
 

	public Cartao(int nCartao, String nomeTitular, LocalDate dataValidade, int codvalidacao) {
		super();
		this.nCartao = nCartao;
		this.nomeTitular = nomeTitular;
		this.dataValidade = dataValidade;
		this.codvalidacao = codvalidacao;
	}


	public int getnCartao() {
		return nCartao;
	}


	public void setnCartao(int nCartao) {
		this.nCartao = nCartao;
	}


	public String getNomeTitular() {
		return nomeTitular;
	}


	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}


	public LocalDate getDataValidade() {
		return dataValidade;
	}


	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}


	public int getCodvalidacao() {
		return codvalidacao;
	}


	public void setCodvalidacao(int codvalidacao) {
		this.codvalidacao = codvalidacao;
	}
	
	
	
	
}
