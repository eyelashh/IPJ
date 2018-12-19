import java.util.HashMap;

public class Carrinho {

	private int nif;
	private double montando;
	private boolean finalizado;
	private HashMap<Integer, Integer> compras;

	public Carrinho(int nif, double montando, boolean finalizado, HashMap<Integer, Integer> compras) {
		super();
		this.nif = nif;
		this.montando = montando;
		this.finalizado = finalizado;

		// hashMap(int idLivro, int quantidade)
		this.compras = new HashMap<Integer, Integer>();

	}

	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

	public double getMontando() {
		return montando;
	}

	public void setMontando(double montando) {
		this.montando = montando;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public HashMap<Integer, Integer> getCompras() {
		return compras;
	}

	public void setCompras(HashMap<Integer, Integer> compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Carrinho [nif=" + nif + ", montando=" + montando + ", finalizado=" + finalizado + ", compras=" + compras
				+ "]";
	}

}
