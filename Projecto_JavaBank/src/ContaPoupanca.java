import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ContaPoupanca extends Conta implements Serializable {

	private double taxaJuros;
	private double limiteMensalDebito;

	public ContaPoupanca(int idConta, Date dataCriacao, double saldo, ArrayList<Integer> clientes,
			double valorMaxLevantamento, double valorMaxDia, double taxaJuros, double limiteMensalDebito,boolean aberta) {
		super(idConta, dataCriacao, saldo, clientes, valorMaxLevantamento, valorMaxDia, aberta);

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
