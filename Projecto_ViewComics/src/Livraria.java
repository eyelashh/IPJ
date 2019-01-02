import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultListModel;

public class Livraria implements Serializable {
	//cenas
	private int idLivraria;
	private String nome;
	private ArrayList<Utilizador> utilizadores;
	private ArrayList<Livro> livros;
	private ArrayList<Transacao> transacoes;
	private ArrayList<Sessao> sessoes;
	private ArrayList<Carrinho> carrinhos;
	// criar um atributo privado estático que é da própria classe

	public Livraria() {
		super();
		this.utilizadores = new ArrayList<Utilizador>();
		this.livros = new ArrayList<Livro>();
		this.transacoes = new ArrayList<Transacao>();
		this.sessoes = new ArrayList<Sessao>();
		this.carrinhos = new ArrayList<Carrinho>();

	}

	public Livraria(int idLivraria, String nome, ArrayList<Utilizador> utilizadores, ArrayList<Livro> livros,
			ArrayList<Transacao> transacoes, ArrayList<Sessao> sessoes, ArrayList<Carrinho> carrinhos) {
		super();
		this.idLivraria = idLivraria;
		this.nome = nome;
		this.utilizadores = utilizadores;
		this.livros = livros;
		this.transacoes = transacoes;
		this.sessoes = sessoes;
		this.carrinhos = carrinhos;
	}

