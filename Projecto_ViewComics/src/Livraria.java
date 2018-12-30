import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultListModel;

public class Livraria implements Serializable {

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

	public String[] listaTitulo(String titulo) {

		ArrayList<String> listaT = new ArrayList();
		String t = "";
		for (Livro l : this.livros) {
			if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
				t = "" + l.getIdLivro() + "|" + l.getTitulo();
				listaT.add(t);

			}
			t = "";
		}
		String[] listaTitulo = new String[listaT.size()];
		listaTitulo = listaT.toArray(listaTitulo);

		return listaTitulo;
	}

	// POR AUTOR
	public String[] listaAutor(String autor) {

		ArrayList<String> listaA = new ArrayList();
		String a = "";
		for (Livro l : this.livros) {
			if (l.getAutor().toLowerCase().contains(autor.toLowerCase())) {
				a = "" + l.getIdLivro() + "|" + l.getAutor();
				listaA.add(a);

			}
			a = "";
		}
		String[] listaAutor = new String[listaA.size()];
		listaAutor = listaA.toArray(listaAutor);

		return listaAutor;
	}

	// POR ID
	public ArrayList listaId(int id) {

		ArrayList<Livro> listaId = new ArrayList();
		for (Livro l : this.livros) {
			if (l.getIdLivro() == id) {
				listaId.add(l);

			}
		}
		return listaId;
	}

	// método para adicionar um array a uma JList consoante determinado modelo

	protected void addArrayLista(String[] s, DefaultListModel<String> dm) {

		for (int i = 0; i < s.length; i++) {
			dm.addElement(s[i]);
		}
	}

	// extrair o id de uma string da lista

	protected int obterId(String s) {

//		char a = ' ';
//		int i = 0;
//		while (Character.isDigit(a)) {
//			a = s.charAt(i);
//			i++;
//		}

		String idStr = s.split("(?=\\D)")[0];
		int id = Integer.parseInt(idStr);
		return id;

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

	// devolve os funcionario cujo id é igual ao int id
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

}
