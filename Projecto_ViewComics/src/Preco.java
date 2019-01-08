import java.io.Serializable;
import java.time.LocalDate;

public class Preco implements  Serializable{
	
	private LocalDate data;
	private double preco;
	
	public Preco(double preco) {
		super();
		this.preco = preco;
		this.data=LocalDate.now();
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return   data + " | " + preco + "€";
	}
	

}
