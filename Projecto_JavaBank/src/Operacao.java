import java.time.LocalDate;

public class Operacao {
	
	private int idOperacao;
	private Funcionario responsavel;
	private LocalDate dataOperacao;
	private double valor;
	
	
	public Operacao(int idOperacao, Funcionario responsavel, LocalDate dataOperacao, double valor) {
		super();
		this.idOperacao = idOperacao;
		this.responsavel = responsavel;
		this.dataOperacao = dataOperacao;
		this.valor = valor;
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


	public LocalDate getDataOperacao() {
		return dataOperacao;
	}


	public void setDataOperacao(LocalDate dataOperacao) {
		this.dataOperacao = dataOperacao;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	

}
