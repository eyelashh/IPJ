import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Conta implements Serializable {
	private int idConta;
	private Date dataCriacao;
	private Date dataFecho;
	private double saldo;
	private ArrayList<Operacao> operacoes;
	private ArrayList<Integer> clientes;
	private double valorMaxLevantamento;
	private double valorMaxDia;
	private boolean aberta = true;

	public Conta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conta(int idConta, Date dataCriacao, Date dataFecho, double saldo, ArrayList<Integer> clientes,
			double valorMaxLevantamento, double valorMaxDia, boolean aberta) {
		super();

		this.idConta = idConta;
		this.dataCriacao = dataCriacao;
		this.dataFecho = dataFecho;
		this.saldo = saldo;
		this.valorMaxLevantamento = valorMaxLevantamento;
		this.valorMaxDia = valorMaxDia;
		operacoes = new ArrayList<Operacao>();
		this.clientes = clientes;
		this.aberta = aberta;

	}

	public Date getDataFecho() {
		return dataFecho;
	}

	public void setDataFecho(Date dataFecho) {
		this.dataFecho = dataFecho;
	}

	public boolean isAberta() {
		return aberta;
	}

	public void setAberta(boolean aberta) {
		this.aberta = aberta;
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

	public ArrayList<Integer> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Integer> clientes) {
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
