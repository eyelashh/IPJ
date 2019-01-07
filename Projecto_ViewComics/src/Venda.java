import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Venda implements Serializable{
	
	private double montante;
	private static LocalDate data;
	private HashMap <Integer, Integer> conteudoVenda;//vai ser igual ao hashmap do carrinho quando o mesmo é pago
	
	
	
	public Venda(double montante, HashMap<Integer, Integer> conteudoVenda) {
		super();
		this.montante = montante;
		this.conteudoVenda = conteudoVenda;
		//confirmar se isto gera a data no momento!!!!
		this.data= data.now();
	}
	public double getMontante() {
		return montante;
	}
	public void setMontante(double montante) {
		this.montante = montante;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public HashMap<Integer, Integer> getConteudoVenda() {
		return conteudoVenda;
	}
	public void setConteudoVenda(HashMap<Integer, Integer> conteudoVenda) {
		this.conteudoVenda = conteudoVenda;
	}

}
