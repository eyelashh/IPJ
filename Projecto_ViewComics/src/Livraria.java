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
	//criar um atributo privado estático que é da própria classe
	public static Livraria soleinstance=new Livraria();

	private Livraria() {
		super();
		this.utilizadores = new ArrayList<Utilizador>();
		this.livros = new ArrayList<Livro>();
		this.transacoes = new ArrayList<Transacao>();
		this.sessoes = new ArrayList<Sessao>();
		this.carrinhos = new ArrayList<Carrinho>();

	}
	private Livraria(int idLivraria, String nome) {
		super();
		this.idLivraria = idLivraria;
		this.nome = nome;
		this.utilizadores = new ArrayList<Utilizador>();
		this.livros = new ArrayList<Livro>();
		this.transacoes = new ArrayList<Transacao>();
		this.sessoes = new ArrayList<Sessao>();
		this.carrinhos = new ArrayList<Carrinho>();
	}
	//criar método estático para retornar a instância da classe
	public static Livraria getInstance() {
		return soleinstance;
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

	// inicia/adiciona uma sessao
	public void addSessao(Sessao s) {
		this.sessoes.add(s);
	}

	public void removeSessao(Sessao s) {
		this.sessoes.remove(s);
	}

	// fecha/remove uma sessao

	// adiciona livro
	public void addLivro(Livro l) {
		this.livros.add(l);
	}

	// remove um livro
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

	// adiciona transaccao
	public void addTransacao(Transacao t) {
		this.transacoes.add(t);
	}

	// adiciona um carrinho
	public void addCarrinho(Carrinho c) {
		this.carrinhos.add(c);
	}

	// remove um carrinho
	public void removeCarrinho(Carrinho c) {
		this.carrinhos.remove(c);
	}

	// obtem o preco de um livro atraves do seu id, ï¿½til para calcular o preco de
	// um carrinho
	public double precoLivro(int id) {

		double preco = 0;
		// procura no array de livros se o id do livro existe, se sim retorna o preï¿½o
		// da uma unidade do livro
		for (Livro l : this.livros) {
			if (l.getIdLivro() == id) {
				preco = l.getPreco();
			}
		}
		return preco;
	}

	// procura por um carrinho com determinado nif na lista
	// se nao existir ---> cria um novo carrinho com esse nif e acrescenta a lista
	// se exisite ---> retorna o carrinho correspondente a esse nif
	public Carrinho pesquisarCarrinho(int nif) {

		Carrinho c1 = new Carrinho(nif);
		boolean carrinhoExiste = false;
		for (Carrinho c : this.carrinhos) {
//			carrinhoExiste=false;
			if (c.getNif() == nif) {
				c1 = c;
				carrinhoExiste = true;
			}

		}

		if (carrinhoExiste = false) {
			c1.setNif(nif);
			this.carrinhos.add(c1);
		}
		return c1;
	}

	// calcula o montante respectivo a um carrinho consoante os livros e a sua
	// quantidade
	public double precoTotalCarrinho(Carrinho c) {

		double preco = 0;

		// importar o conteudo do carrinho para um hashMap chamado hm
		HashMap<Integer, Integer> hm = c.getConteudo();

		// Criar um iterador para a key do hashmap para o poder percorrer
		// num foreach
		Set<Map.Entry<Integer, Integer>> set = hm.entrySet();

		// percorrer o hm no foreach de modo a somar todos os preï¿½os
		for (Map.Entry<Integer, Integer> me : set) {
			for (Livro l : this.livros) {
				if (l.getIdLivro() == me.getKey()) {
					preco += l.getPreco() * me.getValue();
				}
			}
		}

		return preco;

	}

	// metodo para verificar se o username e a password coincidem
	public boolean verificarPassword(String username, String password) {

		boolean dadosCorrectos = false;

		for (Utilizador u : this.utilizadores) {
			if ((u.getUsername().equals(username)) && (u.getPassword().equals(password))) {
				dadosCorrectos = true;
			}
		}
		return dadosCorrectos;

	}
public Utilizador loggado(String username, String password) {
		
		Utilizador u_log=new Utilizador();
		
		for(Utilizador u: this.utilizadores) {
			if ((u.getUsername().equals(username))&&(u.getPassword().equals(password))){
				u_log=u;
			}
		}
		return u_log;
	}

	// metodo que altera o username de um funcionario
	public boolean alterarUsername(int idFuncionario, String novoUsername) {

		boolean usernameAlterado = false;

		for (Sessao s : this.sessoes) {
			if (s.getUser().getId() == idFuncionario) {
				s.getUser().setUsername(novoUsername);
				usernameAlterado = true;

			}

		}
		return usernameAlterado;
	}
	public boolean alterarPassword(int idFuncionario, String novaPassword) {

		boolean passwordAlterada = false;

		for (Sessao s : this.sessoes) {
			if (s.getUser().getId() == idFuncionario) {
				s.getUser().setPassword(novaPassword);
				passwordAlterada = true;

			}

		}
		return passwordAlterada;
	}
}
