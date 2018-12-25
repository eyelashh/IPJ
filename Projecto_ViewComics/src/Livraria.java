import java.util.ArrayList;

public class Livraria {

	private int idLivraria;
	private String nome;
	private ArrayList<Utilizador> utilizadores;
	private ArrayList<Livro> livros;
	private ArrayList<Transacao> transacoes;
	private ArrayList<Sessao> sessoes;
	private ArrayList<Carrinho> carrinhos;

	public Livraria() {
		super();
		
	}
	
	public Livraria(int idLivraria, String nome) {
		super();
		this.idLivraria = idLivraria;
		this.nome = nome;
		this.utilizadores = new ArrayList<Utilizador>();
		this.livros = new ArrayList<Livro>();
		this.transacoes = new ArrayList<Transacao>();
		this.sessoes = new ArrayList<Sessao>();
		this.carrinhos = new ArrayList<Carrinho>();
	}

	public int getIdLivraria() {
		return idLivraria;
	}

	public void setIdLivraria(int idLivraria) {
		this.idLivraria = idLivraria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public void setUtilizadores(ArrayList<Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

	public ArrayList<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(ArrayList<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public ArrayList<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(ArrayList<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	public ArrayList<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public void setCarrinhos(ArrayList<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}

	@Override
	public String toString() {
		return "Livraria [idLivraria=" + idLivraria + ", nome=" + nome + ", utilizadores=" + utilizadores + ", livros="
				+ livros + ", transacoes=" + transacoes + ", sessoes=" + sessoes + ", carrinhos=" + carrinhos + "]";
	}

	public void addLivro(Livro l) {
		this.livros.add(l);
	}

	public void removeLivros(Livro l) {
		this.livros.remove(l);
	}

	public void addUtilizador(Utilizador u) {
		this.utilizadores.add(u);
	}

	public void removeUtilizador(Utilizador u) {
		this.utilizadores.remove(u);
	}

	public void addTransacao(Transacao t) {
		this.transacoes.add(t);
	}
	public void addCarrinho(Carrinho c) {
		this.carrinhos.add(c);
	}
	public void removeCarrinho(Carrinho c) {
		this.carrinhos.remove(c);
	}
	
}
