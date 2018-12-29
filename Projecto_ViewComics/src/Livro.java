import java.io.Serializable;

public class Livro implements Serializable{

	private int idLivro;
	private String titulo;
	private String autor;
	private double preco;
	private int stock;

	public Livro(int idLivro, String titulo, String autor, double preco, int stock) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.stock = stock;

	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", titulo=" + titulo + ", autor=" + autor + ", preco=" + preco + ", stock="
				+ stock + "]";
	}

}
