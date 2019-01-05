import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Cartao implements Serializable{

	private String nomeTitular;
	private Date dataValidade;
	private int codvalidacao;
	private int idconta;
	
	
	public Cartao() {
		super();
	}
 

	public Cartao(int nCartao, String nomeTitular, Date dataValidade, int codvalidacao, int idconta) {
		super();
		this.nomeTitular = nomeTitular;
		this.dataValidade = dataValidade;
		this.codvalidacao = codvalidacao;
		this.idconta = idconta;
		
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
