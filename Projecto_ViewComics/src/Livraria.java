import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Livraria implements Serializable {

	private int idLivraria;
	private String nome;
	private ArrayList<Utilizador> utilizadores;
	private ArrayList<Livro> livros;
	private ArrayList<Transacao> transacoes;
	private ArrayList<Sessao> sessoes;
	private ArrayList<Carrinho> carrinhos;
	 
	
	
	// criar um atributo privado est�tico que � da pr�pria classe

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

	// criar m�todo est�tico para retornar a inst�ncia da classe

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

	public String devolveStock(int idLivro) {
		ArrayList<Livro> livros = this.livros;
		int stockINT = 0;
		for (Livro l : livros) {
			stockINT = l.getStock();
		}
		String stockSTR=Integer.toString(stockINT);
		return stockSTR;
	}

	public void alterarStockLivro(String seleccao, int quantidadeTotal) {

		for (Livro l : this.livros) {
			if (l.toString().equals(seleccao)) {
				l.setStock(quantidadeTotal);
				JOptionPane.showMessageDialog(null, "O stock do livro " + l.getTitulo()
						+ " foi alterado com sucesso. Existem agora " + quantidadeTotal + " exemplares.");
			}
		}
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

	// alterar funcionario
	public void alterarFuncionario(String idSTR, String nome, String contacto, String username, String password) {

		int id = Integer.parseInt(idSTR);
		boolean funcionarioAlterado = false;
		for (Utilizador u : this.utilizadores) {
			if ((u.getId() == id) && (u instanceof Funcionario)) {
				u.setNome(nome);
				u.setContato(contacto);
				u.setUsername(username);
				u.setPassword(password);
				funcionarioAlterado = true;
			}
		}
		if (funcionarioAlterado) {
			JOptionPane.showMessageDialog(null, "Funcion�rio alterado com sucesso");

		} else {
			JOptionPane.showMessageDialog(null, "N�o foi possivel alterar o funcionario");
		}

	}

	// adiciona funcionario
	public void adicionarFuncionario(String nome, String contacto, String username, String password) {

		this.utilizadores.add(new Funcionario(nome, contacto, username, password));

	}

	public void removeLivro(int idLivro, ArrayList<Livro> livros) {

		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getIdLivro() == idLivro) {
				livros.remove(i);
			}
		}

	}

