import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class ContaPoupanca extends Conta implements Serializable {

	private double taxaJuros;
	private double limiteMensalDebito;
	private Date pagajuros;

	public ContaPoupanca(int idConta, Date dataCriacao, Date dataFecho, double saldo, ArrayList<Integer> clientes,
			double valorMaxLevantamento, double valorMaxDia, double taxaJuros, double limiteMensalDebito,
			boolean aberta) {
		super(idConta, dataCriacao, dataFecho, saldo, clientes, valorMaxLevantamento, valorMaxDia, aberta);

		this.taxaJuros = taxaJuros;
		this.limiteMensalDebito = limiteMensalDebito;
		
		// cria data de pagamento de juros:
		// 1 ano;
		Calendar c = Calendar.getInstance();
		c.setTime(dataCriacao);
		c.add(Calendar.YEAR, 1);
		pagajuros = c.getTime();
	
		
		
	}

	
	
	public Date getPagajuros() {
		return pagajuros;
	}

	public void setPagajuros(Date pagajuros) {
		this.pagajuros = pagajuros;
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