	// criar método estático para retornar a instância da classe

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

//verifica se o carrinho existe, se não existir cria um novo carrinho com o nif introduzido e adiciona-o ao array
	public boolean carrinhoExiste(String nif) {
	
		for (Carrinho c : this.carrinhos) {
			if (c.getNif().equals(nif)) {
				return true;
			}
		}
		return false;

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
			String userEntrada = u.getUsername();
			String passEntrada = u.getPassword();
			if ((userEntrada.equals(username)) && (passEntrada.equals(password))) {
				dadosCorrectos = true;
			}
		}
		return dadosCorrectos;

	}

	public Utilizador loggado(String username, String password) {

		Utilizador u_log = new Utilizador();

		for (Utilizador u : this.utilizadores) {
			String usernameIN = u.getUsername();
			String passIN = u.getPassword();
			if ((usernameIN.equals(username)) && (passIN.equals(password))) {
				u_log = u;
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
	// DISPOR LIVROS NA LISTA POR ARRAYLISTS
	// criar uma nova arraylist de livros consoante vários atributos
	// util para dispor na lista

	// POR TITULO
	public String[] arrayLivros(ArrayList<Livro> livros) {

		String[] listaLivros = new String[this.livros.size()];
		String livro = "";
//		for(int i=0; i<livros.size();i++)
//		{
//			livro = ""+livros.get(i).getIdLivro();
//			listaLivros[i]= livro;
//			livro="";
//		}
		int i = 0;
		for (Livro l : livros) {
			listaLivros[i] = l.toString();
			i++;
			livro = "";
		}

		return listaLivros;
	}

//listar livros em array por titulo 
	public String[] listaTitulo(String titulo) {

		ArrayList<String> listaT = new ArrayList();
		String t = "";
		for (Livro l : this.livros) {
			if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
				t = l.toString();
				listaT.add(t);

			}
			t = "";
		}
		String[] listaTitulo = new String[listaT.size()];
		listaTitulo = listaT.toArray(listaTitulo);

		return listaTitulo;
	}

	// listar livros em array por autor
	public String[] listaAutor(String autor) {

		ArrayList<String> listaA = new ArrayList();
		String a = "";
		for (Livro l : this.livros) {
			if (l.getAutor().toLowerCase().contains(autor.toLowerCase())) {
				a = l.toString();
				listaA.add(a);

			}
			a = "";
		}
		String[] listaAutor = new String[listaA.size()];
		listaAutor = listaA.toArray(listaAutor);

		return listaAutor;
	}

	// POR ID
	public String[] listaLivroId(String id) {

		ArrayList<String> listaId = new ArrayList();
		for (Livro l : this.livros) {
			if (Integer.toString(l.getIdLivro()).equals(id)) {
				listaId.add(l.toString());

			}
		}

		String[] ArrayLivrosId = listaId.toArray(new String[listaId.size()]);
		return ArrayLivrosId;

	}

	// método para adicionar um array a uma JList consoante determinado modelo

	protected void addArrayLista(String[] s, DefaultListModel<String> dm) {

		for (int i = 0; i < s.length; i++) {
			dm.addElement(s[i]);
		}
	}

	// extrair o id de uma string da lista

	protected int obterId(String s) {

		int id = 0;
		for (Livro l : this.livros) {
			if (s.equals(l.toString())) {
				id = l.getIdLivro();
			}
		}
		return id;

//String subStringId = new String(s.substring(0, s.indexOf(" ")));
//int idint=Integer.parseInt(subStringId);
//return idint;
	}

	// pesquisar o livro com determinado id
	protected Livro livroId(int id) {
		Livro livro = null;
		for (Livro l : this.livros) {
			if (l.getIdLivro() == id) {
				livro = l;
			}
		}
		return livro;

	}

	// LISTAR FUNCIONARIOS

	// retorna o array de funcionarios
	protected String[] arrayFunc(ArrayList<Utilizador> util) {

		ArrayList<String> func = new ArrayList<String>();

		for (Utilizador u : this.utilizadores) {
			if (u instanceof Funcionario) {
				func.add(u.toString());
			}
		}

		String[] funcArray = func.toArray(new String[func.size()]);
		return funcArray;

	}

	// devolve os funcionario cujo come contem a string nome
	public String[] listaFunPorNome(String nome) {

		ArrayList<String> listaN = new ArrayList();
		String n = "";
		for (Utilizador u : this.utilizadores) {
			if (u instanceof Funcionario) {
				if (u.getNome().toLowerCase().contains(nome.toLowerCase())) {
					n = u.toString();
					listaN.add(n);

				}
			}

			n = "";
		}

		String[] listaTitulo = new String[listaN.size()];
		listaTitulo = listaN.toArray(listaTitulo);

		return listaTitulo;
	}

	// devolve o funcionario cujo id é igual ao int id
	protected String[] listaFuncPorId(String id) {

		ArrayList<String> listaId = new ArrayList();

		for (Utilizador u : this.utilizadores) {
			if ((u instanceof Funcionario) && (Integer.toString(u.getId()).contains(id))) {
				listaId.add(u.toString());
			}
		}
		String[] listaPorId = new String[listaId.size()];
		listaPorId = listaId.toArray(listaPorId);

		return listaPorId;

	}

	public String[] listaFunPorUsername(String username) {

		ArrayList<String> listaU = new ArrayList();
		for (Utilizador u : this.utilizadores) {
			if (u instanceof Funcionario) {
				if (u.getUsername().toLowerCase().contains(username.toLowerCase())) {
					listaU.add(u.toString());

				}
			}
		}

		String[] listaUsername = new String[listaU.size()];
		listaUsername = listaU.toArray(listaUsername);

		return listaUsername;
	}

	protected String[] listaFuncPorContacto(String contacto) {

		ArrayList<String> listaC = new ArrayList();
		for (Utilizador u : this.utilizadores) {
			if ((u instanceof Funcionario) && (Integer.toString(u.getContato()).contains(contacto))) {
				listaC.add(u.toString());
			}
		}
		String[] listaContacto = new String[listaC.size()];
		listaContacto = listaC.toArray(listaContacto);
		return listaContacto;

	}

	protected Utilizador obterFuncionarioComId(String selecaoLista) {
		int idFunc = this.obterId(selecaoLista);
		Utilizador util = null;
		for (Utilizador u : this.utilizadores) {
			if ((u.getId() == idFunc) && (u instanceof Funcionario)) {
				util = u;
			}
		}
		return util;
	}

//recebe duas strings, soma, e devolve o total em string (CARRINHOS)
	protected String adicionarQuantidade(String actual, String adicionar) {
		int actualInt = Integer.parseInt(actual);
		int adicionarInt = Integer.parseInt(adicionar);

		int totalInt = actualInt + adicionarInt;
		String totalStr = Integer.toString(totalInt);
		return totalStr;
	}

//recebe duas string subtrai, e devolve o valor total em string (CARRINHOS)	
	protected String removerQuantidade(String actual, String subtrair) {
		int actualInt = Integer.parseInt(actual);
		int subtrairInt = Integer.parseInt(subtrair);

		int totalInt = actualInt - subtrairInt;
		String totalStr = Integer.toString(totalInt);
		return totalStr;
	}

//devolve a quantidade de determinado livro em um carrinho através do id do livro e do nif
	protected String quantidadeCarrinho(int idLivro, String nif) {

		int quantidadeInt = 0;
		for (Carrinho c : this.carrinhos) {
			if (c.getNif().equals(nif)) {
				quantidadeInt = c.quantidadeLivro(idLivro);

			}
		}

		String quantidadeStr = Integer.toString(quantidadeInt);

		return quantidadeStr;
	}

	protected void updateConteudoCarrinho(String nif, int idLivro, int quantidade) {
		for (Carrinho c : this.carrinhos) {
			if (c.getNif().equals(nif)) {
				c.updateCarrinho(idLivro, quantidade);
			}
		}
	}

	protected boolean verificaNif(String nif) {
		
		if(nif.matches("([0-9]{9})")) {
			return true;
		}
		else {
			return false;
		}
	}

}
