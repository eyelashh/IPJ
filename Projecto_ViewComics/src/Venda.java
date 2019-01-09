import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Venda implements Serializable{
	
	private static AtomicInteger aiVenda=new AtomicInteger(0);
	private int id;
	private String nif;
	private double montante;
	private static LocalDate data;
	private HashMap <Integer, Integer> conteudoVenda;//vai ser igual ao hashmap do carrinho quando o mesmo é pago
	
	
	public Venda(double montante, HashMap<Integer, Integer> conteudoVenda, String nif) {
		super();
		this.montante = montante;
		this.conteudoVenda = conteudoVenda;
		this.nif=nif;
		this.id=aiVenda.incrementAndGet();
		this.data= data.now();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
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
