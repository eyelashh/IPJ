import java.util.HashMap;

public class Carrinho {

	private int nif;
	private double montante;
	private boolean finalizado;
	private HashMap<Livro, Integer> conteudo;

	public Carrinho() {
		super();
	}
	
	public Carrinho(int nif, double montante, boolean finalizado, HashMap<Integer, Integer> compras) {
		super();
		this.nif = nif;
		this.montante = montante;
		this.finalizado = finalizado;

		// hashMap(int idLivro, int quantidade)
		this.conteudo = new HashMap<Livro, Integer>();

	}

	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

	public double getMontando() {
		return montante;
	}

	public void setMontando(double montando) {
		this.montante = montando;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public HashMap<Livro, Integer> getCompras() {
		return conteudo;
	}

	public void setCompras(HashMap<Livro, Integer> compras) {
		this.conteudo = compras;
	}

	@Override
	public String toString() {
		return "Carrinho [nif=" + nif + ", montando=" + montante + ", finalizado=" + finalizado + ", compras=" + conteudo
				+ "]";
	}

}
