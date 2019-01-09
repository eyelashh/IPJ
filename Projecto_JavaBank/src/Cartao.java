import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Cartao implements Serializable {

	private int nCartao;
	private String nomeTitular;
	private Date dataValidade;
	private int codvalidacao;
	private int idconta;
	private boolean ativo;

	public Cartao() {
		super();
	}

	public Cartao(int nCartao, String nomeTitular, Date dataValidade, int codvalidacao, int idconta, boolean ativo) {
		super();
		this.nCartao = nCartao;
		this.nomeTitular = nomeTitular;
		this.dataValidade = dataValidade;
		this.codvalidacao = codvalidacao;
		this.idconta = idconta;
		this.ativo = ativo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getnCartao() {
		return nCartao;
	}

	public void setnCartao(int nCartao) {
		this.nCartao = nCartao;
	}

	public int getIdconta() {
		return idconta;
	}

	public void setIdconta(int idconta) {
		this.idconta = idconta;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public int getCodvalidacao() {
		return codvalidacao;
	}

	public void setCodvalidacao(int codvalidacao) {
		this.codvalidacao = codvalidacao;
	}
	

}