//verifica se o carrinho existe, se n�o existir cria um novo carrinho com o nif introduzido e adiciona-o ao array
	public boolean carrinhoExiste(String nif) {

		for (Carrinho c : this.carrinhos) {
			if (c.getNif().equals(nif)) {
				return true;
			}
		}
		return false;

	}

	// obtem o preco de um livro atraves do seu id, �til para calcular o preco de
	// um carrinho
	public double precoLivro(int id) {

		double preco = 0;
		// procura no array de livros se o id do livro existe, se sim retorna o pre�o
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
	public String precoTotalCarrinho(Carrinho c) {

		double precoTotalDOUBLE = 0;

		for (Livro l : this.livros) {
			if (!c.getConteudo().isEmpty()) {
				if (c.getConteudo().containsKey(l.getIdLivro())) {
					int id = l.getIdLivro();
					precoTotalDOUBLE += precoLivro(id) * (c.getConteudo().get(id));
				}
			} else
				precoTotalDOUBLE = 0;

		}
		DecimalFormat df = new DecimalFormat("#.##");
		String precoTotalSTR = df.format(precoTotalDOUBLE);

		return precoTotalSTR;

	}

	public String totalLivrosCarrinho(Carrinho c) {

		int quantidadeTotalItemsINT = 0;

		if (!c.getConteudo().isEmpty()) {
			HashMap<Integer, Integer> hm = c.getConteudo();
			ArrayList<Integer> quantidade = new ArrayList<Integer>(hm.values());
			for (int q : quantidade) {
				quantidadeTotalItemsINT += q;
			}
		}
		String quantidadeTotalItemsSTR = Integer.toString(quantidadeTotalItemsINT);
		return quantidadeTotalItemsSTR;
	}

	// troco carrinho
	protected double trocoCarrinho(double recebido, double total) {

		double troco = 0;

		troco = recebido - total;

		return troco;

	}

	// listar hashMap(livro e qtd) tendo em conta o nif do cliente
	public String[] listaHashMap(String nif) {

		ArrayList<String> listaC = new ArrayList<String>();

		for (Carrinho c : this.carrinhos) {

			// Loop over String keys.
			for (Entry<Integer, Integer> pair : c.getConteudo().entrySet()) {

				if (c.getNif().equals(nif)) {

					String a = pair.getKey().toString() + "::" + pair.getValue().toString();
					listaC.add(a);

				}
			}
		}

		String[] listalivro = new String[listaC.size()];
		listalivro = listaC.toArray(listalivro);

		return listalivro;

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

	// aletrar um livro
	public void alterarLivro(String selecao, String titulo, String autor, String preco, String stock, String ano,
			String descricao) {

		for (Livro l : this.livros) {
			if (l.toString().equals(selecao)) {
				l.setTitulo(titulo);
				l.setAutor(autor);
				l.setPreco(Double.parseDouble(preco));
				l.setStock(Integer.parseInt(stock));
				l.setAno(Integer.parseInt(ano));
				l.setDescricao(descricao);
			}
		}

	}

	public void criarLivro(String idSTR, String titulo, String autor, String preco, String stock, String ano,
			String descricao) {

		int idINT = Integer.parseInt(idSTR);
		for (Livro l : this.livros) {
			if (l.getIdLivro() == idINT) {
				l.setTitulo(titulo);
				l.setAutor(autor);
				l.setPreco(Double.parseDouble(preco));
				l.setStock(Integer.parseInt(stock));
				l.setAno(Integer.parseInt(ano));
				l.setDescricao(descricao);
			}
		}

	}

	// verifica o utilizador loggado
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

	// alterar username
	public void alterarUsername(String username, char[] pass, String novoUsername) {

		String passSTR = String.valueOf(pass);
		boolean usernameAlterado = false;
		for (Utilizador u : this.utilizadores) {
			if ((u.getUsername().equals(username)) && (u.getPassword().equals(passSTR))) {
				u.setUsername(novoUsername);
				usernameAlterado = true;
			}
		}
		if (usernameAlterado) {
			JOptionPane.showMessageDialog(null, "Alteracao efectuada com sucesso!Novo username: " + novoUsername);
		} else {
			JOptionPane.showMessageDialog(null,
					"N�o foi poss�vel efectuar a altera��o de username, confira os dados inseridos");
		}

	}

	// alterar password
	public void alterarPassword(String username, char[] pass, char[] novaPass, char[] novaPassConfirm) {

		String passSTR = String.valueOf(pass);
		String novaPassSTR = String.valueOf(novaPass);
		String novaPassConfirmSTR = String.valueOf(novaPassConfirm);

		boolean passAlterada = false;

		for (Utilizador u : this.utilizadores) {
			if ((u.getUsername().equals(username)) && (u.getPassword().equals(passSTR))) {
				if (novaPassSTR.equals(novaPassConfirmSTR)) {
					u.setPassword(novaPassSTR);
					passAlterada = true;
				}
			}
		}
		if (passAlterada) {
			JOptionPane.showMessageDialog(null, "Alteracao efectuada com sucesso!A sua pass � agora " + novaPassSTR);
		} else {
			JOptionPane.showMessageDialog(null,
					"N�o foi poss�vel efectuar a altera��o de password, confira os dados inseridos");
		}

	}

	// DISPOR LIVROS NA LISTA POR ARRAY
	// criar uma nova array de livros consoante v�rios atributos
	// util para dispor na lista

	public String[] arrayLivros(ArrayList<Livro> livros) {

		String[] listaLivros = new String[this.livros.size()];

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

		}

		return listaLivros;
	}

//listar livros em array por titulo 
	public String[] listaTitulo(String titulo) {

		ArrayList<String> listaT = new ArrayList<String>();
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

		ArrayList<String> listaA = new ArrayList<String>();
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

	// lista de livros por id
	public String[] listaLivroId(String id) {

		ArrayList<String> listaId = new ArrayList<String>();
		for (Livro l : this.livros) {
			if (Integer.toString(l.getIdLivro()).equals(id)) {
				listaId.add(l.toString());

			}
		}

		String[] ArrayLivrosId = listaId.toArray(new String[listaId.size()]);
		return ArrayLivrosId;

	}

	// m�todo para adicionar um array a uma JList consoante determinado modelo

	protected void addArrayLista(String[] s, DefaultListModel<String> dm) {

		for (int i = 0; i < s.length; i++) {
			dm.addElement(s[i]);
		}
	}

	// extrair o id de uma string da lista
	protected int obterIdLivro(String s) {

		int id = 0;
		if (s != null) {
			for (Livro l : this.livros) {
				if (s.equals(l.toString())) {
					id = l.getIdLivro();
				}
			}
		}
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

		ArrayList<String> utilizadores = new ArrayList();
		ArrayList<Utilizador> utils = util;

		for (Utilizador u : util) {
			utilizadores.add(u.toString());
		}

		String[] utilArray = utilizadores.toArray(new String[utilizadores.size()]);
		return utilArray;

	}

	// id do funcionario
	protected int obterIdFunc(String s) {

		int id = 0;
		for (Utilizador u : this.utilizadores) {
			if ((s.equals(u.toString())) && (u instanceof Funcionario)) {
				id = u.getId();
			}
		}
		return id;

//String subStringId = new String(s.substring(0, s.indexOf(" ")));
//int idint=Integer.parseInt(subStringId);
//return idint;
	}

	// devolve os funcionario cujo come contem a string nome
	public String[] listaFunPorNome(String nome) {

		ArrayList<String> listaN = new ArrayList<String>();
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

	// devolve o funcionario cujo id � igual ao int id
	protected String[] listaFuncPorId(String id) {

		ArrayList<String> listaId = new ArrayList<String>();

		for (Utilizador u : this.utilizadores) {
			if ((u instanceof Funcionario) && (Integer.toString(u.getId()).contains(id))) {
				listaId.add(u.toString());
			}
		}
		String[] listaPorId = new String[listaId.size()];
		listaPorId = listaId.toArray(listaPorId);

		return listaPorId;

	}

	// retornar um funcionario
	protected Utilizador devolveFunc(String seleccao) {

		Utilizador func = new Utilizador();
		if (seleccao != null) {

			for (Utilizador u : this.utilizadores) {
				if ((u.toString().equals(seleccao)) && (u instanceof Funcionario)) {
					func = u;
				}
			}

		}
		return func;
	}

	public void removerUtil(int id, ArrayList<Utilizador> utilizador) {

		for (int i = 0; i < utilizador.size(); i++) {
			if (utilizador.get(i).getId() == id) {
				utilizador.remove(i);
			}
		}
	}

	public void removerLivro(String idSTR, ArrayList<Livro> livros) {

		int idINT = Integer.parseInt(idSTR);

		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getIdLivro() == idINT) {
				livros.remove(i);
			}
		}
	}

	// lista de funcionario por user
	public String[] listaFunPorUsername(String username) {

		ArrayList<String> listaU = new ArrayList<String>();
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

	// lista de funcionario pelo contacto
	protected String[] listaFuncPorContacto(String contacto) {

		ArrayList<String> listaC = new ArrayList<String>();
		for (Utilizador u : this.utilizadores) {
			if ((u instanceof Funcionario) && (u.getContato().contains(contacto))) {
				listaC.add(u.toString());
			}
		}
		String[] listaContacto = new String[listaC.size()];
		listaContacto = listaC.toArray(listaContacto);
		return listaContacto;

	}

//recebe duas strings, soma, e devolve o total em string (CARRINHOS)
	protected String adicionarQuantidade(String actual, String adicionar) {
		String totalStr = actual;
		if ((actual != null) && (adicionar != null)) {
			int actualInt = Integer.valueOf(actual);
			int adicionarInt = Integer.parseInt(adicionar);

			int totalInt = actualInt + adicionarInt;
			totalStr = Integer.toString(totalInt);

		} else {
			totalStr = actual;
		}
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

//adiciona um valor ao stock do livro 

	protected boolean removerCarrinhoPossivel(String qtdremovidaCarrinhoSTR, int idLivro, String nif) {

		boolean remocaoPossivel = false;
		Carrinho c = pesquisarCarrinho(nif);
		int qtdRemovidaCarrinhoINT = Integer.parseInt(qtdremovidaCarrinhoSTR);

		int qtdContidaCarrinhoINT=c.getConteudo().get(idLivro);
		if (qtdRemovidaCarrinhoINT<=qtdContidaCarrinhoINT) {
			remocaoPossivel=true;
		}
		return remocaoPossivel;
	
	}

//altera o stock de um carrinho de acordo com a quantidade removida do carrinho de do id do livro

	protected boolean adicionarAoCarrinhoPossivel(String qtdadicionadaCarrinhoSTR, int idLivro,String stockLivroSTR) {

		boolean adicaoPossivel = false;
		int qtdAdicionadaCarrinhoINT= Integer.parseInt(qtdadicionadaCarrinhoSTR);
		int stockLivroINT =Integer.parseInt(stockLivroSTR);
		
		if (qtdAdicionadaCarrinhoINT<=stockLivroINT) {
			adicaoPossivel =true;
		}
		return adicaoPossivel;

		
	}

//devolve a quantidade de determinado livro em um carrinho atrav�s do id do livro e do nif
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

	// adicionar e remover livros, faz um update
	protected void updateConteudoCarrinho(String nif, int idLivro, int quantidade) {
		for (Carrinho c : this.carrinhos) {
			if (c.getNif().equals(nif)) {
				c.updateCarrinho(idLivro, quantidade);
			}
		}
	}

	// metodo para verificar se o nif esta correcto
	protected boolean verificaNif(String nif) {

		if (nif.matches("([0-9]{9})")) {
			return true;
		} else {
			return false;
		}
	}

	// listar livros em array por data
	public String[] listaData(String ano) {

		ArrayList<String> listaD = new ArrayList<String>();
		String a = "";
		for (Livro l : this.livros) {
			if (Integer.toString(l.getAno()).equals(ano)) {
				a = l.toString();
				listaD.add(a);

			}
		}
		String[] listaData = new String[listaD.size()];
		listaData = listaD.toArray(listaData);

		return listaData;
	}

	// lista dos nifs dos carrinhos/clientes
	protected String[] arrayNifs() {

		String[] nifs = new String[carrinhos.size()];
		String s = "";
		for (int i = 0; i < carrinhos.size(); i++) {
			s = "" + carrinhos.get(i).getNif();
			nifs[i] = s;
			s = "";

		}
		return nifs;
	}

	// listar livros em array por titulo
	public String[] listaNifs(String nif) {

		ArrayList<String> listaT = new ArrayList<String>();
		String t = "";
		for (Carrinho c : this.carrinhos) {
			if (c.getNif().contains(nif)) {
				t = c.toString();
				listaT.add(t);

			}
			t = "";
		}
		String[] listaTitulo = new String[listaT.size()];
		listaTitulo = listaT.toArray(listaTitulo);

		return listaTitulo;
	}

	public Carrinho pesquisarCarrinho(String nif) {

		Carrinho carrinhoNif = new Carrinho();
		for (Carrinho c : this.carrinhos) {
			if (c.getNif().equals(nif)) {
				carrinhoNif = c;
			}
		}
		return carrinhoNif;
	}

	public void carrinhoTabela(Carrinho car, DefaultTableModel dtm) {

		Carrinho c = car;
		ArrayList<Livro> livrosNoCarrinho = new ArrayList<Livro>();
		HashMap<Integer, Integer> hm = c.getConteudo();
		for (Livro l : this.livros) {
			if (!c.getConteudo().isEmpty()) {
				if (c.getConteudo().containsKey(l.getIdLivro())) {
					livrosNoCarrinho.add(l);

				}
			}
		}
		for (Livro l : livrosNoCarrinho) {
			int id = l.getIdLivro();
			String titulo = l.getTitulo();
			String autor = l.getAutor();
			double preco = l.getPreco();
			int quantidade = hm.get(id);
			double precoTotal = hm.get(id) * preco;

			Object[] data = { id, titulo, autor, preco, quantidade, precoTotal };
			dtm.addRow(data);
		}

	}

	public void finalizarCarrinho(Carrinho car) {
		ArrayList<Carrinho> carrinhos = this.carrinhos;

		for (Carrinho c : carrinhos) {
			if ((c == car) && (c.getConteudo() != null)) {
				c.setFinalizado(true);
				car = c;
			}
		}
		if (car.isFinalizado()) {
			JOptionPane.showMessageDialog(null,
					"O carrinho foi dado como finalizado. Dirija-se ao funcionario para proceder ao seu pagamento");
		} else if (!car.isFinalizado()) {

			JOptionPane.showMessageDialog(null,
					"N�o foi poss�vel finalizar o carrinho porque n�o consta na base de dados ou porque ainda se encontra vazio. Confirme o nif introduzido e/ou o conteudo do respectivo carrinho.");
		}

	}

	public String [] carrinhosFinalizados() {
		ArrayList<Carrinho> carrinhos = this.carrinhos;
		ArrayList<String> nifCarrinhosFinalizados = new ArrayList<String>();
		String nifFinalizado="";
		
		for (Carrinho c : carrinhos) {
			if (c.isFinalizado()) {
				nifFinalizado=c.getNif();
				nifCarrinhosFinalizados.add(nifFinalizado);
			}

		}
		String [] finalizados =new String [(nifCarrinhosFinalizados.size())];
		finalizados = nifCarrinhosFinalizados.toArray(finalizados);

		return finalizados;
		
	}
	
	public String [] carrinhosNAOFinalizados() {
		ArrayList<Carrinho> carrinhos = this.carrinhos;
		ArrayList<String> nifCarrinhosNAOFinalizados = new ArrayList<String>();
		String nifNAOFinalizado="";
		
		for (Carrinho c : carrinhos) {
			if (!c.isFinalizado()) {
				nifNAOFinalizado=c.getNif();
				nifCarrinhosNAOFinalizados.add(nifNAOFinalizado);
			}

		}
		String [] naoFinalizados =new String [(nifCarrinhosNAOFinalizados.size())];
		naoFinalizados = nifCarrinhosNAOFinalizados.toArray(naoFinalizados);

		return naoFinalizados;
		
	}
	

// limpa tabela:

	protected void limpatabela(DefaultTableModel model) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

}
