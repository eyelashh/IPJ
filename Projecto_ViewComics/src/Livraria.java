import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
		this.utilizadores = new ArrayList<Utilizador>();
		this.livros = new ArrayList<Livro>();
		this.transacoes = new ArrayList<Transacao>();
		this.sessoes = new ArrayList<Sessao>();
		this.carrinhos = new ArrayList<Carrinho>();
		
		
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

	// adiciona utilizadores
	public void addUtilizador(Utilizador u) {
		this.utilizadores.add(u);
	}

	// remove utilizadores
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
	//metodo para obter o preco de um livro atraves do seu id, �til para calcular o preco de um carrinho
	public double precoLivro(int id) {
		
		double preco=0;
		//procura no array de livros se o id do livro existe, se sim retorna o pre�o da uma unidade do livro
		for (Livro l : this.livros) {
			if (l.getIdLivro()==id) {
				preco = l.getPreco();
			}
		}
		return preco;
	}
	
	//procurar por um carrinho com determinado nif na lista, se nao existir criar um novo carrinho com esse nif e acrescent�-lo � lista
	//retorna um carrinho cujo �nico atributo � o nif que ficou automaticamente na lita de carrinhos
	public Carrinho devolverCarrinho(int nif) {
		
		Carrinho c1=new Carrinho(nif) ;
		boolean carrinhoExiste=false;
		for (Carrinho c : this.carrinhos) {
//			carrinhoExiste=false;
			if (c.getNif()==nif) {
				c1=c;
				carrinhoExiste=true;
			}
			
		}
		
		if (carrinhoExiste=false) {
			c1.setNif(nif);
			this.carrinhos.add(c1);
		}
		return c1;
	}
	
	public double precoTotalCarrinho(Carrinho c) {
		
		double preco=0;
		
		//importar o conteudo do carrinho para um hashMap chamado hm
		HashMap <Integer,Integer> hm=c.getConteudo();
		
		//Criar um iterador para a key do hashmap para o poder percorrer 
		//num foreach
		Set<Map.Entry<Integer,Integer>> set =hm.entrySet();
		
		//percorrer o hm no foreach de modo a somar todos os pre�os
		for (Map.Entry<Integer, Integer> me : set) {
			for (Livro l : this.livros) {
				if (l.getIdLivro()==me.getKey()) {
					preco+=l.getPreco()*me.getValue();
				}
			}
		}
		
		return preco;
		
	}
	
}
