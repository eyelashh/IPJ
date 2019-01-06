import java.io.Serializable;
import java.util.Date;

public class Operacao implements Serializable{
	
	private int idOperacao;
	private Funcionario responsavel;
	private Date dataOperacao;
	private double valor;
	private String descricao;
	
	
	public Operacao(int idOperacao, Funcionario responsavel, Date dataOperacao, double valor,String descricao) {
		super();
		this.idOperacao = idOperacao;
		this.responsavel = responsavel;
		this.dataOperacao = dataOperacao;
		this.valor = valor;
		this.descricao = descricao;
	}
 

	
	
	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public int getIdOperacao() {
		return idOperacao;
	}


	public void setIdOperacao(int idOperacao) {
		this.idOperacao = idOperacao;
	}


	public Funcionario getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}


	public Date getDataOperacao() {
		return dataOperacao;
	}


	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
 

	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}




	@Override
	public String toString() {
		return "Operacao [idOperacao=" + idOperacao + ", responsavel=" + responsavel + ", dataOperacao=" + dataOperacao
				+ ", valor=" + valor + ", descricao=" + descricao + "]\n";
	}
	
	
	
	

}
