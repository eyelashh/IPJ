import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Conta implements Serializable{
	private int idConta;
	private LocalDate dataCriacao;
	private double saldo;
	private ArrayList <Operacao> operacoes;
	private ArrayList <Cliente> clientes;
	private double valorMaxLevantamento;
	private double valorMaxDia;
	
	public Conta() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public Conta(int idConta, LocalDate dataCriacao, double saldo, ArrayList<Operacao> operacoes,
			ArrayList<Cliente> clientes, double valorMaxLevantamento, double valorMaxDia) {
		super();
		this.idConta = idConta;
		this.dataCriacao = dataCriacao;
		this.saldo = saldo;
		this.operacoes = operacoes;
		this.clientes = clientes;
		this.valorMaxLevantamento = valorMaxLevantamento;
		this.valorMaxDia = valorMaxDia;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
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

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
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
