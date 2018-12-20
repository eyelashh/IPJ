import java.time.LocalDate;
import java.util.ArrayList;

public class ContaPoupanca extends Conta {

	private double taxaJuros;
	private double limiteMensalDebito;
	
	
	public ContaPoupanca(int idConta, LocalDate dataCriacao, double saldo, ArrayList<Operacao> operacoes,
			ArrayList<Cliente> clientes, double valorMaxLevantamento, double valorMaxDia, double taxaJuros,
			double limiteMensalDebito) {
		super(idConta, dataCriacao, saldo, operacoes, clientes, valorMaxLevantamento, valorMaxDia);
		
		this.taxaJuros = taxaJuros;
		this.limiteMensalDebito = limiteMensalDebito;
	}
	
	 
	public double getTaxaJuros() {
		return taxaJuros;
	}
	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	public double getLimiteMensalDebito() {
		return limiteMensalDebito;
	}
	public void setLimiteMensalDebito(double limiteMensalDebito) {
		this.limiteMensalDebito = limiteMensalDebito;
	}
	
	
	
	
}
