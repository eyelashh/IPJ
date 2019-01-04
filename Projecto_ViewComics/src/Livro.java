import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;


public class Livro implements  Serializable {

	private int idLivro;
	private String titulo;
	private String autor;
	private double preco;
	private int stock;
	private String descricao;
	private int ano;
	private static AtomicInteger ai=new AtomicInteger(0);
	
	public Livro() {
		super();
		this.idLivro = ai.incrementAndGet();
		
 
	}

	public Livro(String titulo, String autor, double preco, int stock, int ano,String descricao) {
		super();
		this.idLivro = ai.incrementAndGet();
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.stock = stock;
		this.ano =ano;
		this.descricao=descricao;
 
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return idLivro + " | " + titulo + ", de "+autor ;
	}

}
