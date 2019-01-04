import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Conta implements Serializable{
	private int idConta;
	private Date dataCriacao;
	private double saldo;
	private ArrayList <Operacao> operacoes;
	private ArrayList <Utilizador> clientes;
	private double valorMaxLevantamento;
	private double valorMaxDia;
	
	public Conta() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public Conta(int idConta, Date dataCriacao, double saldo,
			ArrayList<Utilizador> clientes, double valorMaxLevantamento, double valorMaxDia) {
		super();
		this.idConta = idConta;
		this.dataCriacao = dataCriacao;
		this.saldo = saldo;
		this.valorMaxLevantamento = valorMaxLevantamento;
		this.valorMaxDia = valorMaxDia;
		operacoes = new ArrayList <Operacao>();
		this.clientes = clientes;
		
	}

	

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Operacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(ArrayList<Operacao> operacoes) {
		this.operacoes = operacoes;
	}

	public ArrayList<Utilizador> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Utilizador> clientes) {
		this.clientes = clientes;
	}

	public double getValorMaxLevantamento() {
		return valorMaxLevantamento;
	}

	public void setValorMaxLevantamento(double valorMaxLevantamento) {
		this.valorMaxLevantamento = valorMaxLevantamento;
	}

	public double getValorMaxDia() {
		return valorMaxDia;
	}

	public void setValorMaxDia(double valorMaxDia) {
		this.valorMaxDia = valorMaxDia;
	}
	
	
	
	
	

}
