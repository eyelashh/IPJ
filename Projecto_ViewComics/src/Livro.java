import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class Livro implements  Serializable {

	private int idLivro;
	private String titulo;
	private String autor;
	private double preco;
	private int stock;
	private String descricao;
	private int ano;
	private int vendas;
	private ArrayList <Preco> precos; //para fins de historico de preços
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
		this.precos=new ArrayList <Preco> (); 
 
	}
	

	public int getVendas() {
		return vendas;
	}

	public void setVendas(int vendas) {
		this.vendas = vendas;
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

	public ArrayList<Preco> getPrecos() {
		return precos;
	}

	public void setPrecos(ArrayList<Preco> precos) {
		this.precos = precos;
	}
	public void addAlteracaoPreco(Preco p) {
		this.precos.add(p);
	}
	public void incrementarVendas(int quantidade) {
		this.vendas=this.vendas+quantidade;
	}

}
