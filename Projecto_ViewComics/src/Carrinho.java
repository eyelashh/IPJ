import java.util.HashMap;

public class Carrinho {

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

	public HashMap<Integer, Integer> getCompras() {
		return conteudo;
	}

	public void setCompras(HashMap<Integer, Integer> compras) {
		this.conteudo = compras;
	}

	@Override
	public String toString() {
		return "Carrinho [nif=" + nif + ", montando=" + montante + ", finalizado=" + finalizado + ", compras=" + conteudo
				+ "]";
	}
	public void precoTotal() {
		
	}

}
