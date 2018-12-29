import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

<<<<<<< HEAD
public class Carrinho implements  Serializable {
=======
public class Carrinho implements Serializable{
>>>>>>> 3ea67d82b688c95db771c172bd92334c7496bfa5

	private int nif;
	private double montante;
	private boolean finalizado;
	private HashMap<Integer, Integer> conteudo;

	public Carrinho() {
		super();
	}
	
	public Carrinho(int nif, double montante, boolean finalizado, HashMap<Integer, Integer> compras) {
		super();
		this.nif = nif;
		this.montante = montante;
		this.finalizado = finalizado;

		// hashMap(int idLivro, int quantidade)
		this.conteudo = new HashMap<Integer, Integer>();

	}
	//construtor com nif para criar automaticamente o carrinho assim que o cliente ou func insere o nif
	public Carrinho(int nif) {
		super();
		this.nif = nif;
	}

	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

	public double getMontante() {
		return montante;
	}

	public void setMontante(double montando) {
		this.montante = montando;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public HashMap<Integer, Integer> getConteudo() {
		return conteudo;
	}

	public void setConteudo(HashMap<Integer, Integer> conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return "Carrinho [nif=" + nif + ", montante=" + montante + ", finalizado=" + finalizado + ", conteudo="
				+ conteudo + "]";
	}
	
	

}
